package personsAndAcademies.view;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import personsAndAcademies.model.Academy;
import personsAndAcademies.service.AcademyService;

@Named("academyConverter")
@RequestScoped
public class AcademyConverter implements Converter {
	@Inject
	private AcademyService academyService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return academyService.findByName(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof Academy) {
			return ((Academy) value).getName();
		}
		return null;
	}

}
