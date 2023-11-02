package case_study_2.furama_resort.repository.impl;

import case_study_2.furama_resort.model.facility.Facility;
import case_study_2.furama_resort.model.facility.House;
import case_study_2.furama_resort.model.facility.Villa;
import case_study_2.furama_resort.repository.IFacilityRepository;
import case_study_2.furama_resort.untils.read_and_write.ReadFileFacility;
import case_study_2.furama_resort.untils.read_and_write.WriteFileFacility;

import java.util.*;

public class FacilityRepository implements IFacilityRepository {
    public Map<Facility, Integer> getFacilityMap() {
        return ReadFileFacility.readFile();
    }

    @Override
    public void addObject(Facility facility1, Facility facility) {
        Map<Facility, Integer> facilityIntegerMap = getFacilityMap();
        Facility newFacility = null;
        if (facility1 instanceof Villa) {
            newFacility = new Villa(facility.getServiceCode(), facility.getServiceName(), facility.getUsableArea(),
                    facility.getRentalCosts(), facility.getMaxPeople(), facility.getRentalType(), ((Villa) facility1).getRoomStandards(),
                    ((Villa) facility1).getNumberOfFloors(), ((Villa) facility1).getSwimmingPoolArea());
            facilityIntegerMap.put(newFacility, facilityIntegerMap.getOrDefault(newFacility, -1) + 1);
            WriteFileFacility.writeTofile(facilityIntegerMap);
        } else if (facility1 instanceof House) {
            newFacility = new House(facility.getServiceCode(), facility.getServiceName(), facility.getUsableArea(),
                    facility.getRentalCosts(), facility.getMaxPeople(), facility.getRentalType(), ((House) facility1).getRoomStandards(),
                    ((House) facility1).getNumberOfFloors());
            facilityIntegerMap.put(newFacility, facilityIntegerMap.getOrDefault(newFacility, -1) + 1);
            WriteFileFacility.writeTofile(facilityIntegerMap);
        }
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
}
