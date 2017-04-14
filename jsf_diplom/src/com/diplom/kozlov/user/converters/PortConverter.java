package com.diplom.kozlov.user.converters;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.diplom.kozlov.application.ApplicationBean;

import com.diplom.kozlov.application.Mapper;
import com.diplom.kozlov.application.PortBean;

@FacesConverter("com.diplom.kozlov.user.converters.PortConverter")
public class PortConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent arg1, String value) {
		Mapper mapper = new Mapper();
		ApplicationBean autoCompleteValueBean = null;

		autoCompleteValueBean = (ApplicationBean) fc.getApplication().evaluateExpressionGet(fc, "#{applicationBean}", ApplicationBean.class);
		


		List<PortBean> portBean = autoCompleteValueBean.getListPortBean();
		if (value != null && value.trim().length() > 0) {
			try {
				for (PortBean port : portBean) {
					if (value.equals(String.valueOf(port.getId()))) {
						return mapper.portBeanToBeanOrder(port);
					}
				}
				return null;
			} catch (NumberFormatException e) {
				throw new ConverterException();
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value instanceof PortBean)
			return String.valueOf((((PortBean) value).getId()));
		return null;
	}

}
