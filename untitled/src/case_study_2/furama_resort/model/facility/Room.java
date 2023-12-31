package case_study_2.furama_resort.model.facility;

public class Room extends Facility {
    private String freeServiceIncluded;

    public Room() {
    }

    public Room(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public Room(String serviceCode, String serviceName, Double usableArea, Double rentalCosts, Integer maxPeople, String rentalType, String freeServiceIncluded) {
        super(serviceCode, serviceName, usableArea, rentalCosts, maxPeople, rentalType);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public Room(Integer numberOfUses, String serviceCode, String serviceName, Double usableArea, Double rentalCosts, Integer maxPeople, String rentalType, String freeServiceIncluded) {
        super(numberOfUses, serviceCode, serviceName, usableArea, rentalCosts, maxPeople, rentalType);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public Room(String serviceCode, String serviceName, Double usableArea, Double rentalCosts, Integer maxPeople, String rentalType) {
        super(serviceCode, serviceName, usableArea, rentalCosts, maxPeople, rentalType);
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return super.toString() + "," + freeServiceIncluded;
    }
}
