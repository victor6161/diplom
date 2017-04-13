package com.diplom.kozlov.service;

import com.diplom.kozlov.dto.CountryDto;
import com.diplom.kozlov.dto.VesselDto;
import com.diplom.kozlov.entity.CountryEntity;
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
		vesselDto.setType(vesselEntity.getType());
		vesselDto.setName(vesselEntity.getName());

		
		return vesselDto;
	}
}
