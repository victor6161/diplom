package com.diplom.kozlov.shedule;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.dto.SheduleDto;

import com.diplom.kozlov.shedule.view.AddBean;
import com.diplom.kozlov.shedule.view.RowBean;
import com.diplom.kozlov.vessel.VesselController;






public class SheduleDataFacade {
	private SheduleController sheduleController;
	public SheduleDataFacade(SheduleController sheduleController) {
		this.sheduleController = sheduleController;
	}
	private static final Logger LOGGER = Logger.getLogger( SheduleDataFacade .class);
	public void init() {
		
		List<SheduleDto> sheduleDto = sheduleController.getSheduleService().getShedule();
		List<RowBean> rowsBean =new ArrayList<RowBean>();
		for(SheduleDto route:sheduleDto){
			 rowsBean.add(sheduleController.getMapper().dtoToRowBean(route));
		}
		sheduleController.getMainBean().setRowsBean(rowsBean);
		
		
	
		
	}

	public void add() {
		LOGGER.info("add");
		AddBean addBean = sheduleController.getMainBean().getAddBean();
		LOGGER.info(addBean);
		SheduleDto sheduleDto = sheduleController.getMapper().addBeanToDto(addBean);
		LOGGER.info(sheduleDto);
		sheduleController.getSheduleService().save(sheduleDto);
		init();
		
	}

	public void onAddOpen() {
		
		
	}

}
