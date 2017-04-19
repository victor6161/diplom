package com.diplom.kozlov.vessel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.service.VesselService;
import com.diplom.kozlov.db.service.VesselServiceImpl;
import com.diplom.kozlov.vessel.view.MainBean;


import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "vesselController", eager = true)
@SessionScoped
public class VesselController {
	private VesselDataFacade facade = new VesselDataFacade(this); 
	
	private static final Logger LOGGER = Logger.getLogger(VesselController.class);
	@Setter
	@Getter
	private Mapper mapper = new Mapper();
	
	@Setter
	@Getter
	@ManagedProperty(value = "#{mainBeanVessel}")
	private MainBean mainBean;
	@Setter
	@Getter
	private VesselServiceImpl vesselService = new VesselServiceImpl();
	
	@PostConstruct
	private void init(){
		LOGGER.info("init");
		facade.init();
	}
	
	public void edit() {
		
	}
	public void onEditOpen() {
			
	}

	public void add() {
		facade.add();
	}
	public void onAddOpen(){
		facade.onAddOpen();
	}

}
