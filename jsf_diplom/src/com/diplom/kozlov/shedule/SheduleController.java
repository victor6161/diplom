package com.diplom.kozlov.shedule;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import com.diplom.kozlov.db.service.SheduleServiceImpl;
import com.diplom.kozlov.shedule.view.MainBean;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "sheduleController", eager = true)
@SessionScoped
public class SheduleController {
	private SheduleDataFacade facade = new SheduleDataFacade(this); 
	
	private static final Logger LOGGER = Logger.getLogger(SheduleController.class);
	@Setter
	@Getter
	private Mapper mapper = new Mapper();
	
	@Setter
	@Getter
	@ManagedProperty(value = "#{mainBeanShedule}")
	private MainBean mainBean;
	@Setter
	@Getter
	private SheduleServiceImpl sheduleService = new SheduleServiceImpl();
	@Setter
	@Getter
	private String rowsPerPage = "10";
	
	
	@PostConstruct
	private void init(){
		LOGGER.info("init");
		facade.init();
	}
	
	public void edit() {
		LOGGER.info("edit");
		
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
