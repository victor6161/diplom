package com.iba.diplom.kozlov.security;

import java.util.Base64;

import com.diplom.kozlov.db.dto.UserDto;
import com.iba.diplom.kozlov.security.view.RegistrationBean;



public class Mapper {
	public UserDto registrationBeanToUserDto(RegistrationBean registrationBean){
		UserDto userDto = new UserDto();
		userDto.setLogin(registrationBean.getLogin());
		
		String password = registrationBean.getPassword();
		byte[] passArrayByte = password.getBytes();
		String encoded = Base64.getEncoder().encodeToString(passArrayByte);
		
		userDto.setPassword(encoded);
		userDto.setFirstname(registrationBean.getFirstname());
		userDto.setLastname(registrationBean.getLastname());
		userDto.setEmail(registrationBean.getEmail());
		
		
		
		return userDto;
	}

}
