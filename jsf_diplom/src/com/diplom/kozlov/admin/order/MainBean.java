package com.diplom.kozlov.admin.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "mainBeanOrderAdmin", eager = true)
@SessionScoped
public class MainBean {
	@Setter
	@Getter
	private List<Order> orderList = new ArrayList<>(); 
	
	public MainBean(){
		Order order = new Order();
		order.setPortFrom("port1");
		order.setPortTo("port2");
		order.setTotalCost(12);
		order.setDateStart(new Date());
		order.setDateEnd(new Date());
		order.setProduct("valenki");
		
		orderList.add(order);
	}

}
