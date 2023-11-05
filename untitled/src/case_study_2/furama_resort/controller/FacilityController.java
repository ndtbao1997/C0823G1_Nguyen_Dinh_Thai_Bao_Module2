package case_study_2.furama_resort.controller;

import case_study_2.furama_resort.model.facility.Facility;
import case_study_2.furama_resort.service.IFacilityService;
import case_study_2.furama_resort.service.ipml.FacilityService;

import java.util.Map;

public class FacilityController {
    private final IFacilityService iFacilityService = new FacilityService();

    public void addObject(Facility facility1, Facility facility) {
        iFacilityService.addObject(facility1, facility);
    }

    public Map<Facility, Integer> getAll() {
        return iFacilityService.getAll();
    }

    public boolean checkObjectCode(String serviceCode) {
        return iFacilityService.checkObjectCode(serviceCode);
    }

    public Map<Facility, Integer> getFacilityMaintenance() {
        return iFacilityService.getFacilityMaintenance();
    }

    public void deleteObject(String serviceCode) {
        iFacilityService.deleteObject(serviceCode);
    }

    public void addObject(String facilityCode) {
        iFacilityService.addObject(facilityCode);
    }

    public boolean checkRepair(String facilityCode) {
        return iFacilityService.checkRepair(facilityCode);
    }

}
