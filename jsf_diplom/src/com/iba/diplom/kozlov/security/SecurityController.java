package com.iba.diplom.kozlov.security;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


import org.apache.log4j.Logger;

import com.diplom.kozlov.db.service.UserServiceImpl;
import com.iba.diplom.kozlov.security.view.MainCredentialsBean;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "securityController", eager = true)
@SessionScoped
public class SecurityController {
	@Setter
	@Getter
	@ManagedProperty(value = "#{mainCredentialsBean}")
	private MainCredentialsBean mainCredentialsBean;

	@Setter
	@Getter
	private Mapper mapper = new Mapper();

	@Setter
	@Getter
	private UserServiceImpl userService = new UserServiceImpl();

	private SecurityDataFacade dataFacade = new SecurityDataFacade(this);

	private static final Logger LOGGER = Logger.getLogger(SecurityController.class);

	public String validateUsernamePassword() {
		LOGGER.info("validateUsernamePassword");
		return dataFacade.validateUsernamePassword();
	}

	public String logout() {
		LOGGER.info("logout");
		return dataFacade.logout();
	}
	public String registration() {
		LOGGER.info("registration");
		return dataFacade.registration();
	}


}
