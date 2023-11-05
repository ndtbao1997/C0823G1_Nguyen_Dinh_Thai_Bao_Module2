package case_study_2.furama_resort.controller;

import case_study_2.furama_resort.model.booking_contract.Contract;;
import case_study_2.furama_resort.service.IContactService;
import case_study_2.furama_resort.service.ipml.ContactService;

import java.util.List;

public class ContactController {
    private final IContactService iContactService = new ContactService();

    public void addObject(Contract contract) {
        iContactService.addObject(contract);
    }

    public List<Contract> getAll() {
        return iContactService.getAll();
    }

    public boolean checkObjectCode(String string) {
        return iContactService.checkObjectCode(string);
    }

    public String getBookingCode(String someContract) {
        return iContactService.getBookingCode(someContract);
    }

    public void editObject(Contract contract) {
        iContactService.editObject(contract);
    }
}
