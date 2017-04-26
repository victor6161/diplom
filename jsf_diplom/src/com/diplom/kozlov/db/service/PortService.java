package com.diplom.kozlov.db.service;

import java.util.List;

import com.diplom.kozlov.db.dto.PortDto;




public interface PortService {
	List<PortDto> getPorts();
	void save(PortDto portDto);
}
