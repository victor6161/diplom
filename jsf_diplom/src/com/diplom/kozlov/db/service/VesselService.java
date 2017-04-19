package com.diplom.kozlov.db.service;

import java.util.List;

import com.diplom.kozlov.db.dto.CountryDto;
import com.diplom.kozlov.db.dto.VesselDto;


public interface VesselService {
	void save(VesselDto vesselDto);
	List<VesselDto> getVessels();

}
