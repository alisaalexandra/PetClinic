package business.services;

import model.dto.SpecializationModel;
import model.service.GenericService;

import java.util.List;

public class SpecializationService {
    private GenericService<SpecializationModel> specializationGeneric = new GenericService<SpecializationModel>();

    public void addSpecialization(SpecializationModel specializationModel) {
        specializationGeneric.add(specializationModel);
    }

    public void updateSpecialization(SpecializationModel specializationModel) {
        specializationGeneric.update(specializationModel);
    }

    public void deleteSpecialization(SpecializationModel specializationModel) {
        specializationGeneric.delete(specializationModel);
    }

    public SpecializationModel findSpecializationById(SpecializationModel specializationModel, int id) {
        return specializationGeneric.findById(specializationModel, id);
    }

    public List<SpecializationModel> getAllSpecializations(SpecializationModel specializationModel) {
        return specializationGeneric.getAll(specializationModel);
    }
}
