package com.diplom.kozlov.application;

import java.util.ArrayList;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import com.diplom.kozlov.db.dto.CountryDto;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.service.CountryService;
import com.diplom.kozlov.db.service.CountryServiceImpl;
import com.diplom.kozlov.db.service.PortService;
import com.diplom.kozlov.db.service.PortServiceImpl;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "applicationBean", eager = true)
@SessionScoped
public class ApplicationBean {
//	private static final Logger LOGGER = Logger.getLogger(ApplicationBean.class);
	//@EJB
	private CountryService countryService = new CountryServiceImpl();
	private PortService portService = new PortServiceImpl();
	@Setter
	@Getter
	private List<CountryBean> listCountryBean;
	@Setter
	@Getter
	private List<PortBean> listPortBean;

	private Mapper mapper = new Mapper();

	public ApplicationBean() {
		listCountryBean = getListCountryBeanDB();
		listPortBean = getListPortBeanDB();
	}

	private List<PortBean> getListPortBeanDB() {
		List<PortDto> portDtoAll = portService.getPorts();
		List<PortBean> portBean = new ArrayList<>();
		for (PortDto portDto : portDtoAll) {
			portBean.add(mapper.portDtoToBean(portDto));
		}
		return portBean;
	}

	private List<CountryBean> getListCountryBeanDB() {
		List<CountryDto> countryDtoAll = countryService.getCountries();
		List<CountryBean> countryBean = new ArrayList<>();
		for (CountryDto countryDto : countryDtoAll) {
			countryBean.add(mapper.countryDtoToBean(countryDto));
		}
		return countryBean;
	}

	

	public List<CountryBean> byCountry(String autoCompleteText) {
	//	LOGGER.info("1");
		//LOGGER.info(listCountryBean.toString());
		List<CountryBean> results = new ArrayList<>();
		for (CountryBean country : listCountryBean) {
			if (country.getName().contains(autoCompleteText)) {
				results.add(country);
			}
		}
		return results;
	}
	public List<PortBean> byPort(String autoCompleteText) {
	//	LOGGER.info("2");
		//LOGGER.info(listPortBean.toString());
		List<PortBean> results = new ArrayList<>();
		for (PortBean port : listPortBean) {
			if (port.getName().contains(autoCompleteText)) {
				results.add(port);
			}
		}
		return results;
	}
}
