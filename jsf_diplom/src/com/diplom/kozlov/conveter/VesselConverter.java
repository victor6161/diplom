package com.diplom.kozlov.conveter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.diplom.kozlov.application.ApplicationBean;
import com.diplom.kozlov.application.PortBean;
import com.diplom.kozlov.application.VesselBean;

@FacesConverter("com.diplom.kozlov.converter.VesselConverter")
public class VesselConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent arg1, String value) {
		ApplicationBean autoCompleteValueBean = null;

		autoCompleteValueBean = (ApplicationBean) fc.getApplication().evaluateExpressionGet(fc, "#{applicationBean}", ApplicationBean.class);
		
		List<VesselBean> vesselBean = autoCompleteValueBean.getListVesselBean();
		if (value != null && value.trim().length() > 0) {
			try {
				for (VesselBean vessel : vesselBean) {
					if (value.equals(String.valueOf(vessel .getId()))) {
						return vessel;
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
		if (value instanceof VesselBean)
			return String.valueOf((((VesselBean) value).getId()));
		return null;
	}

}
