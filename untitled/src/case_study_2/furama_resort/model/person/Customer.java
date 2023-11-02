package case_study_2.furama_resort.model.person;

public class Customer extends Person{
    private String customerCode;
    private String guestType;
    private String address;
    public Customer(){}

    public Customer(String customerCode, String guestType, String address) {
        this.customerCode = customerCode;
        this.guestType = guestType;
        this.address = address;
    }

    public Customer(String name, String dateOfBirth, String gender, String numberCMND, String phoneNumber, String email, String customerCode, String guestType, String address) {
        super(name, dateOfBirth, gender, numberCMND, phoneNumber, email);
        this.customerCode = customerCode;
        this.guestType = guestType;
        this.address = address;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "customerCode='" + customerCode + '\'' +
                ", guestType='" + guestType + '\'' +
                ", address='" + address + '\''+ ", " + super.toString();
    }
}
