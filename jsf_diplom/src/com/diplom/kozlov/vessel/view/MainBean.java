package com.diplom.kozlov.vessel.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "mainBeanVessel", eager = true)
@SessionScoped
public class MainBean {
	@Setter
	@Getter
	private List<RowBean> rowsBean;
	@Setter
	@Getter
	private AddBean addBean;
	
	public MainBean(){
		rowsBean = new ArrayList<>();
		addBean = new AddBean(); 
	}

	
}
