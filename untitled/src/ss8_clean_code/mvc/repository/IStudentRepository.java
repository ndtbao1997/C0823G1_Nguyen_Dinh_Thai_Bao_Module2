package ss8_clean_code.mvc.repository;

public interface IStudentRepository {
    void showList();

    void addStudent(int id, String name);


    void removeStudent(int id);
    void editStudent(int id);
}
