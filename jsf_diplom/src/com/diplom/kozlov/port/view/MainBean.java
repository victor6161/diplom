package com.diplom.kozlov.port.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "mainBeanPort", eager = true)
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
	private EditorBean editorBean;
	@Setter
	@Getter
	private SearchBean searchBean;
	
	@Setter
	@Getter
	private RowBean selectedPort;
	
	public MainBean(){
		rowsBean = new ArrayList<>();
		addBean = new AddBean();
	}
	
}
