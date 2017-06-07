package com.diplom.kozlov.phaseListener;

import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import com.diplom.kozlov.application.ApplicationBean;
import com.diplom.kozlov.port.PortController;
import com.diplom.kozlov.route.RouteController;
import com.diplom.kozlov.service.ServiceController;
import com.diplom.kozlov.vessel.VesselController;

public class CustomPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	ApplicationBean applBean = null;
	RouteController routeController = null;
	PortController portController = null;
	ServiceController serviceController = null;
	VesselController vesselController = null;
	
	
	@Override
	public void afterPhase(PhaseEvent arg0) {
		
		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		PartialViewContext pvc = FacesContext.getCurrentInstance().getPartialViewContext();
		if(!pvc.isAjaxRequest()){
			applBean = (ApplicationBean) FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
					"#{applicationBean}", ApplicationBean.class);
			applBean.init();
			routeController = (RouteController) FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
					"#{routeController}", RouteController.class);
			routeController.init();
			portController = (PortController) FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
					"#{portController}", PortController.class);
			portController.init();
			serviceController = (ServiceController) FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
					"#{serviceController}", ServiceController.class);
			serviceController.init();
			vesselController = (VesselController) FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
					"#{vesselController}", VesselController.class);
			vesselController.init();
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}
	

}
