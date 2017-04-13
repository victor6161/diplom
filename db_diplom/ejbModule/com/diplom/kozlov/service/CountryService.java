package com.diplom.kozlov.service;

import java.util.List;

import javax.ejb.Local;

import com.diplom.kozlov.dto.CountryDto;

@Local
public interface CountryService {
	
	List<CountryDto> getCountries();
}
