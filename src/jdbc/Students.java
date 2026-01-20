package jdbc;

import java.time.LocalDate;

public class Students {

    private int id;
    private String name;
    private int age;
    private LocalDate create_at;

    public Students(int id, String name, int age, LocalDate create_at) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.create_at = create_at;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", create_at=" + create_at +
                '}';
    }
}


