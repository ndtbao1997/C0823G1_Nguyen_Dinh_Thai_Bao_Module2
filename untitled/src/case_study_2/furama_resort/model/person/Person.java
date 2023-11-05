package case_study_2.furama_resort.model.person;

public abstract class Person {
    private String name;
    private String dateOfBirth;
    private String gender;
    private String numberCMND;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String name, String dateOfBirth, String gender, String numberCMND, String phoneNumber, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.numberCMND = numberCMND;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumberCMND() {
        return numberCMND;
    }

    public void setNumberCMND(String numberCMND) {
        this.numberCMND = numberCMND;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + "," + dateOfBirth + "," + gender + "," + numberCMND + "," + phoneNumber + "," + email;
    }
}
