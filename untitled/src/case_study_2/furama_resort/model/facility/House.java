package case_study_2.furama_resort.model.facility;

public class House extends Facility {
    private String roomStandards;
    private Integer numberOfFloors;
    public House(){}

    public House(String roomStandards, Integer numberOfFloors) {
        this.roomStandards = roomStandards;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String serviceCode, String serviceName, Double usableArea, Double rentalCosts, Integer maxPeople, String rentalType, String roomStandards, Integer numberOfFloors) {
        super(serviceCode, serviceName, usableArea, rentalCosts, maxPeople, rentalType);
        this.roomStandards = roomStandards;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return super.toString() + ", roomStandards='" + roomStandards + '\'' +
                ", numberOfFloors='" + numberOfFloors + '\'';
    }
}
