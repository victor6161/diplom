package com.diplom.kozlov.db.service;

import java.util.ArrayList;
import java.util.List;

import com.diplom.kozlov.db.dto.CountryDto;
import com.diplom.kozlov.db.dto.MarkerDto;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.SheduleDto;
import com.diplom.kozlov.db.dto.VesselDto;
import com.diplom.kozlov.entity.CountryEntity;
import com.diplom.kozlov.entity.MarkerEntity;
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
		portDto.setLatitude(portEntity.getLatitude());
		portDto.setLongitude(portEntity.getLongitude());
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
		sheduleDto.setPortFrom(portEntityToDto(sheduleEntity.getPortFrom()));
		sheduleDto.setPortTo(portEntityToDto(sheduleEntity.getPortTo()));
		
		sheduleDto.setDateFrom(sheduleEntity.getDateFrom());
		sheduleDto.setDateTo(sheduleEntity.getDateTo());
		sheduleDto.setVesselDto( vesselEntityToDto(sheduleEntity.getVessel()));
		return sheduleDto;
	}

	public PortEntity portDtoToEntity(PortDto portDto) {
		PortEntity portEntity = new PortEntity();
		portEntity.setCountry(countryDtoToEntity(portDto.getCountryDto()));
		portEntity.setName(portDto.getName());
		portEntity.setId(portDto.getId());
		portEntity.setLatitude(portDto.getLatitude());
		portEntity.setLongitude(portDto.getLongitude());
		return portEntity;
	}

	public SheduleEntity sheduleDtoToEntity(SheduleDto sheduleDto) {
		SheduleEntity sheduleEntity = new SheduleEntity();
		sheduleEntity.setPortFrom(portDtoToEntity(sheduleDto.getPortFrom()));
		sheduleEntity.setPortTo(portDtoToEntity(sheduleDto.getPortTo()));
		sheduleEntity.setDateFrom(sheduleDto.getDateFrom());
		sheduleEntity.setDateTo(sheduleDto.getDateTo());
		sheduleEntity.setVessel(vesselDtoToEntity(sheduleDto.getVesselDto()));
		sheduleEntity.setNumPoints(sheduleDto.getNumPoints());
		sheduleEntity.setMarkersEntity(markersDtoToEntity(sheduleDto.getMarkersDto()));
		
		return sheduleEntity;
	}

	private List<MarkerEntity> markersDtoToEntity(List<MarkerDto> markersDto) {
		List<MarkerEntity> markersEntity = new ArrayList<>();
		for(MarkerDto markerDto : markersDto){
			double latitude = markerDto.getLatitude();
			double longitude = markerDto.getLongitude();
			int pathNum = markerDto.getPathNum();
			markersEntity.add(new MarkerEntity(latitude,longitude,pathNum));
		}
		return markersEntity;
	}
	
}
