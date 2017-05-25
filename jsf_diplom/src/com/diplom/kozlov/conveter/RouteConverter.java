package com.diplom.kozlov.conveter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.diplom.kozlov.application.ApplicationBean;
import com.diplom.kozlov.application.RouteBean;
import com.diplom.kozlov.application.VesselBean;

@FacesConverter("com.diplom.kozlov.converter.RouteConverter")
public class RouteConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext fc, UIComponent arg1, String value) {
		ApplicationBean autoCompleteValueBean = null;

		autoCompleteValueBean = (ApplicationBean) fc.getApplication().evaluateExpressionGet(fc, "#{applicationBean}", ApplicationBean.class);
		
		List<RouteBean> routeBean = autoCompleteValueBean.getListRouteBean();
		if (value != null && value.trim().length() > 0) {
			try {
				for (RouteBean route : routeBean) {
					if (value.equals(String.valueOf(route.getId()))) {
						return route;
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
		if (value instanceof RouteBean)
			return String.valueOf((((RouteBean) value).getId()));
		return null;
	}

}
