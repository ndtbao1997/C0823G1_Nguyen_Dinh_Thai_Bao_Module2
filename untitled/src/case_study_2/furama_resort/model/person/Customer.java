package case_study_2.furama_resort.model.person;

public class Customer extends Person {
    private String customerCode;
    private String guestType;
    private String address;
    private String bookingDate;

    public Customer() {
    }

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

    public Customer(String customerCode, String guestType, String address, String bookingDate) {
        this.customerCode = customerCode;
        this.guestType = guestType;
        this.address = address;
        this.bookingDate = bookingDate;
    }

    public Customer(String name, String dateOfBirth, String gender, String numberCMND, String phoneNumber, String email, String customerCode, String guestType, String address, String bookingDate) {
        super(name, dateOfBirth, gender, numberCMND, phoneNumber, email);
        this.customerCode = customerCode;
        this.guestType = guestType;
        this.address = address;
        this.bookingDate = bookingDate;
    }

    public Customer(String name, String dateOfBirth, String gender, String numberCMND, String phoneNumber, String email) {
        super(name, dateOfBirth, gender, numberCMND, phoneNumber, email);
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
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
        return super.toString() + "," + customerCode + "," + guestType + "," + address;
    }

}
