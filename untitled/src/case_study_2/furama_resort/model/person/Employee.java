package case_study_2.furama_resort.model.person;

public class Employee extends Person {
    private String employeeCode;
    private String level;
    private String location;
    private Integer wage;

    public Employee() {
    }

    public Employee(String employeeCode, String level, String location, Integer wage) {
        this.employeeCode = employeeCode;
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public Employee(String name, String dateOfBirth, String gender, String numberCMND, String phoneNumber, String email, String employeeCode, String level, String location, Integer wage) {
        super(name, dateOfBirth, gender, numberCMND, phoneNumber, email);
        this.employeeCode = employeeCode;
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public Employee(String name, String dateOfBirth, String gender, String numberCMND, String phoneNumber, String email) {
        super(name, dateOfBirth, gender, numberCMND, phoneNumber, email);
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return super.toString() + "," + employeeCode + "," + level + "," + location + "," + wage;
    }
}
