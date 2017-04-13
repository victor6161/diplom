package com.diplom.kozlov.user.order.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.diplom.kozlov.application.CountryBean;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name="mainBean",eager=true)
@SessionScoped
public class MainBean {
	@Setter
	@Getter
	private CountryBean countryBean = new CountryBean();

}
