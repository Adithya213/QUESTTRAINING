package com.quest.VehicleOop;
public class Main {
    public static void main(String[] args) {
        Vehicle unknownVehicle = new Vehicle();//1)default constructor will called
        System.out.println(unknownVehicle);

        Car car = new Car("Honda", "Civic");//para constructor
        System.out.println(car);

        //2)inheritance and method overriding
        car.fuelType();//calling subclass method
        unknownVehicle.fuelType();//calling superclass method

        // 3)interface method
        car.startEngine();

        //4)Use of final as para
        car.displayModel("Adithya");

        // calling tostring()
        System.out.println(car.toString());
    }
}

