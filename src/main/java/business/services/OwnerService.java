package business.services;

import model.dto.OwnerModel;
import model.service.GenericService;

import java.util.List;

public class OwnerService {
    private GenericService<OwnerModel> ownerGeneric = new GenericService<OwnerModel>();

    public void addOwner(OwnerModel ownerModel) {
        ownerGeneric.add(ownerModel);
    }

    public void updateOwner(OwnerModel ownerModel) {
        ownerGeneric.update(ownerModel);
    }

    public void deleteDoctor(OwnerModel ownerModel) {
        ownerGeneric.delete(ownerModel);
    }

    public OwnerModel findOwnerById(OwnerModel ownerModel, int id) {
        return ownerGeneric.findById(ownerModel, id);
    }

    public List<OwnerModel> getAllOwners(OwnerModel ownerModel) {
        return ownerGeneric.getAll(ownerModel);
    }
}
