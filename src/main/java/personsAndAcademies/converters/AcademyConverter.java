package personsAndAcademies.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import personsAndAcademies.model.Academy;
import personsAndAcademies.view.AcademyBean;

@FacesConverter("academyConverter")
public class AcademyConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	AcademyBean service = (AcademyBean) fc.getELContext().getELResolver().getValue(fc.getELContext(), null,"academyBean");
                return service.getList().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid academy."));
            }
        }
        else {
            return null;
        }
    }
	
	@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Academy) object).getID()-1);
        }
        else {
            return null;
        }
    } 
}
