package com.diplom.kozlov.db.service;

import java.util.ArrayList;
import java.util.List;

import com.diplom.kozlov.db.dao.CountryDao;
import com.diplom.kozlov.db.dto.CountryDto;
import com.diplom.kozlov.entity.CountryEntity;


public class CountryServiceImpl implements CountryService {
	Mapper mapper = new Mapper();
	CountryDao countryDao = new CountryDao();

	@Override
	public List<CountryDto> getCountries() {
		
		List<CountryEntity> countryEntityAll = countryDao.getCountries();
		List<CountryDto> countryDto = new ArrayList<>();
		for (CountryEntity countryEntity : countryEntityAll) {
			countryDto.add(mapper.countryEntityToDto(countryEntity));
		}
		return countryDto;
	}

}
