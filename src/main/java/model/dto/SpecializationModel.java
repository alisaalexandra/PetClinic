package model.dto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Specializations")
public class SpecializationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specializationID;

    @Column(name = "Name")
    private int name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "specializations")
    private List<DoctorModel> doctors;
    public void setName(int name) {
        this.name = name;
    }

    public void setId(int specializationID) {
        this.specializationID = specializationID;
    }

    public int getId() {
        return specializationID;
    }

    public int getName() {
        return name;
    }
}
