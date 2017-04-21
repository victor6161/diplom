package com.diplom.kozlov.port;



import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.service.PortServiceImpl;
import com.diplom.kozlov.port.view.MainBean;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "portController", eager = true)
@SessionScoped
public class PortController {
	
	private PortDataFacade facade = new PortDataFacade(this); 
	
	private static final Logger LOGGER = Logger.getLogger(PortController.class);
	@Setter
	@Getter
	private Mapper mapper = new Mapper();
	
	@Setter
	@Getter
	@ManagedProperty(value = "#{mainBeanPort}")
	private MainBean mainBean;
	@Setter
	@Getter
	private PortServiceImpl portService = new PortServiceImpl();
	
	@PostConstruct
	private void init(){
		LOGGER.info("init");
		facade.init();
	}
	
	public void edit() {
		
	}
	public void onEditOpen() {
			
	}

/*	public void add() {
		facade.add();
		RequestContext.getCurrentInstance().execute("PF('addVesselWidget').hide()");
	}
	public void onAddOpen(){
		facade.onAddOpen();
	}*/

}
