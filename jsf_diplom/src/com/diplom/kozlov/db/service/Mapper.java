package com.diplom.kozlov.db.service;

import com.diplom.kozlov.db.dto.CountryDto;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.SheduleDto;
import com.diplom.kozlov.db.dto.VesselDto;
import com.diplom.kozlov.entity.CountryEntity;
import com.diplom.kozlov.entity.PortEntity;
import com.diplom.kozlov.entity.SheduleEntity;
import com.diplom.kozlov.entity.VesselEntity;

public class Mapper {
	public CountryEntity countryDtoToEntity(CountryDto countryDto){
		CountryEntity countryEntity = new CountryEntity();
		countryEntity.setId(countryDto.getId());
		countryEntity.setName(countryDto.getName());
		return countryEntity;
	}
	
	public CountryDto countryEntityToDto(CountryEntity countryEntity){
		CountryDto countryDto = new CountryDto();
		countryDto.setId(countryEntity.getId());
		countryDto.setName(countryEntity.getName());
		countryDto.setPostcode(countryEntity.getPostcode());
		countryDto.setTax(countryEntity.getTax());
		
		return countryDto;
	}

	public VesselDto vesselEntityToDto(VesselEntity vesselEntity){
		VesselDto vesselDto = new VesselDto();
		vesselDto.setId(vesselEntity.getId());
		vesselDto.setType(vesselEntity.getType());
	
		vesselDto.setAverageSpeed(vesselEntity.getAverageSpeed());
		vesselDto.setFuelConsumption(vesselEntity.getFuelConsumption());
		vesselDto.setLoadCapacity(vesselEntity.getLoadCapacity());
		
		return vesselDto;
	}

	public PortDto portEntityToDto(PortEntity portEntity) {
		PortDto portDto = new PortDto();
		portDto.setId(portEntity.getId());
		portDto.setName(portEntity.getName());
		portDto.setCountryDto(countryEntityToDto(portEntity.getCountry()));
		return portDto;
	}

	public VesselEntity vesselDtoToEntity(VesselDto vesselDto) {
		VesselEntity vesselEntity = new VesselEntity();
		vesselEntity.setId(vesselDto.getId());
		vesselEntity.setType(vesselDto.getType());
		vesselEntity.setLoadCapacity(vesselDto.getLoadCapacity());
		vesselEntity.setAverageSpeed(vesselDto.getAverageSpeed());
		vesselEntity.setFuelConsumption(vesselDto.getFuelConsumption());
		return vesselEntity;
	}

	public SheduleDto sheduleEntityToDto(SheduleEntity sheduleEntity) {
		SheduleDto sheduleDto = new SheduleDto();
		sheduleDto.setId(sheduleEntity.getId());
		sheduleDto.setPortFrom(sheduleEntity.getPortFrom().getName());
		sheduleDto.setPortTo(sheduleEntity.getPortTo().getName());
		sheduleDto.setDateFrom(sheduleEntity.getDateFrom());
		sheduleDto.setDateTo(sheduleEntity.getDateTo());
		sheduleDto.setVesselId(sheduleEntity.getVessel().getId());
		return sheduleDto;
	}

	public PortEntity portDtoToEntity(PortDto portDto) {
		PortEntity portEntity = new PortEntity();
		portEntity.setCountry(countryDtoToEntity(portDto.getCountryDto()));
		portEntity.setName(portDto.getName());
		return portEntity;
	}
	
	
}
