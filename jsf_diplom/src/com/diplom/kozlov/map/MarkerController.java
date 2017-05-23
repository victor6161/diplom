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
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import org.primefaces.model.map.Polyline;

import com.diplom.kozlov.db.dto.MarkerDto;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.RouteDto;
import com.diplom.kozlov.db.service.MarkerServiceImpl;
import com.diplom.kozlov.db.service.PortServiceImpl;
import com.diplom.kozlov.db.service.RouteServiceImpl;
import com.diplom.kozlov.map.view.MarkerPortBean;
import com.diplom.kozlov.port.PortController;

import lombok.Getter;

@ManagedBean
@ViewScoped
public class MarkerController {
	@Getter
	private MapModel simpleModel;
	private static final Logger LOGGER = Logger.getLogger(PortController.class);
	private PortServiceImpl portService = new PortServiceImpl();
	private RouteServiceImpl sheduleService = new RouteServiceImpl();
	@Getter
	private Marker marker;
	private List<MarkerDto> markersForSave = new ArrayList<MarkerDto>();
	private MarkerServiceImpl markerServiceImpl = new MarkerServiceImpl();


	
	

	@PostConstruct
	public void init() {
		LOGGER.info("MarkerSelectionView");
		simpleModel = new DefaultMapModel();
		initPorts();
		initRoutes();

		
	}
	
	private void initPorts(){
		List<PortDto> portDto = portService.getPorts();
		
		LatLng latlng ;
		for (PortDto port : portDto) {
			if (port.getLatitude() != null && port.getLongitude() != null) {
				
				latlng = new LatLng(port.getLatitude(), port.getLongitude()); 
				simpleModel.addOverlay(new Marker(latlng,port.getName(),new MarkerPortBean()));
			}
		}
		

	}
	
	private void initRoutes(){
		
		List<RouteDto> sheduleAll = sheduleService.getRoute();
		LatLng intermediateMarker = null;
		
		
		for (RouteDto sheduleDto : sheduleAll) {
			LatLng portFromLatLng = new LatLng(sheduleDto.getPortFrom().getLatitude(),
					sheduleDto.getPortFrom().getLongitude());
			LatLng portToLatLng = new LatLng(sheduleDto.getPortTo().getLatitude(),
					sheduleDto.getPortTo().getLongitude());

			Polyline polyline = new Polyline();
			polyline.getPaths().add(portFromLatLng);
			
	
			for (MarkerDto markerDto:sheduleDto.getMarkersDto()) {
				double latitude = markerDto.getLatitude();
						
				double longitude = markerDto.getLongitude();
				
			
				intermediateMarker = new LatLng(latitude, longitude);
				polyline.getPaths().add(intermediateMarker);
				//getPathNum используется при set
				simpleModel.addOverlay(new Marker(intermediateMarker, sheduleDto.getId().toString(),
						new MarkerBean(markerDto.getId(), sheduleDto.getId().toString(),markerDto.getPathNum() ),
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
	
	  public void onMarkerSelect(OverlaySelectEvent event) {
	        marker = (Marker) event.getOverlay();
	    }


	public void onMarkerDrag(MarkerDragEvent event) {
		LOGGER.info("onMarkerDrag");
		marker = event.getMarker();

		for (Polyline polyline : simpleModel.getPolylines()) {
			MarkerBean markerInfo = (MarkerBean) marker.getData();
			if (polyline.getData().equals(markerInfo.getPolylineId())) {
				polyline.getPaths().set(markerInfo.getPathNum(),
						new LatLng(marker.getLatlng().getLat(), marker.getLatlng().getLng()));
				markersForSave.add(new MarkerDto(markerInfo.getId(),marker.getLatlng().getLat(), marker.getLatlng().getLng()));
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Marker Dragged Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng(), null));
	}

	
	public void save(){
		LOGGER.info("save");
		markerServiceImpl.update(markersForSave);
		
		
		
	}

}
