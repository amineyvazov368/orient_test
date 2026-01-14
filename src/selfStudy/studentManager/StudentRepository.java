package selfStudy.studentManager;

import java.util.List;

public class StudentRepository {
    private List<Student> studentLists;

    public StudentRepository(List<Student> studentList) {
        this.studentLists = studentList;
    }

    public void save(Student student) {
        studentLists.add(student);
    }

    public List<Student> findAll() {
        return studentLists;
    }

    public void deleteById(int id) {
        studentLists.removeIf(student -> student.getId() == id);
    }

    public Student findById(int id) {
        for (Student student : studentLists) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student update(int id, String name, int age) {
        for (Student student : studentLists) {
            if (student.getId() == id) {
                student.setName(name);
                student.setAge(age);
                return student;
            }
        }
        return null;
    }

}

