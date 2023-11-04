package case_study_2.furama_resort.controller;

import case_study_2.furama_resort.model.person.Customer;
import case_study_2.furama_resort.service.IPromotionService;
import case_study_2.furama_resort.service.ipml.PromotionService;

import java.util.Set;
import java.util.Stack;

public class PromotionController {
    private final IPromotionService promotionService = new PromotionService();

    public Set<Customer> getCustomerPromotion() {
        return promotionService.getCustomerPromotion();
    }

    public Stack<Customer> getStackCustomer() {
        return promotionService.getStackCustomer();
    }
}
