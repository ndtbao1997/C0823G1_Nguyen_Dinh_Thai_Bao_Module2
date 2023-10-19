package ss8_clean_code.mvc.service;

public interface IStudentService {
    void showList();
    void addList(int id, String name);
    void removeList(int id);
    void editStudent(int id);
}
