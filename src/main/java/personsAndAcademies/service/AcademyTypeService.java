package personsAndAcademies.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import personsAndAcademies.model.AcademyType;

@Named("academyTypeService")
@RequestScoped
public class AcademyTypeService extends Service<AcademyType>{

}
