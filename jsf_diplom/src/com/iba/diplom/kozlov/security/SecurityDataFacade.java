package com.iba.diplom.kozlov.security;


import java.util.Base64;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.dto.UserDto;



public class SecurityDataFacade {
	private SecurityController sController;

	public SecurityDataFacade(SecurityController pController) {
		this.sController = pController;
	}
	private static final Logger LOGGER = Logger.getLogger(SecurityDataFacade.class);
	
	public String validateUsernamePassword() {
		LOGGER.info("validateUsernamePassword");
		if (checkPassword()) {
			HttpSession session = SessionUtils.getSession();
			LOGGER.info(sController.getMainCredentialsBean().getLoginBean().getLogin());
			session.setAttribute("username",sController.getMainCredentialsBean().getLoginBean().getLogin());
			return "vessel";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			
			return "login";
		}
	}
	
	public String logout() {
		LOGGER.info("logout");
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
	
	private boolean checkPassword() {
		List<UserDto> usersDto = sController.getUserService().getUsers();
		
		for (UserDto userDto : usersDto) {
			
			byte [] barr = Base64.getDecoder().decode(userDto.getPassword());
			String passDB = new String(barr);
			if (sController.getMainCredentialsBean().getLoginBean().getLogin().equals(userDto.getLogin())
					&& sController.getMainCredentialsBean().getLoginBean().getPassword().equals(passDB)) {
				//sController.getApplicationBean().getLoginBean().setRole(userDto.getRole());
				return true;	
			}
		}
		return false;
	}
	
	public String registration() {
		LOGGER.info("registration" + sController.getMainCredentialsBean().getRegistrationBean());
		
		UserDto userDto = sController.getMapper().registrationBeanToUserDto(sController.getMainCredentialsBean().getRegistrationBean());
		sController.getUserService().save(userDto);
		return "login";
	}
	
}
