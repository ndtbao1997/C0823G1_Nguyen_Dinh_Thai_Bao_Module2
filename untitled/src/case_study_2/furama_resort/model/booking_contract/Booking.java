package case_study_2.furama_resort.model.booking_contract;

public class Booking implements Comparable<Booking>{
    private String bookingCode;
    private String dateBooking;
    private String rentalStartDate;
    private String rentalEndDate;
    private String customerCode;
    private String facilityCode;

    public Booking() {
    }

    public Booking(String bookingCode, String dateBooking, String rentalStartDate, String rentalEndDate, String customerCode, String facilityCode) {
        this.bookingCode = bookingCode;
        this.dateBooking = dateBooking;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.customerCode = customerCode;
        this.facilityCode = facilityCode;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
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

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

    @Override
    public String toString() {
        return bookingCode + ',' + dateBooking + ',' +
                rentalStartDate + ',' + rentalEndDate + ',' +
                customerCode + ',' + facilityCode;
    }

    @Override
    public int compareTo(Booking o) {
        String[] str1 = this.getRentalStartDate().split("/");
        String[] str2 = o.getRentalStartDate().split("/");
        String[] str3 = this.getRentalEndDate().split("/");
        String[] str4 = o.getRentalEndDate().split("/");
        if (Integer.parseInt(str1[2]) != Integer.parseInt(str2[2])){
            return Integer.compare(Integer.parseInt(str1[2]), Integer.parseInt(str2[1]));
        } else {
            if (Integer.parseInt(str1[1]) != Integer.parseInt(str2[1])) {
                return Integer.compare(Integer.parseInt(str1[1]), Integer.parseInt(str2[1]));
            } else {
                if (Integer.parseInt(str1[0]) != Integer.parseInt(str2[0])) {
                    return Integer.compare(Integer.parseInt(str1[0]), Integer.parseInt(str2[0]));
                } else {
                    if (Integer.parseInt(str3[2]) != Integer.parseInt(str4[2])) {
                        return Integer.compare(Integer.parseInt(str3[2]), Integer.parseInt(str4[2]));
                    } else {
                        if (Integer.parseInt(str3[1]) != Integer.parseInt(str4[1])) {
                            return Integer.compare(Integer.parseInt(str3[1]), Integer.parseInt(str4[1]));
                        } else {
                            return Integer.compare(Integer.parseInt(str3[2]), Integer.parseInt(str4[2]));
                        }
                    }
                }
            }
        }
    }
}
