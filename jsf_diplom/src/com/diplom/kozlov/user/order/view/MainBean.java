package com.diplom.kozlov.user.order.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "mainBeanOrder", eager = true)
@SessionScoped
public class MainBean {
	@Setter
	@Getter
	private CountryBeanOrder countryBeanOrder;
	@Setter
	@Getter
	private PortBeanOrder portBeanOrder;
	@Setter
	@Getter
	private CountryBeanOrder countryBeanOrderUnloading;
	@Setter
	@Getter
	private PortBeanOrder portBeanOrderUnloading;
	@Setter
	@Getter
	private List<String> weightList = new ArrayList<>();
	@Setter
	@Getter
	private List<String> typeList = new ArrayList<>();
	@Setter
	@Getter
	private String size;
	@Setter
	@Getter
	private String weight;
	@Setter
	@Getter
	private String type;

	public MainBean() {
		countryBeanOrder = new CountryBeanOrder();
		portBeanOrder = new PortBeanOrder();
		countryBeanOrderUnloading = new CountryBeanOrder();
		portBeanOrderUnloading = new PortBeanOrder();
	

	}

	@PostConstruct
	public void init() {

	}

}
