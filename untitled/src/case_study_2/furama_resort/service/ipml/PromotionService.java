package case_study_2.furama_resort.service.ipml;

import case_study_2.furama_resort.model.person.Customer;
import case_study_2.furama_resort.repository.IPromotionRepository;
import case_study_2.furama_resort.repository.impl.PromotionRepository;
import case_study_2.furama_resort.service.IPromotionService;

import java.util.Set;
import java.util.Stack;

public class PromotionService implements IPromotionService {
    private final IPromotionRepository iPromotionRepository = new PromotionRepository();

    @Override
    public Set<Customer> getCustomerPromotion() {
        return iPromotionRepository.getCustomerPromotion();
    }

    @Override
    public Stack<Customer> getStackCustomer() {
        return iPromotionRepository.getStackCustomer();
    }
}
