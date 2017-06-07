package com.diplom.kozlov.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.diplom.kozlov.application.RouteBean;
import com.diplom.kozlov.application.VesselBean;
import com.diplom.kozlov.db.dto.RouteDto;
import com.diplom.kozlov.db.dto.ServiceDto;

import com.diplom.kozlov.service.view.AddBean;
import com.diplom.kozlov.service.view.AddRouteToServiceBean;
import com.diplom.kozlov.service.view.Compare;
import com.diplom.kozlov.service.view.InfoBean;
import com.diplom.kozlov.service.view.RowBean;
import com.diplom.kozlov.service.view.SearchBean;

public class ServiceDataFacade {
	private ServiceController serviceController;

	public ServiceDataFacade(ServiceController sheduleController) {
		this.serviceController = sheduleController;
	}

	private static final Logger LOGGER = Logger.getLogger(ServiceDataFacade.class);

	public void init() {

		LOGGER.info("init");

	}

	public void add() {
		LOGGER.info("add");
		AddBean addBean = serviceController.getMainBean().getAddBean();
		ServiceDto serviceDto = serviceController.getMapper().addBeanToDto(addBean);
		serviceController.getService().save(serviceDto);
		//костыль
		setServiceById(getMaxId());
		serviceController.getMainBean().setSearchBean(new SearchBean());

	}

	private int getMaxId() {
		List<ServiceDto> servicesDto = serviceController.getService().getList();
		int id = servicesDto.get(0).getId();
		for (ServiceDto service : servicesDto) {
			if (service.getId() > id) {
				id = service.getId();
			}
		}

		return id;
	}
	private RowBean getMaxIdRouteService() {
		List<RowBean> rowsBean = serviceController.getMainBean().getRowsBean();
		int id = rowsBean.get(0).getId();
		RowBean result = null;
		for (RowBean rowBean : rowsBean) {
			if (rowBean.getId() > id) {
				id = rowBean.getId();
				result = rowBean;
			}
		}
		return result ;
	}

	public void onCompareOpen() {
		serviceController.getMainBean().setCompareList(new ArrayList<>());
		RowBean selectedRoute = serviceController.getMainBean().getSelectedRoute();
		VesselBean vesselBean = serviceController.getMainBean().getInfoBean().getVesselBean();

		serviceController.getMainBean().getCompareList()
				.add(new Compare("Длина", vesselBean.getLength(), selectedRoute.getLength()));
		serviceController.getMainBean().getCompareList()
				.add(new Compare("Ширина", vesselBean.getWidth(), selectedRoute.getWidth()));
		serviceController.getMainBean().getCompareList().add(new Compare("Водоизмещение", 12000, 15000));

	}

	public void addRouteToService() {
		AddRouteToServiceBean addRouteToServiceBean = serviceController.getMainBean().getAddRouteToServiceBean();
		RouteDto routeDto = serviceController.getMapper().getMapperApplication()
				.routeBeanToDto(addRouteToServiceBean.getRouteBean());
		serviceController.getService().addRoute(routeDto, addRouteToServiceBean.getServiceId());
		setServiceById(addRouteToServiceBean.getServiceId());
	}

	public void onAddRouteToServiceOpen() {
		Integer id = serviceController.getMainBean().getInfoBean().getId();
		serviceController.getMainBean().getAddRouteToServiceBean().setServiceId(id);
		
		List<RouteBean> routesBean = serviceController.getApplication().getListRouteBean();
		
		List<RouteBean> result = new ArrayList<>();
		for (RouteBean routeBean : routesBean) {
			if (routeBean.getPortFrom().equals(getMaxIdRouteService())) {
				result.add(routeBean);
			}
		}
		serviceController.getApplication().setListRouteBean(result);
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
				InfoBean infoBean = serviceController.getMapper().serviceDtoToInfoBean(serviceDto);
				serviceController.getMainBean().setInfoBean(infoBean);
				List<RowBean> rowsBean = new ArrayList<RowBean>();
				for (RouteDto routeDto : serviceDto.getRouteDto()) {
					rowsBean.add(serviceController.getMapper().routeDtoToRowBean(routeDto));
				}
				serviceController.getMainBean().setRowsBean(rowsBean);
			}
		}
	}

}
