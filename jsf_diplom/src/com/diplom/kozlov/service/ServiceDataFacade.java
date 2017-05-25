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
import com.diplom.kozlov.service.view.SubRowBean;

public class ServiceDataFacade {
	private ServiceController serviceController;

	public ServiceDataFacade(ServiceController sheduleController) {
		this.serviceController = sheduleController;
	}

	private static final Logger LOGGER = Logger.getLogger(ServiceDataFacade.class);

	public void init() {

		
		LOGGER.info("init");
		List<Compare> compareList = new ArrayList<Compare>();
		compareList.add(new Compare("requarement1", 12.0, 15.0));
		compareList.add(new Compare("requarement1", 17.0, 18.0));
		compareList.add(new Compare("requarement1", 11.0, 15.0));
		compareList.add(new Compare("requarement1", 21.0, 6.0));
		compareList.add(new Compare("requarement1", 12.0, 34.0));
		compareList.add(new Compare("requarement1", 23.0, 43.0));
		compareList.add(new Compare("requarement1", 11.0, 9.0));
		serviceController.getMainBean().setCompareList(compareList);

/*		RowBean rowBean = null;
		for (ServiceDto serviceDto : servicesDto) {
			rowBean = new RowBean(serviceDto.getTitle());
			for (RouteDto routeDto : serviceDto.getRouteDto()) {
				rowBean.getSubRowsBean()
						.add(new SubRowBean(routeDto.getId(), Period.of(0, 2, 3), routeDto.getDistance()));
			}
			serviceController.getMainBean().setRowBean(rowBean);
		}
*/
		
	}

	public void add() {
		LOGGER.info("add");
		AddBean addBean = serviceController.getMainBean().getAddBean();
		LOGGER.info(addBean);
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
		// LOGGER.info("onEditOpen");
		/*
		 * RowBean rowBean = sheduleController.getMainBean().getSelectedRoute();
		 * SheduleDto sheduleDto =
		 * sheduleController.getMapper().rowBeanToDto(rowBean); EditorBean
		 * editorBean =
		 * sheduleController.getMapper().sheduleDtoToEditorBean(sheduleDto);
		 * sheduleController.getMainBean().setEditorBean(editorBean);
		 */

	}

	public void onCompareOpen() {

	}

	public void addBeanToService() {
		AddRouteToServiceBean addRouteToServiceBean = serviceController.getMainBean().getAddRouteToServiceBean();
		RouteDto routeDto = serviceController.getMapper().getMapperApplication().routeBeanToDto(addRouteToServiceBean.getRouteBean());
		serviceController.getService().addRoute(routeDto,addRouteToServiceBean.getServiceId());
	}

	public void onAddBeanToServiceOpen() {
		
		
	}

	public void onSearch() {
		
		Integer id = Integer.parseInt(serviceController.getMainBean().getSearchBean().getServiceId());
		List<ServiceDto> servicesDto = serviceController.getService().getList();
		for(ServiceDto serviceDto:servicesDto){
			if(serviceDto.getId().equals(id)){
				LOGGER.info(serviceDto.getRouteDto());
				RowBean rowBean = serviceController.getMapper().serviceDtoToRowBean(serviceDto);
				LOGGER.info(rowBean.getSubRowsBean());
				serviceController.getMainBean().setRowBean(rowBean);
			}
		}
	}

}
