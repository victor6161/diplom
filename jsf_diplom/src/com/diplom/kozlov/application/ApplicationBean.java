package com.diplom.kozlov.application;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;


import com.diplom.kozlov.db.dto.PortDto;

import com.diplom.kozlov.db.service.PortService;
import com.diplom.kozlov.db.service.PortServiceImpl;

import com.diplom.kozlov.db.service.VesselServiceImpl;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "applicationBean", eager = true)
@SessionScoped
public class ApplicationBean {
	private static final Logger LOGGER = Logger.getLogger(ApplicationBean.class);

	
	private PortService portService = new PortServiceImpl();
	private VesselServiceImpl vesselService = new VesselServiceImpl();

	@Setter
	@Getter
	private List<PortBean> listPortBean;
	
	
/*	@Setter
	@Getter
	private List<SheduleBean> listShedule;
	@Setter
	@Getter
	@ManagedProperty(value = "#{mainBeanPort}")
	private MainBean mainBean;*/

	private Mapper mapper = new Mapper();

	public ApplicationBean() {
	
		

	}
	@PostConstruct
	private void init(){
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



/*	public List<CountryBean> byCountry(String autoCompleteText) {
		LOGGER.info("1");
		LOGGER.info(listCountryBean.toString());
		List<CountryBean> results = new ArrayList<>();
		for (CountryBean country : listCountryBean) {
			if (country.getName().contains(autoCompleteText)) {
				results.add(country);
			}
		}
		return results;
	}

	public List<PortBean> byPort(String autoCompleteText) {
		LOGGER.info("byPort");
		List<PortBean> results = new ArrayList<>();

		Integer idCountry = null;
		if (mainBean.getCountryBeanOrder().getId() != null) {

			idCountry = mainBean.getCountryBeanOrder().getId();
		}
		for (PortBean port : listPortBean) {

			if (port.getName().contains(autoCompleteText) && port.getCountryId().equals(idCountry)) {
				results.add(port);
			}

		}
		return results;
	}*/
}
