package com.quest.AnimalOops;

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " cat makes sound");
    }

    @Override
    public void behavior() {
        System.out.println(getName() + " loves to climb trees.");
    }
}

