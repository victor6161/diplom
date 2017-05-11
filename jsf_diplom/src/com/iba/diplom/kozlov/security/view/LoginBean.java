package com.iba.diplom.kozlov.security.view;



import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class LoginBean implements Serializable {
	@Setter
	@Getter
	private String login;
	@Setter
	@Getter
	private String password;

}
