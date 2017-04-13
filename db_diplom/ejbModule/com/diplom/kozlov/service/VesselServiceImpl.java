package com.diplom.kozlov.service;

import java.util.ArrayList;
import java.util.List;

import com.diplom.kozlov.dao.VesselDao;
import com.diplom.kozlov.dto.CountryDto;
import com.diplom.kozlov.dto.VesselDto;
import com.diplom.kozlov.entity.VesselEntity;

public class VesselServiceImpl implements VesselService {
	Mapper mapper = new Mapper();

	@Override
	public void save(CountryDto countryDto) {

	}

	@Override
	public List<VesselDto> getVessels() {
		List<VesselEntity> vesselEntityAll = new VesselDao().getVessels();
		List<VesselDto> vesselDto = new ArrayList<>();
		for (VesselEntity vesselEntity : vesselEntityAll) {
			vesselDto.add(mapper.vesselEntityToDto(vesselEntity));
		}
		return vesselDto;
	}

}
