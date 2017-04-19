package com.diplom.kozlov.db.service;

import com.diplom.kozlov.db.dto.CountryDto;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.VesselDto;
import com.diplom.kozlov.entity.CountryEntity;
import com.diplom.kozlov.entity.PortEntity;
import com.diplom.kozlov.entity.VesselEntity;

public class Mapper {
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
		vesselDto.setName(vesselEntity.getName());

		
		return vesselDto;
	}

	public PortDto portEntityToDto(PortEntity portEntity) {
		PortDto portDto = new PortDto();
		portDto.setId(portEntity.getId());
		portDto.setName(portEntity.getName());
		portDto.setCountryId(portEntity.getCountryId());
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
}
