package com.diplom.kozlov.db.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.dao.PortDao;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.entity.PortEntity;
import com.diplom.kozlov.entity.VesselEntity;
import com.diplom.kozlov.port.PortDataFacade;

public class PortServiceImpl implements PortService {
	private static final Logger LOGGER = Logger.getLogger(PortServiceImpl.class);
	private PortDao portDao = new PortDao();
	private Mapper mapper = new Mapper();
	@Override
	public List<PortDto> getPorts() {
		LOGGER.info("getPorts");
		List<PortEntity> portEntity = portDao.getPorts();
		List<PortDto> portDto = new ArrayList<>();
		for(PortEntity port:portEntity){
			portDto.add(mapper.portEntityToDto(port));
		}
		return portDto;
	}
	@Override
	public void save(PortDto portDto) {
		LOGGER.info("save");
		PortEntity portEntity = mapper.portDtoToEntity(portDto);
		portDao.save(portEntity);
		
	}
	public void update(PortDto portDto) {
		LOGGER.info("update");
		PortEntity portEntity = mapper.portDtoToEntity(portDto);
		portDao.update(portEntity);
	}

}
