package com.diplom.kozlov.user.order.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import lombok.Getter;
import lombok.Setter;

@ManagedBean(name="mainBeanOrder",eager=true)
@SessionScoped
public class MainBean {
	@Setter
	@Getter
	private CountryBeanOrder countryBeanOrder;
	
	public MainBean(){
		countryBeanOrder = new CountryBeanOrder();
	}
	@PostConstruct
	public void init(){
		countryBeanOrder.setName("default value");
	}

}
