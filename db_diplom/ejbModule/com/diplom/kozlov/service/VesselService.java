package com.diplom.kozlov.service;

import java.util.List;

import javax.ejb.Local;

import com.diplom.kozlov.dto.CountryDto;
import com.diplom.kozlov.dto.VesselDto;

@Local
public interface VesselService {
	void save(CountryDto countryDto);
	List<VesselDto> getVessels();

}
