package com.diplom.kozlov.shedule;

import com.diplom.kozlov.db.dto.SheduleDto;
import com.diplom.kozlov.shedule.view.RowBean;

public class Mapper {

	public RowBean dtoToRowBean(SheduleDto route) {
		RowBean rowBean = new RowBean();
		rowBean.setId(route.getId());
		rowBean.setPortFrom(route.getPortFrom());
		rowBean.setPortTo(route.getPortTo());
		rowBean.setDateFrom(route.getDateFrom());
		rowBean.setDateTo(route.getDateTo());
		rowBean.setVesselId(route.getVesselId());
		return rowBean;
	}
	
}
