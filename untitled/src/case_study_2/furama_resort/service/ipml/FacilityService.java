package case_study_2.furama_resort.service.ipml;

import case_study_2.furama_resort.model.facility.Facility;
import case_study_2.furama_resort.model.facility.Villa;
import case_study_2.furama_resort.repository.IFacilityRepository;
import case_study_2.furama_resort.repository.impl.FacilityRepository;
import case_study_2.furama_resort.service.IFacilityService;

import java.util.List;
import java.util.Map;

public class FacilityService implements IFacilityService {
    private final IFacilityRepository iFacilityRepository = new FacilityRepository();

    @Override
    public void addObject(Facility facility1, Facility facility) {
        iFacilityRepository.addObject(facility1,facility);
    }

    @Override
    public Map<Facility, Integer> getAll() {
        return iFacilityRepository.getAll();
    }

    @Override
    public boolean checkObjectCode(String serviceCode) {
        return iFacilityRepository.checkObjectCode(serviceCode);
    }

    @Override
    public Map<Facility, Integer> getFacilityMaintenance() {
        return iFacilityRepository.getFacilityMaintenance();
    }

    @Override
    public void deleteObject(String serviceCode) {
        iFacilityRepository.deleteObject(serviceCode);
    }

    @Override
    public void addObject(String facilityCode) {
        iFacilityRepository.addObject(facilityCode);
    }

    @Override
    public boolean checkRepair(String facilityCode) {
        return iFacilityRepository.checkRepair(facilityCode);
    }

}
