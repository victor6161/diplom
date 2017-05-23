package com.diplom.kozlov.db.service;

import java.util.ArrayList;
import java.util.List;

import com.diplom.kozlov.db.dto.CountryDto;
import com.diplom.kozlov.db.dto.MarkerDto;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.RouteDto;
import com.diplom.kozlov.db.dto.UserDto;
import com.diplom.kozlov.db.dto.VesselDto;
import com.diplom.kozlov.entity.CountryEntity;
import com.diplom.kozlov.entity.MarkerEntity;
import com.diplom.kozlov.entity.PortEntity;
import com.diplom.kozlov.entity.RouteEntity;
import com.diplom.kozlov.entity.UserEntity;
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
	/*	countryDto.setPostcode(countryEntity.getPostcode());
		countryDto.setTax(countryEntity.getTax());*/
		
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

	public RouteDto routeEntityToDto(RouteEntity routeEntity) {
		RouteDto routeDto = new RouteDto();
		routeDto.setId(routeEntity.getId());
		routeDto.setPortFrom(portEntityToDto(routeEntity.getPortFrom()));
		routeDto.setPortTo(portEntityToDto(routeEntity.getPortTo()));
		
		
		routeDto.setNumPoints(routeEntity.getNumPoints());
		routeDto.setMarkersDto(markersEntityToDto(routeEntity.getMarkersEntity()));
		return routeDto;
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

	public RouteEntity routeDtoToEntity(RouteDto routeDto) {
		RouteEntity routeEntity = new RouteEntity();
		routeEntity.setId(routeDto.getId());
		routeEntity.setPortFrom(portDtoToEntity(routeDto.getPortFrom()));
		routeEntity.setPortTo(portDtoToEntity(routeDto.getPortTo()));
	
	
		routeEntity.setNumPoints(routeDto.getNumPoints());
		routeEntity.setMarkersEntity(markersDtoToEntity(routeDto.getMarkersDto()));
		
		return routeEntity;
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
	private List<MarkerDto> markersEntityToDto(List<MarkerEntity> markersEntity) {
		List<MarkerDto> markersDto = new ArrayList<>();
		for(MarkerEntity markerEntity : markersEntity){
			Integer id = markerEntity.getId();
			double latitude = markerEntity.getLatitude();
			double longitude = markerEntity.getLongitude();
			int pathNum = markerEntity.getPathNum();
			markersDto.add(new MarkerDto(id,latitude,longitude,pathNum));
		}
		return markersDto;
	}

	public UserEntity userDtoToEntity(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstname(userDto.getFirstname());
		userEntity.setLastname(userDto.getLastname());
		userEntity.setLogin(userDto.getLogin());
		userEntity.setPassword(userDto.getPassword());
		userEntity.setRoleId(1);
		return userEntity;
	}

	public UserDto userEntityToDto(UserEntity user) {
		UserDto userDto = new UserDto();
		userDto.setLogin(user.getLogin());
		userDto.setPassword(user.getPassword());
		return userDto;
	}
	
}
