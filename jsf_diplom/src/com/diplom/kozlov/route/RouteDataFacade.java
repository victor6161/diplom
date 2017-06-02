package com.diplom.kozlov.route;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;

import com.diplom.kozlov.db.dto.RouteDto;
import com.diplom.kozlov.map.MarkerBean;
import com.diplom.kozlov.route.view.AddBean;
import com.diplom.kozlov.route.view.EditorBean;
import com.diplom.kozlov.route.view.RowBean;
import com.diplom.kozlov.route.view.SearchBean;
import com.diplom.kozlov.vessel.VesselController;

public class RouteDataFacade {
	private RouteController routeController;

	public RouteDataFacade(RouteController routeController) {
		this.routeController = routeController;
	}

	private static final Logger LOGGER = Logger.getLogger(RouteDataFacade.class);

	public void init() {
		LOGGER.info("init");
		List<RouteDto> routeDto = routeController.getRouteService().getRoute();
		List<RowBean> rowsBean = new ArrayList<RowBean>();
		for (RouteDto route : routeDto) {
			rowsBean.add(routeController.getMapper().dtoToRowBean(route));
		}
		routeController.getMainBean().setRowsBean(rowsBean);
	}

	public void add() {
		LOGGER.info("add");
		AddBean addBean = routeController.getMainBean().getAddBean();

		RouteDto routeDto = routeController.getMapper().addBeanToDto(addBean);

		routeController.getRouteService().save(routeDto);
		init();

	}

	public void onAddOpen() {
		LOGGER.info("edit");
		routeController.getMainBean().setAddBean(new AddBean());// это
																// обязательно
																// вместе c
																// resetInput

	}

	public void edit() {
		LOGGER.info("edit");
		EditorBean editorBean = routeController.getMainBean().getEditorBean();
		RouteDto routeDto = routeController.getMapper().editorBeanToDto(editorBean);
		routeController.getRouteService().update(routeDto);
		init();
	}

	public void onEditOpen() {
		LOGGER.info("onEditOpen");
		RowBean rowBean = routeController.getMainBean().getSelectedRoute();
		RouteDto routeDto = routeController.getMapper().rowBeanToDto(rowBean);
		EditorBean editorBean = routeController.getMapper().routeDtoToEditorBean(routeDto);
		routeController.getMainBean().setEditorBean(editorBean);

	}

	public void onSearch() {
		SearchBean searchBean = routeController.getMainBean().getSearchBean();
		String portFrom = searchBean.getPortFrom();
		String portTo = searchBean.getPortIn();

		List<RowBean> rowsBean = routeController.getMainBean().getRowsBean();
		List<RowBean> result = new ArrayList<>();
		for (RowBean rowBean : rowsBean) {
			if (rowBean.getPortFrom().getName().equals(portFrom) && rowBean.getPortTo().getName().equals(portTo)) {
				result.add(rowBean);
			}
		}
		routeController.getMainBean().setRowsBean(result);
	}

}
