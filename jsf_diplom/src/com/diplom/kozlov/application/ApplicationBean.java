package com.diplom.kozlov.application;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.dto.CountryDto;
import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.VesselDto;
import com.diplom.kozlov.db.service.CountryServiceImpl;
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
	private CountryServiceImpl countryService = new CountryServiceImpl();
	@Setter
	@Getter
	private List<PortBean> listPortBean;
	@Setter
	@Getter
	private List<CountryBean> listCountryBean;
	@Setter
	@Getter
	private List<VesselBean> listVesselBean;
	
	private Mapper mapper = new Mapper();

	public ApplicationBean() {
		listPortBean = new ArrayList<>();
		listCountryBean = new ArrayList<>();
		listVesselBean = new ArrayList<>();
	}
	@PostConstruct
	private void init(){
		listPortBean = getListPortBeanDB();
		listCountryBean = getListCountryBeanDB();
		listVesselBean = getListVesselBeanDB();
	}

	private List<VesselBean> getListVesselBeanDB() {
		List<VesselDto> vesselDtoAll = vesselService.getVessels();
		List<VesselBean> vesselBean = new ArrayList<>();
		for(VesselDto vessel:vesselDtoAll){
			vesselBean.add(mapper.vesselDtoToBean(vessel));
		}
		return vesselBean;
	}
	private List<PortBean> getListPortBeanDB() {
		List<PortDto> portDtoAll = portService.getPorts();
		List<PortBean> portBean = new ArrayList<>();
		for(PortDto port:portDtoAll){
			portBean.add(mapper.portDtoToBean(port));
		}
		return portBean;
	}
	
	private List<CountryBean> getListCountryBeanDB() {
		List<CountryDto> countryDtoAll = countryService.getCountries();
		List<CountryBean> countryBean = new ArrayList<>();
		
		for(CountryDto port:countryDtoAll){
			countryBean.add(mapper.countryDtoToBean(port));
		}
		return countryBean;
	}



}
