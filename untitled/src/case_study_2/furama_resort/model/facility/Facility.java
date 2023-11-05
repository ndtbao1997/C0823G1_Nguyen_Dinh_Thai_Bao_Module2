package case_study_2.furama_resort.model.facility;

public abstract class Facility {
    private Integer numberOfUses;
    private String serviceCode;
    private String serviceName;
    private Double usableArea;
    private Double rentalCosts;
    private Integer maxPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceCode, String serviceName, Double usableArea, Double rentalCosts, Integer maxPeople, String rentalType) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maxPeople = maxPeople;
        this.rentalType = rentalType;
    }

    public Facility(Integer numberOfUses, String serviceCode, String serviceName, Double usableArea, Double rentalCosts, Integer maxPeople, String rentalType) {
        this.numberOfUses = numberOfUses;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maxPeople = maxPeople;
        this.rentalType = rentalType;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(Double usableArea) {
        this.usableArea = usableArea;
    }

    public Double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(Double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return numberOfUses + "," + serviceCode + "," + serviceName + "," + usableArea + "," + rentalCosts + "," + maxPeople +
                "," + rentalType;
    }
}
