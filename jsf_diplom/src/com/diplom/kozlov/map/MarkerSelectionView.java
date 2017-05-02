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

import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

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
			
			double intermediateLat = (portToLatLng.getLat() + portFromLatLng.getLat()) / 2;
			double intermediateLng = (portToLatLng.getLng() + portFromLatLng.getLng()) / 2;
			double latLength = Math.abs(portToLatLng.getLat() - portFromLatLng.getLat());
			double lngLength = Math.abs(portToLatLng.getLng() - portFromLatLng.getLng());
			double len = Math.pow(Math.pow(latLength,2)+ Math.pow(lngLength,2),0.5);
			LOGGER.info(len);
			int res =(int) len*3;
			LOGGER.info(res);
			//rec(portFromLatLng,portToLatLng);
			
			intermediateMarker = new LatLng((intermediateLat + portFromLatLng.getLat()) / 2,
					(intermediateLng + portFromLatLng.getLng()) / 2);
			polyline.getPaths().add(intermediateMarker);
			simpleModel.addOverlay(new Marker(intermediateMarker, sheduleDto.getId().toString(),
					new MarkerInfo(sheduleDto.getId().toString(), 1),
					"http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));
		
			
			
			intermediateMarker = new LatLng(intermediateLat, intermediateLng);
			simpleModel.addOverlay(new Marker(intermediateMarker, sheduleDto.getId().toString(),
					new MarkerInfo(sheduleDto.getId().toString(), 2),
					"http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));
			polyline.getPaths().add(intermediateMarker);
			
	
			
			intermediateMarker = new LatLng((portToLatLng.getLat() + intermediateLat) / 2,
					(portToLatLng.getLng() + intermediateLng) / 2);
			polyline.getPaths().add(intermediateMarker);
			simpleModel.addOverlay(new Marker(intermediateMarker, sheduleDto.getId().toString(),
					new MarkerInfo(sheduleDto.getId().toString(), 3),
					"http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));

			polyline.getPaths().add(portToLatLng);
			polyline.setId(sheduleDto.getId().toString());
			polyline.setStrokeWeight(5);
			polyline.setStrokeColor("red");
			polyline.setStrokeOpacity(0.5);
			polyline.setData(sheduleDto.getId().toString());
			simpleModel.addOverlay(polyline);

			for (Marker premarker : simpleModel.getMarkers()) {
				premarker.setDraggable(true);
			}
		}
	}

/*	private void rec(LatLng portFromLatLng,LatLng portToLatLng) {
		double intermediateLat = (portToLatLng.getLat() + portFromLatLng.getLat()) / 2;
		double intermediateLng = (portToLatLng.getLng() + portFromLatLng.getLng()) / 2;
		
	}
*/


	public void onPointSelect(PointSelectEvent event) {
		LatLng latlng = event.getLatLng();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				event.getSource().toString() + "\nPoint Selected Lat:" + latlng.getLat() + ", Lng:" + latlng.getLng(),
				null));
	}

	public void onMarkerDrag(MarkerDragEvent event) {
		LOGGER.info("onMarkerDrag");
		marker = event.getMarker();

		for (Polyline polyline : simpleModel.getPolylines()) {

			MarkerInfo markerInfo = (MarkerInfo) marker.getData();
			LOGGER.info(markerInfo);

			if (polyline.getData().equals(markerInfo.getId())) {
				LOGGER.info(markerInfo.getPathNum());



				polyline.getPaths().set(markerInfo.getPathNum(), new LatLng(marker.getLatlng().getLat(), marker.getLatlng().getLng()));

			}
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Marker Dragged Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng(), null));
	}

}
