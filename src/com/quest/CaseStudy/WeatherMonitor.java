package com.quest.CaseStudy;
//This class will provide functionality to manage city weather data

public class WeatherMonitor implements WeatherData {
    private CityWeather[] cities; //array to add cities
    private int cityCount;

    public WeatherMonitor(int maxCities) {
        cities = new CityWeather[maxCities];
        cityCount = 0;
    }

    @Override
    public void addCityWeather(String cityName, double temperature, int humidity, String condition) {
        if (cityCount < cities.length) {//check if array not full
            cities[cityCount++] = new CityWeather(cityName, temperature, humidity, condition);//add city
        } else {
            System.out.println("Cannot add more cities, City Array is full.");
        }
    }

    @Override
    public void updateCityWeather(String cityName, double temperature, int humidity, String condition) {
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getCityName().equalsIgnoreCase(cityName)) {
                cities[i].setTemperature(temperature);
                cities[i].setHumidity(humidity);
                cities[i].setCondition(condition);
                System.out.println("Weather data updated for " + cityName);
                return;
            }
        }
        System.out.println("City not found.");
    }

    @Override
    public void displayAllCities() {
        if (cityCount == 0) {//check if cities available
            System.out.println("No cities available.");
            return;
        }
        for (int i = 0; i < cityCount; i++) {//display all cities using for loop
            System.out.println((i + 1) + ". " + cities[i]);
        }
    }

    @Override
    public void displayCity(String cityName) {
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getCityName().equalsIgnoreCase(cityName)) {
                System.out.println(cities[i]);
                return;
            }
        }
        System.out.println("City not found.");
    }

    @Override
    public void displayTemperatureExtremes() {
        if (cityCount == 0) {
            System.out.println("No cities available.");//checking
            return;
        }
        CityWeather highest = cities[0];//initialize variable to track extremes
        CityWeather lowest = cities[0];
        for (int i = 1; i < cityCount; i++) {//loop through city array to find temp ext
            if (cities[i].getTemperature() > highest.getTemperature()) {
                highest = cities[i]; // updates highest from array
            }
            if (cities[i].getTemperature() < lowest.getTemperature()) {
                lowest = cities[i]; // update lowest
            }
        }
        System.out.println("City with the Highest Temperature: " + highest.getCityName() + " (" + highest.getTemperature() + "°C)");
        System.out.println("City with the Lowest Temperature: " + lowest.getCityName() + " (" + lowest.getTemperature() + "°C)");
    }
       // method to display all cities where humidity exceedds 80%
    @Override
    public void displayHighHumidityCities() {
        boolean found = false;
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getHumidity() > 80) {//check humidity is >80
                System.out.println(cities[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cities found with humidity Greater than 80%.");
        }
    }
   //method to group cities by their weather conditions - sunny, rainy ,cloudy
    @Override
    public void displayGroupedByCondition() {
        System.out.println("Cities grouped by Weather condition:");
        for (String condition : new String[]{"Sunny", "Rainy", "Cloudy"}) { //outer loop traverse over arrau
            System.out.print("-> " + condition + " : "); //print current weather condition
            boolean found = false;
            for (int i = 0; i < cityCount; i++) {
                if (cities[i].getCondition().equalsIgnoreCase(condition)) {//if cities in array == current condition
                    System.out.print(cities[i].getCityName() + " ");
                    found = true;//city found
                }
            }
            if (!found) {
                System.out.print("None");
            }
            System.out.println();
        }
    }
     // method calculate avg temp of all cities
    @Override
    public void displayAverageTemperature() {
        if (cityCount == 0) {
            System.out.println("No cities available.");
            return;
        }
        double totalTemperature = 0;
        for (int i = 0; i < cityCount; i++) {
            totalTemperature += cities[i].getTemperature();//find sum of temp
        }
        System.out.printf("Average Temperature: %.2f°C\n", totalTemperature / cityCount);
    }

    @Override
    public void checkAlerts() {
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getTemperature() > 40) {// if temperature exceeds 40°C
                System.out.println("Heatwave Alert: " + cities[i].getCityName() + " is experiencing extreme heat (" + cities[i].getTemperature() + "°C)");
            }
            if (cities[i].getHumidity() < 20) {
                System.out.println("Low Humidity Warning: " + cities[i].getCityName() + " has very low humidity (" + cities[i].getHumidity() + "%)");
            }
        }
    }
}

