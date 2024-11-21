package com.quest.AnimalOops;

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " Bird makes sound");
    }

    @Override
    public void behavior() {
        System.out.println(getName() + " loves to fly high.");
    }
}

