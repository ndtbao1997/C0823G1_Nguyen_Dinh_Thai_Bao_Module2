package case_study_2.furama_resort.repository.impl;

import case_study_2.furama_resort.model.facility.Facility;
import case_study_2.furama_resort.model.facility.House;
import case_study_2.furama_resort.model.facility.Room;
import case_study_2.furama_resort.model.facility.Villa;
import case_study_2.furama_resort.repository.IFacilityRepository;
import case_study_2.furama_resort.untils.read_and_write.ReadFile;
import case_study_2.furama_resort.untils.read_and_write.WriteFile;

import java.util.*;

public class  FacilityRepository implements IFacilityRepository {
    private static final String PATH = "src/case_study_2/furama_resort/data/data_facility.csv";

    public static Map<Facility, Integer> getFacilityMap() {
        List<String> strings = ReadFile.readFile(PATH);
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        String[] stringArr;
        Facility facility;
        if (!strings.isEmpty()) {
            for (String s : strings) {
                stringArr = s.split(",");
                if (stringArr.length == 10) {
                    facility = new Villa(stringArr[1], stringArr[2], Double.parseDouble(stringArr[3]),
                            Double.parseDouble(stringArr[4]), Integer.parseInt(stringArr[5]), stringArr[6], stringArr[7],
                            Integer.parseInt(stringArr[8]), Double.parseDouble(stringArr[9]));
                    facilityIntegerMap.put(facility, Integer.parseInt(stringArr[0]));
                }
                if (stringArr.length == 9) {
                    facility = new House(stringArr[1], stringArr[2], Double.parseDouble(stringArr[3]),
                            Double.parseDouble(stringArr[4]), Integer.parseInt(stringArr[5]), stringArr[6], stringArr[7],
                            Integer.parseInt(stringArr[8]));
                    facilityIntegerMap.put(facility, Integer.parseInt(stringArr[0]));
                }
                if (stringArr.length == 8) {
                    facility = new Room(stringArr[1], stringArr[2], Double.parseDouble(stringArr[3]),
                            Double.parseDouble(stringArr[4]), Integer.parseInt(stringArr[5]), stringArr[6], stringArr[7]);
                    facilityIntegerMap.put(facility, Integer.parseInt(stringArr[0]));
                }
            }
        }
        return facilityIntegerMap;
    }

    public void writeFacility(Map<Facility, Integer> facilityIntegerMap) {
        List<Facility> facilityList = new ArrayList<>();
        Facility facility;
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        for (Facility facility1 : facilitySet) {
            if (facility1 instanceof Villa) {
                facility = new Villa(facilityIntegerMap.get(facility1), facility1.getServiceCode(), facility1.getServiceName(), facility1.getUsableArea(),
                        facility1.getRentalCosts(), facility1.getMaxPeople(), facility1.getRentalType(), ((Villa) facility1).getRoomStandards(),
                        ((Villa) facility1).getNumberOfFloors(), ((Villa) facility1).getSwimmingPoolArea());
                facilityList.add(facility);
            } else if (facility1 instanceof House) {
                facility = new House(facilityIntegerMap.get(facility1), facility1.getServiceCode(), facility1.getServiceName(), facility1.getUsableArea(),
                        facility1.getRentalCosts(), facility1.getMaxPeople(), facility1.getRentalType(), ((House) facility1).getRoomStandards(),
                        ((House) facility1).getNumberOfFloors());
                facilityList.add(facility);
            } else if (facility1 instanceof Room) {
                facility = new Room(facilityIntegerMap.get(facility1), facility1.getServiceCode(), facility1.getServiceName(), facility1.getUsableArea(),
                        facility1.getRentalCosts(), facility1.getMaxPeople(), facility1.getRentalType(),
                        ((Room) facility1).getFreeServiceIncluded());
                facilityList.add(facility);
            }
        }
        WriteFile.WriteToFile(facilityList, PATH);
    }

    @Override
    public void addObject(Facility facility1, Facility facility) {
        Map<Facility, Integer> facilityIntegerMap = getFacilityMap();
        Facility newFacility = null;
        if (facility1 instanceof Villa) {
            newFacility = new Villa(facility.getServiceCode(), facility.getServiceName(), facility.getUsableArea(),
                    facility.getRentalCosts(), facility.getMaxPeople(), facility.getRentalType(), ((Villa) facility1).getRoomStandards(),
                    ((Villa) facility1).getNumberOfFloors(), ((Villa) facility1).getSwimmingPoolArea());
        } else if (facility1 instanceof House) {
            newFacility = new House(facility.getServiceCode(), facility.getServiceName(), facility.getUsableArea(),
                    facility.getRentalCosts(), facility.getMaxPeople(), facility.getRentalType(), ((House) facility1).getRoomStandards(),
                    ((House) facility1).getNumberOfFloors());

        } else if (facility1 instanceof Room) {
            newFacility = new Room(facility.getServiceCode(), facility.getServiceName(), facility.getUsableArea(),
                    facility.getRentalCosts(), facility.getMaxPeople(), facility.getRentalType(),
                    ((Room) facility1).getFreeServiceIncluded());
        }
        facilityIntegerMap.put(newFacility, facilityIntegerMap.getOrDefault(newFacility, -1) + 1);
        writeFacility(facilityIntegerMap);
    }

    @Override
    public Map<Facility, Integer> getAll() {
        return getFacilityMap();
    }

    @Override
    public boolean checkObjectCode(String serviceCode) {
        Map<Facility, Integer> facilityIntegerMap = getFacilityMap();
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        for (Facility key : facilitySet) {
            if (Objects.equals(key.getServiceCode(), serviceCode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<Facility, Integer> getFacilityMaintenance() {
        Map<Facility, Integer> facilityIntegerMap = getFacilityMap();
        Map<Facility, Integer> newMap = new LinkedHashMap<>();
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        for (Facility key : facilitySet) {
            if (facilityIntegerMap.get(key) == 5) {
                newMap.put(key, facilityIntegerMap.get(key));
            }
        }
        return newMap;
    }

    @Override
    public void deleteObject(String serviceCode) {
        Map<Facility, Integer> facilityIntegerMap = getFacilityMap();
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        for (Facility key : facilitySet) {
            if (Objects.equals(key.getServiceCode(), serviceCode)) {
                facilityIntegerMap.remove(key);
                writeFacility(facilityIntegerMap);
                return;
            }
        }
    }

    @Override
    public void addObject(String facilityCode) {
        Map<Facility, Integer> facilityIntegerMap = getFacilityMap();
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        for (Facility key : facilitySet) {
            if (Objects.equals(key.getServiceCode(), facilityCode)) {
                facilityIntegerMap.put(key, facilityIntegerMap.getOrDefault(key, -1) + 1);
                writeFacility(facilityIntegerMap);
                return;
            }
        }
    }

    @Override
    public boolean checkRepair(String facilityCode) {
        Map<Facility, Integer> facilityIntegerMap = getFacilityMap();
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        for (Facility key : facilitySet) {
            if (Objects.equals(key.getServiceCode(), facilityCode)) {
                if (facilityIntegerMap.get(key) == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Facility> getListFacilityYear() {
        List<Facility> facilityList = new ArrayList<>();
        Map<Facility, Integer> facilityIntegerMap = getFacilityMap();
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        for (Facility facility : facilitySet) {
            if (Objects.equals(facility.getRentalType(), "Năm")) {
                facilityList.add(facility);
            }
        }
        return facilityList;
    }
}
