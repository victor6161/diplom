package com.iba.diplom.kozlov.security.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "mainCredentialsBean", eager = true)
@SessionScoped
public class MainCredentialsBean implements Serializable {
	
	@Setter
	@Getter
	private LoginBean loginBean;
	@Setter
	@Getter
	private RegistrationBean registrationBean;
	public MainCredentialsBean(){
		loginBean = new LoginBean();
		registrationBean = new RegistrationBean();
	}

}
