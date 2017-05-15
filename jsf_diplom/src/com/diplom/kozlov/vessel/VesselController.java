package com.diplom.kozlov.vessel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

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
	}

	public void onEditOpen() {
		LOGGER.info("onEditOpen");
		facade.onEditOpen();

	}

	public void add() {
		facade.add();
		RequestContext.getCurrentInstance().execute("PF('addVesselWidget').hide()");
	}

	public void onAddOpen() {
		facade.onAddOpen();
	}

}
