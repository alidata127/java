//    Written By: Alireza Boroumandyar
// First Written: 2022-03-18
//   Last Update: 2022-03-18

// data class for handle the tree data

package com.example.restservice.model;

public class Tree {
    private int id;
    private String name;
    private int age;
    private int typeId;

    public Tree(int id, String name, int age, int typeId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.typeId = typeId;
    }

    public int gettypeId() {
        return typeId;
    }

    public void settypeId(int typeId) {
        this.typeId = typeId;
    }

    public Tree() {
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
}
