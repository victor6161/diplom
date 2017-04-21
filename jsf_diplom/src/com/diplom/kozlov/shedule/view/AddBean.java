package com.diplom.kozlov.shedule.view;

import com.diplom.kozlov.application.PortBean;

import lombok.Getter;
import lombok.Setter;

public class AddBean {
	@Setter
	@Getter
	private PortBean portFrom;
	@Setter
	@Getter
	private PortBean portTo;

}
