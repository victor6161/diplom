package com.diplom.kozlov.vessel;

import com.diplom.kozlov.db.dto.VesselDto;
import com.diplom.kozlov.vessel.view.AddBean;
import com.diplom.kozlov.vessel.view.RowBean;

public class Mapper {
	public VesselDto addBeanToDto(AddBean addBean){
		VesselDto vesselDto = new VesselDto();
		vesselDto.setType(addBean.getType());
		vesselDto.setLoadCapacity(addBean.getLoadCapacity());
		vesselDto.setAverageSpeed(addBean.getAverageSpeed());
		vesselDto.setFuelConsumption(addBean.getFuelConsumtion());
		return vesselDto;
	}

	public RowBean dtoToRowBean(VesselDto vessel) {
		RowBean rowBean = new RowBean();
		rowBean.setId(vessel.getId());
		rowBean.setType(vessel.getType());
		rowBean.setLoadCapacity(vessel.getLoadCapacity());
		rowBean.setFuelConsumption(vessel.getFuelConsumption());
		rowBean.setAverageSpeed(vessel.getAverageSpeed());
		
		return rowBean;
		
	}

}
