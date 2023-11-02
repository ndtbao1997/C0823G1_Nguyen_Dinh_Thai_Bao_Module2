package case_study_2.furama_resort.controller;

import case_study_2.furama_resort.repository.IContactRepository;
import case_study_2.furama_resort.repository.impl.ContactRepository;

public class ContactController {
    private final IContactRepository iContactRepository = new ContactRepository();
}
