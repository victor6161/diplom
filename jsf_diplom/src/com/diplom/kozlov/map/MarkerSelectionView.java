package com.diplom.kozlov.map;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
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

		// Shared coordinates
		/*
		 * LatLng coord1 = new LatLng(36.879466, 30.667648); LatLng coord2 = new
		 * LatLng(36.883707, 30.689216); LatLng coord3 = new LatLng(36.879703,
		 * 30.706707); LatLng coord4 = new LatLng(36.885233, 30.702323);
		 */

		// Draggable
		/*
		 * simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));
		 * simpleModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
		 * simpleModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
		 * simpleModel.addOverlay(new Marker(coord4, "Kaleici"));
		 */

		List<SheduleDto> sheduleAll = sheduleService.getShedule();
		LatLng intermediateMarker = null;
		for (SheduleDto sheduleDto : sheduleAll) {
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
			simpleModel.addOverlay(new Marker(intermediateMarker, "zdrasteprivet", "zdrasteprivet",
					"http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));

			intermediateMarker = new LatLng((intermediateLat + portFromLatLng.getLat()) / 2,
					(intermediateLng + portFromLatLng.getLng()) / 2);
			simpleModel.addOverlay(new Marker(intermediateMarker, "zdrasteprivet", "zdrasteprivet",
					"http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));

			intermediateMarker = new LatLng((portToLatLng.getLat() + intermediateLat) / 2,
					(portToLatLng.getLng() + intermediateLng) / 2);
			simpleModel.addOverlay(new Marker(intermediateMarker, "zdrasteprivet", "zdrasteprivet",
					"http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));
		
			polyline.setId(sheduleDto.getId().toString());
			polyline.setStrokeWeight(5);
			polyline.setStrokeColor("red");
			polyline.setStrokeOpacity(0.5);
			simpleModel.addOverlay(polyline);
		}
	}
/*	addMarker(){
		
	}*/

	public void onPolylineSelect(OverlaySelectEvent event) {
		// event.getOverlay().getId();
		for(Polyline pol: simpleModel.getPolylines()){
			if(pol.getId().equals(event.getOverlay().getId())){
				
			}
		}
	
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, event.getOverlay().getId(), null));
	}

	public void onPointSelect(PointSelectEvent event) {
		LatLng latlng = event.getLatLng();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				event.getSource().toString() + "\nPoint Selected Lat:" + latlng.getLat() + ", Lng:" + latlng.getLng(),
				null));
	}
}
