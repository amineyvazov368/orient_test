package jdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private Connection connection;

    public StudentRepository() {

        try {
            String url = "jdbc:postgresql://localhost:5432/learn_db";
            String userName = "postgres";
            String password = "postgres";
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("DB connected successfully");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void createStudent(String name, int age) {
        try {
            String query = "insert into students(name, age) VALUES ('" + name + "','" + age + "')";
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate(query);
            if (count > 0) {
                System.out.println("Student " + name + " has been created");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Students> getStudents() {

        try {
            List<Students> students = new ArrayList<>();
            Statement statement = connection.createStatement();
            String query = "select * from students";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                LocalDate create_at = resultSet.getDate(4).toLocalDate();
                Students student = new Students(id, name, age, create_at);
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Students getStudentById(String id) {
        try {
            String query = "select * from students where id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int student_id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                LocalDate create_at = resultSet.getDate(4).toLocalDate();
                Students student = new Students(student_id, name, age, create_at);
                return student;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Students deleteStudentById(String id) {
        Students byId = this.getStudentById(id);
        if (byId == null) {
            return null;
        }

        try {
            String query = "delete from students where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.executeUpdate();
            System.out.println("Category_id  " + id + " deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return byId;
    }

    public Students updateStudentById(String id, String name, int age) {
        Students byId1 = this.getStudentById(id);
        if (byId1 == null) {
            return null;
        }

        try {
            String query = "update students set name= ?, age =? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, Integer.parseInt(id));
            preparedStatement.executeUpdate();
            byId1.setName(name);
            byId1.setAge(age);
            System.out.println("Student_id  " + id + " updated");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return byId1;
    }
}
