package com.iba.diplom.kozlov.security.view;



import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class RegistrationBean implements Serializable {

	@Override
	public String toString() {
		return "RegistrationBean [login=" + login + ", password=" + password + ", repeatPassword=" + repeatPassword
				+ "]";
	}
	@Setter
	@Getter
	private String firstname;
	@Setter
	@Getter
	private String lastname;
	@Setter
	@Getter
	private String company;
	@Setter
	@Getter
	private String postcode;
	@Setter
	@Getter
	private String phone;
	@Setter
	@Getter
	private String email;
	@Setter
	@Getter
	private String country;

	
	@Setter
	@Getter
	private String login;
	@Setter
	@Getter
	private String password;
	@Setter
	@Getter
	private String repeatPassword;

	
	

}
