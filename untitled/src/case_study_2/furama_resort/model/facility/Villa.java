package case_study_2.furama_resort.model.facility;

public class Villa extends House{
    private Double swimmingPoolArea;
    public Villa(){}

    public Villa(Double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public Villa(String roomStandards, Integer numberOfFloors, Double swimmingPoolArea) {
        super(roomStandards, numberOfFloors);
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public Villa(String serviceCode, String serviceName, Double usableArea, Double rentalCosts, Integer maxPeople, String rentalType, String roomStandards, Integer numberOfFloors, Double swimmingPoolArea) {
        super(serviceCode, serviceName, usableArea, rentalCosts, maxPeople, rentalType, roomStandards, numberOfFloors);
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public Double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(Double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    @Override
    public String toString() {
        return super.toString() + ", swimmingPoolArea='" + swimmingPoolArea + '\'';
    }
}
