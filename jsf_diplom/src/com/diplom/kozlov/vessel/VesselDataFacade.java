package com.diplom.kozlov.vessel;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.VesselDto;
import com.diplom.kozlov.vessel.view.AddBean;
import com.diplom.kozlov.vessel.view.RowBean;

public class VesselDataFacade {
	private static final Logger LOGGER = Logger.getLogger(VesselDataFacade.class);
	private VesselController vesselController;

	public VesselDataFacade(VesselController vesselController) {
		this.vesselController = vesselController;
	}

	public void edit() {
		LOGGER.info("edit");
		VesselDto vesselDto = vesselController.getMapper().editorBeanToVesselDto(vesselController.getMainBean().getEditorBean());
		vesselController.getVesselService().update(vesselDto);
		init();
	}

	public void onEditOpen() {
		LOGGER.info("onEditOpen");
		
		
		VesselDto vesselDto = vesselController.getMapper().rowBeanToVesselDto(vesselController.getMainBean().getSelectedVessel());
		vesselController.getMainBean().setEditorBean(vesselController.getMapper().vesselDtoToEditorBean(vesselDto));

	}

	public void add() {
		AddBean addBean = vesselController.getMainBean().getAddBean();
		VesselDto vesselDto = vesselController.getMapper().addBeanToDto(addBean);
		vesselController.getVesselService().save(vesselDto);
		init();
	}

	public void onAddOpen() {
		vesselController.getMainBean().setAddBean(new AddBean());//прочекать надо ли это
	}

	public void init() {
		LOGGER.info("init");
		
		List<VesselDto> vesselDto = vesselController.getVesselService().getVessels();
		List<RowBean> rowsBean =new ArrayList<RowBean>();
		for(VesselDto vessel:vesselDto){
			 rowsBean.add(vesselController.getMapper().dtoToRowBean(vessel));
		}
		vesselController.getMainBean().setRowsBean(rowsBean);
		
	}
}
