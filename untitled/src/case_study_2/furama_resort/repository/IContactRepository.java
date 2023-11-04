package case_study_2.furama_resort.repository;

import case_study_2.furama_resort.model.booking_contract.Contract;

import java.util.List;

public interface IContactRepository {
    void addObject(Contract contract);

    List<Contract> getAll();

    boolean checkObjectCode(String string);

    String getBookingCode(String someContract);

    void editObject(Contract contract);
}
