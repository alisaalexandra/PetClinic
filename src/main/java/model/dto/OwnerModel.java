package model.dto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Owners")
public class OwnerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PetID")
    private List<PetModel> pets;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int ownerID) {
        this.ownerID = ownerID;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPets(List<PetModel> pets) {
        this.pets = pets;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return ownerID;
    }

    public List<PetModel> getPets() {
        return pets;
    }

    public String getLastName() {
        return lastName;
    }
}
