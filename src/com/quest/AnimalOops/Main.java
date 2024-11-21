package com.quest.AnimalOops;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = { new Dog("BullDog"), new Cat("Rag doll"), new Bird("Parrots")};

        for (Animal animal : animals) {
            System.out.println("Animal: " + animal.getClass().getSimpleName());
            animal.makeSound();
            animal.behavior();
            System.out.println();
        }
    }
}

