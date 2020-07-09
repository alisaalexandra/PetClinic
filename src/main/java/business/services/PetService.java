package business.services;

import model.dto.PetModel;
import model.service.GenericService;

import java.util.List;

public class PetService {

    private GenericService<PetModel> petGeneric = new GenericService<PetModel>();

    public void addPet(PetModel petModel) {
        petGeneric.add(petModel);
    }

    public void updatePet(PetModel petModel) {
        petGeneric.update(petModel);
    }

    public void deletePet(PetModel petModel) {
        petGeneric.delete(petModel);
    }

    public PetModel findPetById(PetModel petModel, int id) {
        return petGeneric.findById(petModel, id);
    }

    public List<PetModel> getAllPets(PetModel petModel) {
        return petGeneric.getAll(petModel);
    }
}
