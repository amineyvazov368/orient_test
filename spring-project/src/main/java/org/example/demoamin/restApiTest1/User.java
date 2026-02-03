package org.example.demoamin.restApiTest1;

public class User {

    private Integer id;
    private String name;
    private Address address;

    public User(Integer id, String name,Address address) {
        this.id = id;
        this.name = name;
        this.address = address;

    }

    public User() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
