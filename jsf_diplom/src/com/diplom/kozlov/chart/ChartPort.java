package com.diplom.kozlov.chart;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.diplom.kozlov.db.dto.PortDto;
import com.diplom.kozlov.db.dto.RouteDto;
import com.diplom.kozlov.db.service.PortServiceImpl;
import com.diplom.kozlov.db.service.RouteServiceImpl;
import com.diplom.kozlov.vessel.VesselController;

import lombok.Getter;

@ManagedBean(name = "chartPort", eager = true)
@ViewScoped
public class ChartPort {
	private static final Logger LOGGER = Logger.getLogger(ChartPort.class);
	@Getter
	private BarChartModel barModel;
	private PortServiceImpl portService = new PortServiceImpl();
	private RouteServiceImpl sheduleService = new RouteServiceImpl();

	@PostConstruct
	public void init() {
		createBarModel();

	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Bar Chart");
		barModel.setLegendPosition("ne");
		barModel.setAnimate(true);
		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Порты");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Число судов");
		yAxis.setTickFormat("%d");
		yAxis.setMin(0);
		yAxis.setMax(10);
	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();
		List<RouteDto> listRoutes = sheduleService.getRoute();
		List<PortDto> portDto = portService.getPorts();
		ChartSeries ports = new ChartSeries();
		ports.setLabel("Число судов");
		
		int k = 0;
		for(PortDto port:portDto){
			k=0;
			for(RouteDto route: listRoutes){
				if(route.getPortTo().getId().equals(port.getId())){
					k++;
				}
			}
			LOGGER.info("!!!!!!!!!!!!!!!!!"+k);
			ports.set(port.getName(),k);
		}

		model.addSeries(ports);
		return model;
	}
}
