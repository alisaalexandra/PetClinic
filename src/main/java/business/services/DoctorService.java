package business.services;

import model.dto.DoctorModel;
import model.service.GenericService;

import java.util.List;

public class DoctorService {
    private GenericService<DoctorModel> doctorGeneric = new GenericService<DoctorModel>();

    public void addDoctor(DoctorModel doctorModel) {
        doctorGeneric.add(doctorModel);
    }

    public void updateDoctor(DoctorModel doctorModel) {
        doctorGeneric.update(doctorModel);
    }

    public void deleteDoctor(DoctorModel doctorModel) {
        doctorGeneric.delete(doctorModel);
    }

    public DoctorModel findDoctorById(DoctorModel doctorModel, int id) {
        return doctorGeneric.findById(doctorModel, id);
    }

    public List<DoctorModel> getAllDoctors(DoctorModel doctorModel) {
        return doctorGeneric.getAll(doctorModel);
    }
}
