package case_study_2.furama_resort.view;

import case_study_2.furama_resort.controller.*;
import case_study_2.furama_resort.model.facility.Facility;
import case_study_2.furama_resort.model.facility.House;
import case_study_2.furama_resort.model.facility.Room;
import case_study_2.furama_resort.model.facility.Villa;
import case_study_2.furama_resort.untils.enum_furama.EnumFurama;
import case_study_2.furama_resort.untils.validate.FacilityInforExample;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FuramaFacilityManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FacilityController facilityController = new FacilityController();

    public static void displayFacilityManagement() {
        int choice;
        try {
            do {
                System.out.println("1.Display list facility\n" +
                        "2.Add new facility\n" +
                        "3.Display list facility maintenance\n" +
                        "4.Delete facility\n" +
                        "5.Return main menu");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayListFacility();
                        break;
                    case 2:
                        addNewFacility();
                        break;
                    case 3:
                        displayListFacilityMaintenance();
                        break;
                    case 4:
                        deleteFacility();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Xin vui lòng nhập lại\n");
                }
            } while (true);
        } catch (Exception e) {
            System.err.println("Thao tác không hợp lệ!!!\n");
        }
    }

    public static void deleteFacility() {
        System.out.println("Hãy nhập mã dịch vụ bạn muốn xóa");
        String serviceCode;
        do {
            serviceCode = scanner.nextLine();
            if (FacilityInforExample.validateServiceCode(serviceCode) && facilityController.checkObjectCode(serviceCode)) {
                confirmDeleteFacility(serviceCode);
                return;
            } else {
                System.out.println("Mã dịch vụ không có hoặc không tồn tại!\n" +
                        "Xin nhập lại");
            }
        } while (true);
    }

    public static void confirmDeleteFacility(String serviceCode) {
        int choice;
        System.out.println("Hãy xác nhận là bạn muốn xóa!\n" +
                "1.Yes\n" +
                "2.No");
        do {
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    facilityController.deleteObject(serviceCode);
                    System.out.println("Bạn đã xóa thành công!");
                    return;
                case 2:
                    System.out.println("Bạn đã hủy xóa!");
                    return;
                default:
                    System.out.println("Chỉ được nhập 1 hoặc 2!");
            }
        } while (true);
    }

    public static void displayListFacilityMaintenance() {
        Map<Facility, Integer> facilityIntegerMap = facilityController.getFacilityMaintenance();
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        if (facilitySet.isEmpty()) {
            System.out.println("Hiện tại không có sản phẩm nào đang bảo trì!");
        } else {
            System.out.println("Danh sách đang bảo trì gồm có:");
            for (Facility key : facilitySet) {
                System.out.println(key);
            }
        }
    }

    public static void displayListFacility() {
        Map<Facility, Integer> facilityIntegerMap = facilityController.getAll();
        Set<Facility> keySet = facilityIntegerMap.keySet();
        if (facilityIntegerMap.isEmpty()) {
            System.out.println("Hiện tại không có dịch vụ nào cả");
        } else {
            for (Facility key : keySet) {
                if (key instanceof Villa) {
                    System.out.println("serviceCode='" + key.getServiceCode() + '\'' +
                            ", serviceName='" + key.getServiceName() + '\'' +
                            ", usableArea='" + key.getUsableArea() + '\'' +
                            ", rentalCosts='" + key.getRentalCosts() + '\'' +
                            ", maxPeople='" + key.getMaxPeople() + '\'' +
                            ", rentalType='" + key.getRentalType() + '\'' +
                            ", roomStandards='" + ((Villa) key).getRoomStandards() + '\'' +
                            ", numberOfFloors='" + ((Villa) key).getNumberOfFloors() + '\'' +
                            ", swimmingPoolArea='" + ((Villa) key).getSwimmingPoolArea() + '\'' +
                            ", số lần sử dụng:" + facilityIntegerMap.get(key));
                } else if (key instanceof House) {
                    System.out.println("serviceCode='" + key.getServiceCode() + '\'' +
                            ", serviceName='" + key.getServiceName() + '\'' +
                            ", usableArea='" + key.getUsableArea() + '\'' +
                            ", rentalCosts='" + key.getRentalCosts() + '\'' +
                            ", maxPeople='" + key.getMaxPeople() + '\'' +
                            ", rentalType='" + key.getRentalType() + '\'' +
                            ", roomStandards='" + ((House) key).getRoomStandards() + '\'' +
                            ", numberOfFloors='" + ((House) key).getNumberOfFloors() + '\'' +
                            ", số lần sử dụng:" + facilityIntegerMap.get(key));
                } else if (key instanceof Room) {
                    System.out.println("serviceCode='" + key.getServiceCode() + '\'' +
                            ", serviceName='" + key.getServiceName() + '\'' +
                            ", usableArea='" + key.getUsableArea() + '\'' +
                            ", rentalCosts='" + key.getRentalCosts() + '\'' +
                            ", maxPeople='" + key.getMaxPeople() + '\'' +
                            ", rentalType='" + key.getRentalType() + '\'' +
                            ", freeServiceIncluded='" + ((Room) key).getFreeServiceIncluded() + '\'' +
                            ", số lần sử dụng:" + facilityIntegerMap.get(key));
                }
            }
        }
    }

    public static void addNewFacility() {
        System.out.println("1.Add New Villa\n" +
                "2.Add New House\n" +
                "3.Add New Room\n" +
                "4.Back to menu");
        int choice;
        do {
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewVilla();
                    return;
                case 2:
                    addNewHouse();
                    return;
                case 3:
                    addNewRoom();
                    return;
                case 4:
                    return;
                default:
                    System.out.println("Chỉ được nhập từ 1 đến 4!");
            }
        } while (true);
    }

    public static void addNewRoom() {
        String freeServiceIncluded;
        Facility facility;
        System.out.println("Nhập thông tin của Room:");
        Facility facility1;
        try {
            facility = inputFacilityInfor(1);
            freeServiceIncluded = inputFreeServiceIncluded();
            facility1 = new Room(freeServiceIncluded);
            facilityController.addObject(facility1, facility);
            System.out.println("Bạn đã thêm thành công");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String inputFreeServiceIncluded() {
        int choice;
        System.out.println("Hãy chọn dich vụ đi kèm:\n" +
                "1. Dịch vụ Massage miễn phí\n" +
                "2. Dịch vụ câu cá thư giãn\n" +
                "3. Dịch vụ tham gia đánh Gôn");
        do {
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    return EnumFurama.FREE_MASSAGE_SERVICE.getValue();
                case 2:
                    return EnumFurama.PERSONAL_RELAXATION_SERVICE.getValue();
                case 3:
                    return EnumFurama.GOLF_PARTICIPATION_SERVICE.getValue();
                default:
                    System.out.println("Chỉ được nhập từ 1 đến 3");
            }
        } while (true);
    }

    public static void addNewHouse() {
        String roomStandards;
        Integer numberOfFloors;
        Facility facility;
        Facility facility1;
        try {
            facility = inputFacilityInfor(2);
            roomStandards = inputVillaAndHouseRoomStandards();
            numberOfFloors = inputVillaAndHouseNumberOfFloors();
            facility1 = new House(roomStandards, numberOfFloors);
            facilityController.addObject(facility1, facility);
            System.out.println("Bạn đã thêm thành công!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addNewVilla() {
        String roomStandards;
        Integer numberOfFloors;
        Double swimmingPoolArea;
        Facility facility;
        Facility facility1;
        System.out.println("Nhập thông tin của Villa:");
        try {
            facility = inputFacilityInfor(3);
            roomStandards = inputVillaAndHouseRoomStandards();
            numberOfFloors = inputVillaAndHouseNumberOfFloors();
            swimmingPoolArea = inputVilaSwimmingPoolArea();
            facility1 = new Villa(roomStandards, numberOfFloors, swimmingPoolArea);
            facilityController.addObject(facility1, facility);
            System.out.println("Bạn đã thêm thành công!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Double inputVilaSwimmingPoolArea() {
        Double swimmingPoolArea;
        System.out.println("Nhập diện tích hồ bơi");
        do {
            swimmingPoolArea = Double.parseDouble(scanner.nextLine());
            if (FacilityInforExample.validateSwimmingPoolArea(swimmingPoolArea)) {
                return swimmingPoolArea;
            } else {
                System.out.println("Diện tích hồ bơi phải lớn hơn hoặc bằng 30");
            }
        } while (true);
    }

    public static Integer inputVillaAndHouseNumberOfFloors() {
        Integer numberOfFloors;
        System.out.println("Nhập số tầng");
        do {
            numberOfFloors = Integer.parseInt(scanner.nextLine());
            if (FacilityInforExample.validateNumberOfFloors(numberOfFloors)) {
                return numberOfFloors;
            } else {
                System.out.println("Số tầng phải lớn hơn 0!");
            }
        } while (true);
    }

    public static String inputVillaAndHouseRoomStandards() {
        int choice;
        System.out.println("Chọn tiêu chuẩn phòng:\n" +
                "1.Ba sao\n" +
                "2.Bốn sao\n" +
                "3.Năm sao");
        do {
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    return EnumFurama.THREE_STARS.getValue();
                case 2:
                    return EnumFurama.FOUR_STARS.getValue();
                case 3:
                    return EnumFurama.FIVE_STARS.getValue();
                default:
                    System.out.println("Chỉ được chọn từ 1 đến 3");
            }
        } while (true);
    }

    public static Facility inputFacilityInfor(int i) {
        String serviceCode = inputFacilityCode();
        String serviceName = inputFacilityName();
        Double usableArea = inputFacilityUsableArea();
        Double rentalCosts = inputFacilityRentalCode();
        Integer maxPeople = inputFacilityMaxPeople();
        String rentalType = inputFacilityRentalType();
        if (i == 1) {
            return new Room(serviceCode, serviceName, usableArea, rentalCosts, maxPeople, rentalType);
        } else if (i == 2) {
            return new House(serviceCode, serviceName, usableArea, rentalCosts, maxPeople, rentalType);
        } else {
            return new Villa(serviceCode, serviceName, usableArea, rentalCosts, maxPeople, rentalType);
        }
    }

    public static String inputFacilityRentalType() {
        int choice;
        System.out.println("Hãy chọn kiểu thuê:\n" +
                "1.Năm\n" +
                "2.Tháng\n" +
                "3.Ngày\n" +
                "4.Giờ");
        do {
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    return EnumFurama.TYPE_YEAR.getValue();
                case 2:
                    return EnumFurama.TYPE_MONTH.getValue();
                case 3:
                    return EnumFurama.TYPE_DATE.getValue();
                case 4:
                    return EnumFurama.TYPE_HOUR.getValue();
                default:
                    System.out.println("Chỉ được nhập từ 1 đến 4!");
            }
        } while (true);
    }

    public static Integer inputFacilityMaxPeople() {
        Integer maxPeople;
        System.out.println("Nhập số lượng người tối đa");
        do {
            maxPeople = Integer.parseInt(scanner.nextLine());
            if (FacilityInforExample.validateMaxPeople(maxPeople)) {
                return maxPeople;
            } else {
                System.out.println("Số lượng người phải lớn hơn 0 và nhỏ hơn 20!");
            }
        } while (true);
    }

    public static Double inputFacilityRentalCode() {
        Double rentalCosts;
        System.out.println("Nhập chi phí thuê");
        do {
            rentalCosts = Double.parseDouble(scanner.nextLine());
            if (FacilityInforExample.validateRentalCosts(rentalCosts)) {
                return rentalCosts;
            } else {
                System.out.println("Chi phí thuê phải lớn hơn không");
            }
        } while (true);
    }

    public static Double inputFacilityUsableArea() {
        Double usableArea;
        System.out.println("Nhập diện tích sử dụng");
        do {
            usableArea = Double.parseDouble(scanner.nextLine());
            if (FacilityInforExample.validateUsableArea(usableArea)) {
                return usableArea;
            } else {
                System.out.println("Diện tích sử dụng phải lớn hơn hoặc bằng 30 mét vuông");
            }
        } while (true);
    }

    public static String inputFacilityName() {
        int choice;
        System.out.println("Chọn tên dịch vụ:\n" +
                "1.Villa\n" +
                "2.House\n" +
                "3.Room");
        do {
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    return EnumFurama.TYPE_VILLA.getValue();
                case 2:
                    return EnumFurama.TYPE_HOUR.getValue();
                case 3:
                    return EnumFurama.TYPE_ROOM.getValue();
                default:
                    System.out.println("Chỉ được nhập từ 1 đến 3!");
            }
        } while (true);
    }

    public static String inputFacilityCode() {
        String serviceCode;
        System.out.println("Nhập mã dịch vụ");
        do {
            serviceCode = scanner.nextLine();
            if (FacilityInforExample.validateServiceCode(serviceCode) && (!facilityController.checkObjectCode(serviceCode))) {
                return serviceCode;
            } else {
                System.out.println("Không đúng định dạng hoặc đã tồn tại!\n" +
                        "Xin nhập lại");
            }
        } while (true);
    }
}
