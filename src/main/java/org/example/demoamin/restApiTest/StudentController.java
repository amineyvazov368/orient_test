package org.example.demoamin.restApiTest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();


    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElse(null);
    }

    @GetMapping("/{id}/name")
    public String getNameOfStudentById(@PathVariable int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst().map(Student::getName).orElse(null);
    }


    @PostMapping
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }

    @PostMapping("/bulk")
    public void addStudents(@RequestBody List<Student> students) {
        this.students.addAll(students);
    }


    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable int id) {
        students.removeIf(student -> student.getId() == id);
    }

    @PutMapping("/{id}")
    public void updateStudentById(@PathVariable int id ,@RequestBody Student student) {
        Student find= getStudentById(student.getId());
        find.setId(student.getId());
        find.setName(student.getName());
        find.setAge(student.getAge());


    }


}
