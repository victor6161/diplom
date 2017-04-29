package com.diplom.kozlov.map;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polygon;
import org.primefaces.model.map.Polyline;

import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.SheduleDto;
import com.diplom.kozlov.db.service.PortServiceImpl;
import com.diplom.kozlov.db.service.SheduleServiceImpl;
import com.diplom.kozlov.port.PortController;

import lombok.Getter;

@ManagedBean
@ViewScoped
public class MarkerSelectionView {
	@Getter
	private MapModel simpleModel;
	private static final Logger LOGGER = Logger.getLogger(PortController.class);
	private PortServiceImpl portService = new PortServiceImpl();
	private SheduleServiceImpl sheduleService = new SheduleServiceImpl();
	private Marker marker;

	@PostConstruct
	public void init() {
		LOGGER.info("MarkerSelectionView");
		simpleModel = new DefaultMapModel();

		List<PortDto> portDto = portService.getPorts();
		List<LatLng> coord1 = new ArrayList<>();
		for (PortDto port : portDto) {
			if (port.getLatitude() != null && port.getLongitude() != null) {
				coord1.add(new LatLng(port.getLatitude(), port.getLongitude()));
			}
		}
		// port.getLatitude()
		// port.getLongitude()
		// 1 широта
		// 2 долгота
		// Basic marker
		for (LatLng coord : coord1) {
			simpleModel.addOverlay(new Marker(coord, "Konyaalti"));
		}

		List<SheduleDto> sheduleAll = sheduleService.getShedule();
		LatLng intermediateMarker = null;
		for (SheduleDto sheduleDto : sheduleAll) {
			LOGGER.info("1");
			LatLng portFromLatLng = new LatLng(sheduleDto.getPortFrom().getLatitude(),
					sheduleDto.getPortFrom().getLongitude());
			LatLng portToLatLng = new LatLng(sheduleDto.getPortTo().getLatitude(),
					sheduleDto.getPortTo().getLongitude());

			Polyline polyline = new Polyline();
			polyline.getPaths().add(portFromLatLng);
			polyline.getPaths().add(portToLatLng);

			double intermediateLat = (portToLatLng.getLat() + portFromLatLng.getLat()) / 2;
			double intermediateLng = (portToLatLng.getLng() + portFromLatLng.getLng()) / 2;
			intermediateMarker = new LatLng(intermediateLat, intermediateLng);
			simpleModel.addOverlay(new Marker(intermediateMarker, sheduleDto.getId().toString(),
					sheduleDto.getId().toString(), "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));

	

			intermediateMarker = new LatLng((intermediateLat + portFromLatLng.getLat()) / 2,
					(intermediateLng + portFromLatLng.getLng()) / 2);
			simpleModel.addOverlay(new Marker(intermediateMarker, sheduleDto.getId().toString(),
					sheduleDto.getId().toString(), "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));

			intermediateMarker = new LatLng((portToLatLng.getLat() + intermediateLat) / 2,
					(portToLatLng.getLng() + intermediateLng) / 2);
			simpleModel.addOverlay(new Marker(intermediateMarker, sheduleDto.getId().toString(),
					sheduleDto.getId().toString(), "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));

			polyline.setId(sheduleDto.getId().toString());
			polyline.setStrokeWeight(5);
			polyline.setStrokeColor("red");
			polyline.setStrokeOpacity(0.5);
			simpleModel.addOverlay(polyline);

			for (Marker premarker : simpleModel.getMarkers()) {
				premarker.setDraggable(true);
			}
		}
	}

	public void onPointSelect(PointSelectEvent event) {
		LatLng latlng = event.getLatLng();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				event.getSource().toString() + "\nPoint Selected Lat:" + latlng.getLat() + ", Lng:" + latlng.getLng(),
				null));
	}

	public void onMarkerDrag(MarkerDragEvent event) {
		marker = event.getMarker();
		
		for (Polyline polyline : simpleModel.getPolylines()) {
			if (polyline.getId().equals(marker.getTitle())) {
				LOGGER.info("1-if-onMarkerDrag");
				List<LatLng> arr = polyline.getPaths();
				arr.add(new LatLng(marker.getLatlng().getLat(), marker.getLatlng().getLng()));
				polyline.setPaths(arr);
				simpleModel.addOverlay(polyline);

			}
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Marker Dragged Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng(), null));
	}
}
