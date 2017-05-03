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

	private final double part = 8;
	
	

	@PostConstruct
	public void init() {
		LOGGER.info("MarkerSelectionView");
		simpleModel = new DefaultMapModel();
		initPorts();
		initRoutes();

		
	}
	
	private void initPorts(){
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
	}
	
	private void initRoutes(){
		List<SheduleDto> sheduleAll = sheduleService.getShedule();
		LatLng intermediateMarker = null;
		for (SheduleDto sheduleDto : sheduleAll) {
			LatLng portFromLatLng = new LatLng(sheduleDto.getPortFrom().getLatitude(),
					sheduleDto.getPortFrom().getLongitude());
			LatLng portToLatLng = new LatLng(sheduleDto.getPortTo().getLatitude(),
					sheduleDto.getPortTo().getLongitude());

			Polyline polyline = new Polyline();
			polyline.getPaths().add(portFromLatLng);

			int pathNum = 0;
			double additive = 1 / part;
			for (double i = 0; i < 1; i = i + additive) {
				double latitude = sheduleDto.getPortFrom().getLatitude() * (1 - i)
						+ sheduleDto.getPortTo().getLatitude() * i;
				double longitude = sheduleDto.getPortFrom().getLongitude() * (1 - i)
						+ sheduleDto.getPortTo().getLongitude() * i;
				pathNum++;
			
				intermediateMarker = new LatLng(latitude, longitude);
				polyline.getPaths().add(intermediateMarker);
				simpleModel.addOverlay(new Marker(intermediateMarker, sheduleDto.getId().toString(),
						new MarkerInfo(sheduleDto.getId().toString(), pathNum),
						"http://digital.designnewengland.com/images/navbar/autoPlayStop.png"));
			}

	
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
	



	public void onMarkerDrag(MarkerDragEvent event) {
		LOGGER.info("onMarkerDrag");
		marker = event.getMarker();

		for (Polyline polyline : simpleModel.getPolylines()) {
			MarkerInfo markerInfo = (MarkerInfo) marker.getData();
			if (polyline.getData().equals(markerInfo.getPolylineId())) {
				polyline.getPaths().set(markerInfo.getPathNum(),
						new LatLng(marker.getLatlng().getLat(), marker.getLatlng().getLng()));
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Marker Dragged Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng(), null));
	}

}
