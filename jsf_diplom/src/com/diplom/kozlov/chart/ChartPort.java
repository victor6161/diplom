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
import com.diplom.kozlov.db.dto.SheduleDto;
import com.diplom.kozlov.db.service.PortServiceImpl;
import com.diplom.kozlov.db.service.SheduleServiceImpl;
import com.diplom.kozlov.vessel.VesselController;

import lombok.Getter;

@ManagedBean(name = "chartPort", eager = true)
@ViewScoped
public class ChartPort {
	private static final Logger LOGGER = Logger.getLogger(ChartPort.class);
	@Getter
	private BarChartModel barModel;
	private PortServiceImpl portService = new PortServiceImpl();
	private SheduleServiceImpl sheduleService = new SheduleServiceImpl();

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
		List<SheduleDto> listRoutes = sheduleService.getShedule();
		List<PortDto> portDto = portService.getPorts();
		ChartSeries ports = new ChartSeries();
		ports.setLabel("Число судов");
/*		int k = 0;
		portDto.stream()
		.forEach(port->{
			k=0;
			listShedule.forEach(route-> {
				if(route.getPortTo().getId().equals(port.getId())){
					k++;
				}
			});
			ports.set(port.getName(),k);
		});*/
		int k = 0;
		LOGGER.info(listRoutes);
		LOGGER.info(portDto);
		for(PortDto port:portDto){
			k=0;
			for(SheduleDto route: listRoutes){
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
