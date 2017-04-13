package com.diplom.kozlov.application;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.diplom.kozlov.dto.CountryDto;
import com.diplom.kozlov.service.CountryService;
import com.diplom.kozlov.service.CountryServiceImpl;


import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "applicationBean", eager = true)
@SessionScoped
public class ApplicationBean {
	private static final Logger LOGGER = Logger.getLogger(ApplicationBean.class);
	// @EJB
	private CountryService countryService = new CountryServiceImpl();
	@Setter
	@Getter
	private List<CountryBean> listCountryBean;

	private Mapper mapper = new Mapper();

	public ApplicationBean() {
		listCountryBean = getListCountryBeanDB();
	}

	private List<CountryBean> getListCountryBeanDB() {
		List<CountryDto> countryDtoAll = countryService.getCountries();
		List<CountryBean> countryBean = new ArrayList<>();
		for (CountryDto countryDto : countryDtoAll) {
			countryBean.add(mapper.countryDtoToBean(countryDto));
		}
		return countryBean;
	}

	@Setter
	@Getter
	private String autoCompleteValue;

	public List<String> byCountry(String autoCompleteText) {
		LOGGER.info("1");
	/*	List<String> results = new ArrayList<>();
		for (CountryBean country : listCountryBean) {
			if (country.getName().contains(autoCompleteText)) {
				results.add(country.getName());
			}
		}*/
		List<String> results = new ArrayList<>();
		results.add("test1");
		results.add("test2");
		return results;
	}
}
