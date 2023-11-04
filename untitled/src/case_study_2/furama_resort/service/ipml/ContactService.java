package case_study_2.furama_resort.service.ipml;

import case_study_2.furama_resort.model.booking_contract.Contract;
import case_study_2.furama_resort.repository.IContactRepository;
import case_study_2.furama_resort.repository.impl.ContactRepository;
import case_study_2.furama_resort.service.IContactService;

import java.util.List;

public class ContactService implements IContactService {
private final IContactRepository iContactRepository= new ContactRepository();
    @Override
    public void addObject(Contract contract) {
       iContactRepository.addObject(contract);
    }

    @Override
    public List<Contract> getAll() {
        return iContactRepository.getAll();
    }

    @Override
    public boolean checkObjectCode(String string) {
        return iContactRepository.checkObjectCode(string);
    }

    @Override
    public String getBookingCode(String someContract) {
        return iContactRepository.getBookingCode(someContract);
    }

    @Override
    public void editObject(Contract contract) {
        iContactRepository.editObject(contract);
    }
}
