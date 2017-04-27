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
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.service.PortServiceImpl;
import com.diplom.kozlov.port.PortController;

import lombok.Getter;

@ManagedBean
@ViewScoped
public class MarkerSelectionView {
	@Getter
	private MapModel simpleModel;
	private static final Logger LOGGER = Logger.getLogger(PortController.class);
	private PortServiceImpl portService = new PortServiceImpl();

	@PostConstruct
	public void init() {
		LOGGER.info("MarkerSelectionView");
		simpleModel = new DefaultMapModel();

		List<PortDto> portDto = portService.getPorts();
		List<LatLng> coord1 = new ArrayList<>();

		for (PortDto port : portDto) {
			if (port.getLatitude() != null && port.getLongitude() != null) {
				LOGGER.info("for"+port.getLatitude()+":"+port.getLongitude());
				coord1.add(new LatLng(port.getLatitude(), port.getLongitude()));
			}
		}
		// 1 широта
		// 2 долгота

		// Basic marker
		for (LatLng coord : coord1) {
			simpleModel.addOverlay(new Marker(coord, "Konyaalti"));
		}
	}
}
