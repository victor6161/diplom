package com.diplom.kozlov.service;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import com.diplom.kozlov.service.view.MainBean;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "serviceController", eager = true)
@SessionScoped
public class ServiceController {
	private ServiceDataFacade facade = new ServiceDataFacade(this); 
	
	private static final Logger LOGGER = Logger.getLogger(ServiceController.class);
	@Setter
	@Getter
	private Mapper mapper = new Mapper();
	
	@Setter
	@Getter
	@ManagedProperty(value = "#{mainBeanService}")
	private MainBean mainBean;

	@Setter
	@Getter
	private String rowsPerPage = "10";
	
	
	@PostConstruct
	private void init(){
		LOGGER.info("init");
		facade.init();
	}
	public void onSearch() {
		
		
		
	}
	public void edit() {
		LOGGER.info("edit");
		facade.edit();
		
	}
	public void onEditOpen() {
		LOGGER.info("onEditOpen");
		facade.onEditOpen();
			
	}
	public void onCompareOpen() {
		LOGGER.info("onCompareOpen");
		facade.onCompareOpen();
			
	}
	public void add() {
		LOGGER.info("add");
		facade.add();
		
	}
	public void onAddOpen(){
		LOGGER.info("onAddOpen");
		facade.onAddOpen();
	}
	

}
