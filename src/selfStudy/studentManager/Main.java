package selfStudy.studentManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentLists = new ArrayList<Student>();
        StudentRepository studentRepository = new StudentRepository(studentLists);
        StudentService studentService = new StudentService(studentRepository);

        studentService.addStudent(new Student(1, "Amin", 18));
        studentService.addStudent(new Student(2, "Bob", 18));
        studentService.addStudent(new Student(3, "Charlie", 18));
        studentService.addStudent(new Student(4, "David", 18));

//        studentService.printAllStudent();
//        studentService.deleteStudent(2);
//        studentService.printAllStudent();
//        studentService.findStudentById(1);
//        studentService.updateStudent(new Student(1,"David",18));

        studentService.updateStudent(1, "Emin", 20);
        studentService.printAllStudent();
    }
}
