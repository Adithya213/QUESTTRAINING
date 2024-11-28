package com.quest.CollectionEg.ListEg.ArrayList;
class Person2 {
    private String name;
    private int age;
    private String location;
    private String gender;

    public Person2(String name, int age, String location, String gender) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Location: " + location + ", Gender: " + gender;
    }
}
