package com.diplom.kozlov.vessel;


import java.util.Random;

import com.diplom.kozlov.db.dto.VesselDto;
import com.diplom.kozlov.vessel.view.AddBean;
import com.diplom.kozlov.vessel.view.EditorBean;
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
		Random random = new Random();
		String [] arr = new String[4];
		arr[0]="St. Peter Line";
		arr[1]="CMA CGM";
		arr[2]="A.P. Moller-Maersk Group";
		arr[3]="NYK Line";
		
		rowBean.setFirm(arr[random.nextInt(arr.length)]);
		String [] arr2 = new String[3];
		arr2[0]="В доке";
		arr2[1]="На рейсе";
		arr2[2]="Свободен";
		
		
		rowBean.setStatus((arr2[random.nextInt(arr2.length)]));
		if(vessel.getDiesel() == 0)
		rowBean.setDiesel("Нет");
		else rowBean.setDiesel("Да");
		if(vessel.getMasut() == 0)
		rowBean.setMasut("Нет");
		else rowBean.setMasut("Да");
	
		return rowBean;
		
	}

	public VesselDto rowBeanToVesselDto(RowBean selectedVessel) {
		VesselDto vesselDto = new VesselDto();
		vesselDto.setId(selectedVessel.getId());
		vesselDto.setType(selectedVessel.getType());
		vesselDto.setLoadCapacity(selectedVessel.getLoadCapacity());
		vesselDto.setFuelConsumption(selectedVessel.getFuelConsumption());
		vesselDto.setAverageSpeed(selectedVessel.getAverageSpeed());
		return vesselDto;
	}

	public EditorBean vesselDtoToEditorBean(VesselDto vesselDto) {
		EditorBean editorBean = new EditorBean();
		editorBean.setId(vesselDto.getId());
		editorBean.setType(vesselDto.getType());
		editorBean.setLoadCapacity(vesselDto.getLoadCapacity());
		editorBean.setAverageSpeed(vesselDto.getAverageSpeed());
		editorBean.setFuelConsumtion(vesselDto.getFuelConsumption());
		return editorBean;
	}

	public VesselDto editorBeanToVesselDto(EditorBean editorBean) {
		VesselDto vesselDto = new VesselDto();
		vesselDto.setId(editorBean.getId());
		vesselDto.setType(editorBean.getType());
		vesselDto.setLoadCapacity(editorBean.getLoadCapacity());
		vesselDto.setAverageSpeed(editorBean.getAverageSpeed());
		vesselDto.setFuelConsumption(editorBean.getFuelConsumtion());
		return vesselDto;
	}

}
