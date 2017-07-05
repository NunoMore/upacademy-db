package personsAndAcademies.service;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import personsAndAcademies.model.AcademyType;
import personsAndAcademies.view.AcademyTypeBean;

@FacesConverter("academyTypeConverter")
public class AcademyTypeConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                AcademyTypeBean service = (AcademyTypeBean) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("academyTypeBean");
                return service.readAll().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }
	
	@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((AcademyType) object).getID());
        }
        else {
            return null;
        }
    } 
}
