package com.diplom.kozlov.service.view;

import java.util.ArrayList;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.diplom.kozlov.application.VesselBean;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "mainBeanService", eager = true)
@SessionScoped
public class MainBean {
	@Setter
	@Getter
	private List<RowBean> rowsBean;
	@Setter
	@Getter
	private AddBean addBean;
	@Setter
	@Getter
	private RowBean selectedService;
	@Setter
	@Getter
	private EditorBean editorBean;
	@Setter
	@Getter
	private SearchBean searchBean;
	@Setter
	@Getter
	private List<Compare> compareList;
	
	@Setter
	@Getter
	private VesselBean vesselBean;
	
	public MainBean(){
		rowsBean = new ArrayList<>();
		addBean = new AddBean(); 
		searchBean = new SearchBean();
	}

	
}
