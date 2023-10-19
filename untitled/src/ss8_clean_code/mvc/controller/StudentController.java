package ss8_clean_code.mvc.controller;


import ss8_clean_code.mvc.service.IStudentService;
import ss8_clean_code.mvc.service.StudentService;

public class StudentController {
    private IStudentService iStudentService = new StudentService();
    public void showList(){
        iStudentService.showList();
    }
    public void addStudent(int id, String name){iStudentService.addList(id,name);}
    public void removeStudent(int id){
        iStudentService.removeList(id);
    }
    public void editStudent(int id){
        iStudentService.editStudent(id);
    }
}
