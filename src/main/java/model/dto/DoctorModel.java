package model.dto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Doctors")
public class DoctorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "SecondName")
    private String secondName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PetID")
    private List<PetModel> pets;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "doctors_specializations", catalog = "petclinic",
            joinColumns = {
                    @JoinColumn(name = "doctorID", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "specializationID", nullable = false, updatable = false)
            })
    private List<SpecializationModel> specializations;

    public void setId(int doctorID) {
        this.doctorID = doctorID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSpecializations(List<SpecializationModel> specializations) {
        this.specializations = specializations;
    }

    public int getId() {
        return doctorID;
    }

    public List<SpecializationModel> getSpecializations() {
        return specializations;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}
