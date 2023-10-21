package bai_tap_lam_them_1.service;

import bai_tap_lam_them_1.repository.PersonRepository;

public class PersonService implements IPersonService{
    private static PersonRepository personRepository = new PersonRepository();
    @Override
    public void addStudent(String id, String name, String dateOfBirth, String gender, String className, int scores) {
        personRepository.addStudent(id,name,dateOfBirth,gender,className,scores);
    }

    @Override
    public void addTeacher(String id, String name, String dateOfBirth, String gender, String level) {
        personRepository.addTeacher(id,name,dateOfBirth,gender,level);
    }

    @Override
    public void removeStudent(String id) {
        personRepository.removeStudent(id);
    }

    @Override
    public void removeTeacher(String id) {
        personRepository.removeTeacher(id);
    }

    @Override
    public void displayStudents() {
        personRepository.displayStudents();
    }

    @Override
    public void displayTeacher() {
        personRepository.displayTeacher();
    }
}
