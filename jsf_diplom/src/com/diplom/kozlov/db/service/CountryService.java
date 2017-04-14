package com.diplom.kozlov.db.service;

import java.util.List;

import com.diplom.kozlov.db.dto.CountryDto;


public interface CountryService {
	
	List<CountryDto> getCountries();
}
