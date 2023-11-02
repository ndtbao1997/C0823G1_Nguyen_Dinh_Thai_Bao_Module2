package case_study_2.furama_resort.service;

import case_study_2.furama_resort.model.facility.Facility;
import case_study_2.furama_resort.model.facility.Villa;

import java.util.Map;

public interface IFacilityService{
    void addObject(Facility facility1, Facility facility);

    Map<Facility, Integer> getAll();

    boolean checkObjectCode(String serviceCode);
}