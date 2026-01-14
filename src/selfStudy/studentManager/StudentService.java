package selfStudy.studentManager;

public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
        System.out.println("Student added");
    }

    public void printAllStudent() {
        for (Student student : studentRepository.findAll()) {
            System.out.println(student.getId() + "." + student.getName() + ":" + student.getAge() + " yas");
        }
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
        System.out.println("Student deleted");
    }

    public void findStudentById(int id) {
        if ((studentRepository.findById(id))==null){
            System.out.println("Student not found");
            return;
        }
        studentRepository.findById(id);
        System.out.println(id + " li student: " + studentRepository.findById(id).getName());
    }

    public void updateStudent(int id, String name, int age) {
        studentRepository.update(id, name, age);
        System.out.println("Student updated");
    }


}
