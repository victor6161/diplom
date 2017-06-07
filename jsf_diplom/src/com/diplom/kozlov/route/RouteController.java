package com.diplom.kozlov.route;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import com.diplom.kozlov.db.service.RouteServiceImpl;
import com.diplom.kozlov.route.view.MainBean;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "routeController", eager = true)
@SessionScoped
public class RouteController {
	private RouteDataFacade facade = new RouteDataFacade(this); 
	
	private static final Logger LOGGER = Logger.getLogger(RouteController.class);
	@Setter
	@Getter
	private Mapper mapper = new Mapper();
	
	@Setter
	@Getter
	@ManagedProperty(value = "#{mainBeanRoute}")
	private MainBean mainBean;
	@Setter
	@Getter
	private RouteServiceImpl routeService = new RouteServiceImpl();
	@Setter
	@Getter
	private String rowsPerPage = "10";
	
	
	@PostConstruct
	public void init(){
		LOGGER.info("init");
		facade.init();
	}
	public void onSearch() {
		facade.onSearch();
		
		
	}
	public void edit() {
		LOGGER.info("edit");
		facade.edit();
		
	}
	public void onEditOpen() {
		LOGGER.info("onEditOpen");
		facade.onEditOpen();
			
	}

	public void add() {
		LOGGER.info("add");
		facade.add();
		RequestContext.getCurrentInstance().execute("PF('addRouteWidget').hide()");
	}
	public void onAddOpen(){
		LOGGER.info("onAddOpen");
		facade.onAddOpen();
	}
	

}
