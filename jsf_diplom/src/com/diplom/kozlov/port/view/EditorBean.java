package com.diplom.kozlov.port.view;

import com.diplom.kozlov.application.CountryBean;

import lombok.Getter;
import lombok.Setter;

public class EditorBean {
	@Override
	public String toString() {
		return "EditorBean [id=" + id + ", name=" + name + ", countryBean=" + countryBean + "]";
	}
	@Setter
	@Getter
	private Integer id;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private CountryBean countryBean;

}
