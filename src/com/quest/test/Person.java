package com.quest.test;

public class Person {
    private final String name = "Ron";  // private field

    // Inner class
    public class Human {
        public void printName() {
            // Directly accessing the private 'name' field from the outer class 'Person'
            System.out.println(name);  // No need for getters, as 'Human' is an inner class
        }
    }

    public static void main(String[] args) {
        // Create an instance of the outer class 'Person'
        Person person = new Person();

        // Create an instance of the inner class 'Human'
        Person.Human human = person.new Human(); // Use 'person.new Human()' to instantiate

        // Call the printName method
        human.printName();  // Output will be "Ron"
    }
}

