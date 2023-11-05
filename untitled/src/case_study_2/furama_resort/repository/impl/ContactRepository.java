package case_study_2.furama_resort.repository.impl;

import case_study_2.furama_resort.model.booking_contract.Contract;
import case_study_2.furama_resort.repository.IContactRepository;
import case_study_2.furama_resort.untils.read_and_write.ReadFile;
import case_study_2.furama_resort.untils.read_and_write.WriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactRepository implements IContactRepository {
    private static final String PATH = "src/case_study_2/furama_resort/data/data_contracts.csv";

    @Override
    public void addObject(Contract contract) {
        List<Contract> contractList = getListContracts();
        contractList.add(contract);
        WriteFile.WriteToFile(contractList, PATH);
    }

    @Override
    public List<Contract> getAll() {
        return getListContracts();
    }

    @Override
    public boolean checkObjectCode(String string) {
        List<Contract> contractList = getListContracts();
        for (Contract contract : contractList) {
            if (Objects.equals(contract.getBookingCode(), string) || Objects.equals(contract.getSomeContracts(), string)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getBookingCode(String someContract) {
        List<Contract> contractList = getListContracts();
        for (Contract contract : contractList) {
            if (Objects.equals(contract.getSomeContracts(), someContract)) {
                return contract.getBookingCode();
            }
        }
        return null;
    }

    @Override
    public void editObject(Contract contract) {
        List<Contract> contractList = getListContracts();
        for (Contract contract1 : contractList) {
            if (Objects.equals(contract1.getSomeContracts(), contract.getSomeContracts())) {
                contract1.setAdvanceDepositAmount(contract.getAdvanceDepositAmount());
                contract1.setTotalPaymentAmount(contract.getTotalPaymentAmount());
                WriteFile.WriteToFile(contractList, PATH);
                return;
            }
        }
    }

    public List<Contract> getListContracts() {
        List<String> stringList = ReadFile.readFile(PATH);
        List<Contract> contractList = new ArrayList<>();
        String[] strings;
        try {
            if (!stringList.isEmpty()) {
                for (String s : stringList) {
                    strings = s.split(",");
                    contractList.add(new Contract(strings[0], strings[1],
                            Long.parseLong(strings[2]), Long.parseLong(strings[3])));
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        return contractList;
    }
}
