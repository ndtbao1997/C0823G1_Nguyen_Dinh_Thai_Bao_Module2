package case_study_2.furama_resort.service;

import case_study_2.furama_resort.model.person.Customer;

import java.util.Set;
import java.util.Stack;

public interface IPromotionService {
    Set<Customer> getCustomerPromotion();

    Stack<Customer> getStackCustomer();
}
