package com.diplom.kozlov.db.service;

import java.util.ArrayList;
import java.util.List;

import com.diplom.kozlov.db.dao.PortDao;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.entity.PortEntity;
import com.diplom.kozlov.entity.VesselEntity;

public class PortServiceImpl implements PortService {
	private PortDao portDao = new PortDao();
	private Mapper mapper = new Mapper();
	@Override
	public List<PortDto> getPorts() {
		List<PortEntity> portEntity = portDao.getPorts();
		List<PortDto> portDto = new ArrayList<>();
		for(PortEntity port:portEntity){
			portDto.add(mapper.portEntityToDto(port));
		}
		return portDto;
	}
	@Override
	public void save(PortDto portDto) {
		PortEntity portEntity = mapper.portDtoToEntity(portDto);
		portDao.save(portEntity);
		
	}

}
