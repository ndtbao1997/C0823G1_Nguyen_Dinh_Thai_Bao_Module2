package case_study_2.furama_resort.model.booking_contract;

public class Contract {
    private String someContracts;
    private String bookingCode;
    private Double advanceDepositAmount;
    private Double totalPaymentAmount;

    public Contract() {
    }

    public Contract(String someContracts, String bookingCode, Double advanceDepositAmount, Double totalPaymentAmount) {
        this.someContracts = someContracts;
        this.bookingCode = bookingCode;
        this.advanceDepositAmount = advanceDepositAmount;
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public String getSomeContracts() {
        return someContracts;
    }

    public void setSomeContracts(String someContracts) {
        this.someContracts = someContracts;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Double getAdvanceDepositAmount() {
        return advanceDepositAmount;
    }

    public void setAdvanceDepositAmount(Double advanceDepositAmount) {
        this.advanceDepositAmount = advanceDepositAmount;
    }

    public Double getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(Double totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    @Override
    public String toString() {
        return someContracts + "," + bookingCode + "," +
                advanceDepositAmount + "," + totalPaymentAmount;
    }
}
