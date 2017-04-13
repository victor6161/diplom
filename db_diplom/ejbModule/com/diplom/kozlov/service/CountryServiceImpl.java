package com.diplom.kozlov.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.diplom.kozlov.dao.CountryDao;
import com.diplom.kozlov.dto.CountryDto;
import com.diplom.kozlov.entity.CountryEntity;

@Stateless
public class CountryServiceImpl implements CountryService {
	Mapper mapper = new Mapper();


	@Override
	public List<CountryDto> getCountries() {
		
		List<CountryEntity> countryEntityAll = new CountryDao().getCountries();
		List<CountryDto> countryDto = new ArrayList<>();
		for (CountryEntity countryEntity : countryEntityAll) {
			countryDto.add(mapper.countryEntityToDto(countryEntity));
		}
		return countryDto;
	}

}
