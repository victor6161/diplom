package com.diplom.kozlov.db.service;

import java.util.List;

import com.diplom.kozlov.db.dto.UserDto;


public interface UserService {
	void save(UserDto userDto);
	List<UserDto> getUsers();


}
