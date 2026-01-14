package main.java.com.example.streams.model;

import java.util.List;

public class Customer {

    private Long id;
    private String name;
    private int age;

    private Gender gender;
    private boolean active;
    private List<String> services;

    public Customer(Long id, String name, int age, boolean active, List<String> services, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
        this.services = services;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }

    public List<String> getServices() {
        return services;
    }

    public Gender getGender() {
        return gender;
    }
}
