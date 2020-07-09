package model.dto;

import javax.persistence.*;

@Entity
@Table(name = "Pets")
public class PetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petID;

    @Column(name = "Age")
    private double age;

    @Column(name = "Name")
    private String name;

    @Column(name = "Breadth")
    private String breadth;

    @Column(name = "Problem")
    private String problem;

    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "DoctorID")
    private DoctorModel doctor;

    @OneToMany(cascade = CascadeType.ALL)
    private OwnerModel owner;

    public void setId(int petID) {
        this.petID = petID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setBreadth(String breadth) {
        this.breadth = breadth;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public int getId() {
        return petID;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public String getBreadth() {
        return breadth;
    }

    public String getProblem() {
        return problem;
    }
}
