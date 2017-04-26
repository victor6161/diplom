package com.diplom.kozlov.conveter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.diplom.kozlov.application.ApplicationBean;
import com.diplom.kozlov.application.CountryBean;



@FacesConverter("com.diplom.kozlov.converter")
public class CountryConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent arg1, String value) {
		ApplicationBean autoCompleteValueBean = null;

		autoCompleteValueBean = (ApplicationBean) fc.getApplication().evaluateExpressionGet(fc, "#{applicationBean}", ApplicationBean.class);
		


		List<CountryBean> countryBean = autoCompleteValueBean.getListCountryBean();
		if (value != null && value.trim().length() > 0) {
			try {
				for (CountryBean country : countryBean) {
					if (value.equals(String.valueOf(country.getId()))) {
						return country;
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
		if (value instanceof CountryBean)
			return String.valueOf((((CountryBean) value).getId()));
		return null;
	}

}
