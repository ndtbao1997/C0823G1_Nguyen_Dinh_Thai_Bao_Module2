package case_study_2.furama_resort.model.booking_contract;

public class Contract {
    private String someContracts;
    private Integer bookingCode;
    private Long advanceDepositAmount;
    private Long totalPaymentAmount;
    public Contract(){}

    public Contract(String someContracts, Integer bookingCode, Long advanceDepositAmount, Long totalPaymentAmount) {
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

    public Integer getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(Integer bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Long getAdvanceDepositAmount() {
        return advanceDepositAmount;
    }

    public void setAdvanceDepositAmount(Long advanceDepositAmount) {
        this.advanceDepositAmount = advanceDepositAmount;
    }

    public Long getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(Long totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "someContracts='" + someContracts + '\'' +
                ", bookingCode=" + bookingCode +
                ", advanceDepositAmount=" + advanceDepositAmount +
                ", totalPaymentAmount=" + totalPaymentAmount +
                '}';
    }
}
