package com.diplom.kozlov.port;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.dto.CountryDto;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.VesselDto;
import com.diplom.kozlov.port.view.AddBean;
import com.diplom.kozlov.port.view.EditorBean;
import com.diplom.kozlov.port.view.RowBean;

public class PortDataFacade {

	private static final Logger LOGGER = Logger.getLogger(PortDataFacade.class);
	private PortController portController;

	public PortDataFacade(PortController portController) {
		this.portController = portController;
	}

	public void init() {
		LOGGER.info("init");
		List<PortDto> portDto = portController.getPortService().getPorts();
		List<RowBean> rowsBean = new ArrayList<RowBean>();
		for (PortDto port : portDto) {
			rowsBean.add(portController.getMapper().portDtoToRowBean(port));
		}
		portController.getMainBean().setRowsBean(rowsBean);

	}

	public void add() {
		LOGGER.info("add");
		AddBean addBean = portController.getMainBean().getAddBean();
		PortDto portDto = portController.getMapper().addBeanToDto(addBean);
		portController.getPortService().save(portDto);
		init();
	}

	public void onAddOpen() {
		LOGGER.info("onAddOpen");

	}

	public void onEditOpen() {
		LOGGER.info("onEditOpen");
		PortDto portDto = portController.getMapper().rowBeanToPortDto(portController.getMainBean().getSelectedPort());
		portController.getMainBean().setEditorBean(portController.getMapper().portDtoToEditorBean(portDto));
	}

	public void edit() {
		LOGGER.info("edit");
		EditorBean editorBean = portController.getMainBean().getEditorBean();
		PortDto portDto = portController.getMapper().editorBeanToDto(editorBean);
		portController.getPortService().update(portDto);
		init();
	}

	public void onSearch() {
		LOGGER.info("onSearch");
		String country = portController.getMainBean().getSearchBean().getCountryBean();
		CountryDto countryDto = new CountryDto(country);
		List<RowBean> rowsBean = new ArrayList<>();
		List<PortDto> portsDto = portController.getPortService().onSearch(countryDto);
		LOGGER.info(portsDto);
		portsDto.forEach(portDto -> rowsBean.add(portController.getMapper().portDtoToRowBean(portDto)));
		LOGGER.info(rowsBean);
		portController.getMainBean().setRowsBean(rowsBean);
	}

}
