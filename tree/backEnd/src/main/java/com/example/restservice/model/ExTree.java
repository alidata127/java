package com.example.restservice.model;

public class ExTree {
    private int id;
    private String name;
    private int age;
    private String typeName;

    public ExTree() {
    }

    public ExTree(int id, String name, int age, String typeName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
