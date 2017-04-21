package com.diplom.kozlov.shedule;

import java.util.ArrayList;
import java.util.List;

import com.diplom.kozlov.db.dto.SheduleDto;
import com.diplom.kozlov.shedule.view.RowBean;





public class SheduleDataFacade {
	private SheduleController sheduleController;
	public SheduleDataFacade(SheduleController sheduleController) {
		this.sheduleController = sheduleController;
	}

	public void init() {
		
		List<SheduleDto> sheduleDto = sheduleController.getSheduleService().getShedule();
		List<RowBean> rowsBean =new ArrayList<RowBean>();
		for(SheduleDto route:sheduleDto){
			 rowsBean.add(sheduleController.getMapper().dtoToRowBean(route));
		}
		sheduleController.getMainBean().setRowsBean(rowsBean);
		
		
	
		
	}

}
