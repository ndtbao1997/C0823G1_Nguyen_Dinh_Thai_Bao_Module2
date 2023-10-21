package bai_tap_lam_them_1.controller;

import bai_tap_lam_them_1.service.PersonService;

public class PersonController {
    private static PersonService personService = new PersonService();
    public void addStudent(String id, String name, String dateOfBirth, String gender, String className, int scores){
        personService.addStudent(id, name, dateOfBirth, gender, className, scores);
    }
    public void addTeacher(String id, String name, String dateOfBirth, String gender, String level){
        personService.addTeacher(id, name, dateOfBirth, gender, level);
    }
    public void removeStudent(String id){
        personService.removeStudent(id);
    }
    public void removeTeacher(String id){personService.removeTeacher(id);}
    public void displayStudents(){personService.displayStudents();}
    public void displayTeacher(){personService.displayTeacher();}
}
