package petclinic;

public class Appointment {
    private int id;
    private String petName;
    private int petAge;
    private String ownerLastName;
    private String ownerFirstName;
    private String doctorFirstName;
    private String doctorLastName;
    private String date;

    public Appointment(int id, String petName, int petAge, String ownerLastName,
                       String ownerFirstName,
                       String doctorFirstName, String doctorLastName, String date) {
        this.id = id;
        this.petName = petName;
        this.petAge = petAge;
        this.ownerLastName = ownerLastName;
        this.ownerFirstName = ownerFirstName;
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
