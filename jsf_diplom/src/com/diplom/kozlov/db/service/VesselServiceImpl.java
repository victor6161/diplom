package com.diplom.kozlov.db.service;

import java.util.ArrayList;
import java.util.List;

import com.diplom.kozlov.db.dao.VesselDao;
import com.diplom.kozlov.db.dto.CountryDto;
import com.diplom.kozlov.db.dto.VesselDto;
import com.diplom.kozlov.entity.VesselEntity;

public class VesselServiceImpl implements VesselService {
	Mapper mapper = new Mapper();
	VesselDao vesselDao = new VesselDao();

	@Override
	public void save(VesselDto vesselDto) {
		VesselEntity vesselEntity = mapper.vesselDtoToEntity(vesselDto);
		vesselDao.save(vesselEntity);
	}

	@Override
	public List<VesselDto> getVessels() {
		List<VesselEntity> vesselEntityAll = vesselDao.getVessels();
		List<VesselDto> vesselDto = new ArrayList<>();
		for (VesselEntity vesselEntity : vesselEntityAll) {
			vesselDto.add(mapper.vesselEntityToDto(vesselEntity));
		}
		return vesselDto;
	}

	public void update(VesselDto vesselDto) {
		VesselEntity vesselEntity = mapper.vesselDtoToEntity(vesselDto);
		vesselDao.update(vesselEntity);
	}

}
