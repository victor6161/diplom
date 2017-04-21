package com.diplom.kozlov.port;

import com.diplom.kozlov.application.PortBean;
import com.diplom.kozlov.db.dto.PortDto;

public class Mapper {
	public PortBean portDtoToBean(PortDto portDto) {
		PortBean portBean = new PortBean();
		portBean.setId(portDto.getId());
		portBean.setName(portDto.getName());
		portBean.setCountryId(portDto.getCountryId());
		return portBean;
	}

}
