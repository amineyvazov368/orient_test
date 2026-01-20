package jdbc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();

        studentRepository.createStudent("Elsen", 14);
        studentRepository.createStudent("Amin", 24);
        studentRepository.createStudent("Elnur", 10);
        // List<Students> listStudent= studentRepository.getStudents();
//
//      listStudent.forEach(System.out::println);
//        System.out.println(studentRepository.getStudentById("5"));
//        System.out.println(studentRepository.deleteStudentById("1"));
//        System.out.println(studentRepository.updateStudentById("1","Nicat",20));
    }
}
