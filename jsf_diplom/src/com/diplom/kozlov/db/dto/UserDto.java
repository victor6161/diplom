package com.diplom.kozlov.db.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class UserDto implements Serializable {
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
	

}
