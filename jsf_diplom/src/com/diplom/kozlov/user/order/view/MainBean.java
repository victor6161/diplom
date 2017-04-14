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
	@Setter
	@Getter
	private PortBeanOrder portBeanOrder;
	
	public MainBean(){
		countryBeanOrder = new CountryBeanOrder();
		portBeanOrder = new PortBeanOrder();
	}
	@PostConstruct
	public void init(){
		countryBeanOrder.setName("Введите страну загрузки");
		portBeanOrder.setName("Введите порт");
	}

}
