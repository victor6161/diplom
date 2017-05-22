package com.diplom.kozlov.service;

import java.util.ArrayList;
import java.util.List;

import com.diplom.kozlov.service.view.Compare;

public class ServiceDataFacade {
	private ServiceController serviceController;

	public ServiceDataFacade(ServiceController sheduleController) {
		this.serviceController = sheduleController;
	}

	//private static final Logger LOGGER = Logger.getLogger(SheduleDataFacade.class);

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

	/*	List<SheduleDto> sheduleDto = sheduleController.getSheduleService().getShedule();
		List<RowBean> rowsBean = new ArrayList<RowBean>();
		for (SheduleDto route : sheduleDto) {
			rowsBean.add(sheduleController.getMapper().dtoToRowBean(route));
		}
		sheduleController.getMainBean().setRowsBean(rowsBean);*/
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
