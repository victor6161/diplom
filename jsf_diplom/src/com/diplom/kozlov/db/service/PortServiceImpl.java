package com.diplom.kozlov.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.dao.PortDao;
import com.diplom.kozlov.db.dto.CountryDto;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.entity.PortEntity;



public class PortServiceImpl  {
	private static final Logger LOGGER = Logger.getLogger(PortServiceImpl.class);
	private PortDao portDao = new PortDao();
	private Mapper mapper = new Mapper();
	
	public List<PortDto> getPorts() {
		LOGGER.info("getPorts");
		List<PortEntity> portEntity = portDao.getPorts();
		List<PortDto> portDto = new ArrayList<>();
		for(PortEntity port:portEntity){
			portDto.add(mapper.portEntityToDto(port));
		}
		return portDto;
	}
	
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
	public List<PortDto> onSearch(CountryDto countryDto) {
		LOGGER.info("onSearch");
		List<PortEntity> portEntity = portDao.getPorts();
		List<PortEntity> portEntityResult = portEntity.stream()
				.filter(port -> port.getCountry().getName().contains(countryDto.getName()) )
				.collect(Collectors.toList());
		List<PortDto> portDto = new ArrayList<>();
		
		portEntityResult.forEach(portEn->portDto.add(mapper.portEntityToDto(portEn)) );
		return portDto;
		
		
	}

}
