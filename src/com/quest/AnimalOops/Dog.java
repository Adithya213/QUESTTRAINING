package com.quest.AnimalOops;

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " Dog makes sound");
    }

    @Override
    public void behavior() {
        System.out.println(getName() + " loves to fetch balls.");
    }
}

