package case_study_2.furama_resort.controller;

import case_study_2.furama_resort.model.facility.Facility;
import case_study_2.furama_resort.model.facility.Villa;
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
}
