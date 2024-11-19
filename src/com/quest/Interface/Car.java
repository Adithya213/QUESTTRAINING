package com.quest.Interface;


public class Car implements Vehicle, Engine {

    @Override
    public void wheel() {
        System.out.println("The car has 4 wheels.");
    }

    @Override
    public void drive() {
        System.out.println("The car is being driven.");
    }

    @Override
    public void engineType() {
        System.out.println("The car has a W16 engine.");
    }

    @Override
    public void fuelEfficiency() {
        System.out.println("The car's fuel efficiency is 15 km/l.");
    }
}