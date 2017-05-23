package com.diplom.kozlov.db.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.dao.UserDao;
import com.diplom.kozlov.db.dto.UserDto;
import com.diplom.kozlov.entity.UserEntity;


public class UserServiceImpl {
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl .class);
	Mapper mapper = new Mapper();
	UserDao userDao = new UserDao();

	public void save(UserDto userDto) {
		LOGGER.info("save");
		UserEntity userEntity = mapper.userDtoToEntity(userDto);
		userDao.save(userEntity);
		
	}

	
	public List<UserDto> getUsers() {
		LOGGER.info("getUsers");
		List<UserEntity> userEntity = userDao.getUsers();
		List<UserDto> userDto = new ArrayList<UserDto>();
		userEntity.forEach(user->userDto.add(mapper.userEntityToDto(user)));
		return userDto;
	}
	

}
