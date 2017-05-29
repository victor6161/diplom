package com.diplom.kozlov.service;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.diplom.kozlov.application.RouteBean;
import com.diplom.kozlov.db.dto.RouteDto;
import com.diplom.kozlov.db.dto.ServiceDto;

import com.diplom.kozlov.service.view.AddBean;
import com.diplom.kozlov.service.view.AddRouteToServiceBean;
import com.diplom.kozlov.service.view.Compare;
import com.diplom.kozlov.service.view.RowBean;


public class ServiceDataFacade {
	private ServiceController serviceController;

	public ServiceDataFacade(ServiceController sheduleController) {
		this.serviceController = sheduleController;
	}

	private static final Logger LOGGER = Logger.getLogger(ServiceDataFacade.class);

	public void init() {

		LOGGER.info("init");


		/*
		 * RowBean rowBean = null; for (ServiceDto serviceDto : servicesDto) {
		 * rowBean = new RowBean(serviceDto.getTitle()); for (RouteDto routeDto
		 * : serviceDto.getRouteDto()) { rowBean.getSubRowsBean() .add(new
		 * SubRowBean(routeDto.getId(), Period.of(0, 2, 3),
		 * routeDto.getDistance())); }
		 * serviceController.getMainBean().setRowBean(rowBean); }
		 */

	}

	public void add() {
		LOGGER.info("add");
		AddBean addBean = serviceController.getMainBean().getAddBean();
		ServiceDto serviceDto = serviceController.getMapper().addBeanToDto(addBean);
		serviceController.getService().save(serviceDto);
		init();
	}

	public void onAddOpen() {
		/*
		 * LOGGER.info("edit"); sheduleController.getMainBean().setAddBean(new
		 * AddBean());
		 */

	}

	public void edit() {
		// LOGGER.info("edit");
		/*
		 * EditorBean editorBean =
		 * sheduleController.getMainBean().getEditorBean(); SheduleDto
		 * sheduleDto =
		 * sheduleController.getMapper().editorBeanToDto(editorBean);
		 * sheduleController.getSheduleService().update(sheduleDto); init();
		 */
	}

	public void onEditOpen() {

	}

	public void onCompareOpen() {
		Integer routeId = serviceController.getMainBean().getSelectedRoute().getId();
		//Integer vesselId = serviceController.getMainBean().getRowBean().getVesselBean().getId();

		Integer id = Integer.parseInt(serviceController.getMainBean().getSearchBean().getServiceId());// очень криво
																										
		ServiceDto serviceDto = serviceController.getService().getServiceById(id);
		RouteDto selectedRoute = null;
		for (RouteDto routeDto : serviceDto.getRouteDto()) {
			if (routeDto.getId().equals(routeId)) {
				selectedRoute = routeDto;
				break;
			}
		}
		serviceDto.getVesselDto();
		
		serviceController.getMainBean().getCompareList().add(new Compare("Length" ,serviceDto.getVesselDto().getLength(),selectedRoute.getLength()));
		serviceController.getMainBean().getCompareList().add(new Compare("width" ,serviceDto.getVesselDto().getWidth(),selectedRoute.getWidth()));
		

	}

	public void addRouteToService() {
		AddRouteToServiceBean addRouteToServiceBean = serviceController.getMainBean().getAddRouteToServiceBean();
		RouteDto routeDto = serviceController.getMapper().getMapperApplication()
				.routeBeanToDto(addRouteToServiceBean.getRouteBean());
		serviceController.getService().addRoute(routeDto, addRouteToServiceBean.getServiceId());
		setServiceById(addRouteToServiceBean.getServiceId());
	}

	public void onAddRouteToServiceOpen() {
		Integer id = serviceController.getMainBean().getRowBean().getId();
		serviceController.getMainBean().getAddRouteToServiceBean().setServiceId(id);

	}

	public void onSearch() {
		LOGGER.info("onSearch");
		Integer id = Integer.parseInt(serviceController.getMainBean().getSearchBean().getServiceId());
		setServiceById(id);
	}

	public void setServiceById(Integer id) {
		List<ServiceDto> servicesDto = serviceController.getService().getList();
		for (ServiceDto serviceDto : servicesDto) {
			if (serviceDto.getId().equals(id)) {
				RowBean rowBean = serviceController.getMapper().serviceDtoToRowBean(serviceDto);
				serviceController.getMainBean().setRowBean(rowBean);
			}
		}
	}

}
