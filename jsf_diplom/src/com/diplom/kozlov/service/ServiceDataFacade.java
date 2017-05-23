package com.diplom.kozlov.service;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

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
		List<Compare> compareList = new ArrayList<Compare>();
		compareList.add(new Compare("requarement1",12.0,15.0));
		compareList.add(new Compare("requarement1",17.0,18.0));
		compareList.add(new Compare("requarement1",11.0,15.0));
		compareList.add(new Compare("requarement1",21.0,6.0));
		compareList.add(new Compare("requarement1",12.0,34.0));
		compareList.add(new Compare("requarement1",23.0,43.0));
		compareList.add(new Compare("requarement1",11.0,9.0));
		serviceController.getMainBean().setCompareList(compareList);

		RowBean rowBean = new RowBean("Service 1");
		Period period = Period.of(0,2,3);
		rowBean.getSubRowsBean().add(new SubRowBean("1", period, 32));
		rowBean.getSubRowsBean().add(new SubRowBean("2", period, 38));
		rowBean.getSubRowsBean().add(new SubRowBean("3", period, 42));
		
		int years = period.getYears()*3;
		int days = period.getDays()*3;
		int months = period.getMonths()*3;
		Period periodAll = period.of(years, months, days);
		rowBean.setAllTime(periodAll);
		serviceController.getMainBean().getRowsBean().add(rowBean);

		RowBean celtics = new RowBean("Service 2");
		celtics.getSubRowsBean().add(new SubRowBean("4", Period.of(0,2,3), 36));
		celtics.getSubRowsBean().add(new SubRowBean("5", Period.of(0,2,3), 32));
		

		serviceController.getMainBean().getRowsBean().add(celtics);
	}

	public void add() {
/*		LOGGER.info("add");
		AddBean addBean = sheduleController.getMainBean().getAddBean();

		SheduleDto sheduleDto = sheduleController.getMapper().addBeanToDto(addBean);
		
		sheduleController.getSheduleService().save(sheduleDto);
		init();*/

	}



	public void onAddOpen() {
	/*	LOGGER.info("edit");
		sheduleController.getMainBean().setAddBean(new AddBean());*/

	}

	public void edit() {
		//LOGGER.info("edit");
/*		EditorBean editorBean = sheduleController.getMainBean().getEditorBean();
		SheduleDto sheduleDto = sheduleController.getMapper().editorBeanToDto(editorBean);
		sheduleController.getSheduleService().update(sheduleDto);
		init();*/
	}

	public void onEditOpen() {
		//LOGGER.info("onEditOpen");
/*		RowBean rowBean = sheduleController.getMainBean().getSelectedRoute();
	 	SheduleDto sheduleDto = sheduleController.getMapper().rowBeanToDto(rowBean);
	 	EditorBean editorBean = sheduleController.getMapper().sheduleDtoToEditorBean(sheduleDto);
	 	sheduleController.getMainBean().setEditorBean(editorBean);*/
	 	
		
	}

	public void onCompareOpen() {
		
		
	}

}
