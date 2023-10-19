package ss8_clean_code.mvc.service;


import ss8_clean_code.mvc.repository.IStudentRepository;
import ss8_clean_code.mvc.repository.StudentRepository;

public class StudentService implements IStudentService{
    private IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public void showList() {
        iStudentRepository.showList();
    }

    @Override
    public void addList(int id, String name) {
        iStudentRepository.addStudent(id, name);
    }

    @Override
    public void removeList(int id) {
        iStudentRepository.removeStudent(id);
    }
    public void editStudent(int id){
        iStudentRepository.editStudent(id);
    }
}
