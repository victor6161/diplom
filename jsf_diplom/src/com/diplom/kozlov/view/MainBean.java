package com.diplom.kozlov.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.diplom.kozlov.dao.VesselDao;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "mainBean", eager = true)
@SessionScoped
public class MainBean {
	@Setter
	@Getter
	private List<VesselBean> vesselBean;
	
	@PostConstruct
	public void init(){
		//vesselBean=new VesselDao().getVessels();
	}
}
