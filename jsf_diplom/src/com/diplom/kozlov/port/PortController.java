package com.diplom.kozlov.port;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

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
	@Setter
	@Getter
	private String rowsPerPage = "10";

	@PostConstruct
	private void init() {
		LOGGER.info("init");
		facade.init();
	}

	public void edit() {
		LOGGER.info("edit");
		facade.edit();
		RequestContext.getCurrentInstance().execute("PF('updatePortWidget').hide()");
	}

	public void onEditOpen() {
		LOGGER.info("onEditOpen");
		facade.onEditOpen();
	}

	public void add() {
		LOGGER.info("add");
		facade.add();
		RequestContext.getCurrentInstance().execute("PF('addPortWidget').hide()");
	}

	public void onAddOpen() {
		LOGGER.info("onAddOpen");
		facade.onAddOpen();
	}

}
