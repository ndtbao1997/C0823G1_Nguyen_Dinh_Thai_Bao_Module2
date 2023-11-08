package case_study_2.furama_resort.repository;

import case_study_2.furama_resort.model.facility.Facility;

import java.util.Map;

public interface IFacilityRepository {
    void addObject(Facility facility1, Facility facility);

    Map<Facility, Integer> getAll();

    boolean checkObjectCode(String serviceCode);

    Map<Facility, Integer> getFacilityMaintenance();

    void deleteObject(String serviceCode);

    void addObject(String facilityCode);

    boolean checkRepair(String facilityCode);

    String getRentalType(String s);

    Double getRentalCosts(String s);
}
