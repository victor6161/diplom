package com.diplom.kozlov.shedule.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "mainBeanShedule", eager = true)
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
	private RowBean selectedRoute;
	@Setter
	@Getter
	private EditorBean editorBean;
	public MainBean(){
		
		rowsBean = new ArrayList<>();
		addBean = new AddBean(); 
	}








}
