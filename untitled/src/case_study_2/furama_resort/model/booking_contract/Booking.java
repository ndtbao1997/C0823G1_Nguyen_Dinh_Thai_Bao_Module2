package case_study_2.furama_resort.model.booking_contract;

public class Booking {
    private Integer bookingCode;
    private String dateBooking;
    private String rentalStartDate;
    private String rentalEndDate;
    private Integer customerCode;
    private Integer facilityCode;
    public Booking(){}

    public Booking(Integer bookingCode, String dateBooking, String rentalStartDate, String rentalEndDate, Integer customerCode, Integer facilityCode) {
        this.bookingCode = bookingCode;
        this.dateBooking = dateBooking;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.customerCode = customerCode;
        this.facilityCode = facilityCode;
    }

    public Integer getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(Integer bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public String getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(String rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public String getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(String rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public Integer getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(Integer customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(Integer facilityCode) {
        this.facilityCode = facilityCode;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode=" + bookingCode +
                ", dateBooking='" + dateBooking + '\'' +
                ", rentalStartDate='" + rentalStartDate + '\'' +
                ", rentalEndDate='" + rentalEndDate + '\'' +
                ", customerCode=" + customerCode +
                ", facilityCode=" + facilityCode +
                '}';
    }
}
