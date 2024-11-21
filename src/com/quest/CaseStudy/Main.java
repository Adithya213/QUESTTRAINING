package com.quest.CaseStudy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeatherMonitor system = new WeatherMonitor(10);  // Max 10 cities

        System.out.println("Welcome to the Weather Monitoring System\n");
        System.out.println("Adding Weather Data...");
        for (int i = 0; i < 3; i++) {  //adding 3 cities
            System.out.print("Enter city name: ");
            String cityName = scanner.nextLine();

            System.out.print("Enter temperature (°C): ");
            double temperature = scanner.nextDouble();

            System.out.print("Enter humidity (%): ");
            int humidity = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter weather condition (Sunny/Rainy/Cloudy): ");
            String condition = scanner.nextLine();

            system.addCityWeather(cityName, temperature, humidity, condition);
            System.out.println();
        }

        System.out.println("\nDisplaying All Cities:");
        system.displayAllCities();

        System.out.println("\nTemperature Extremes:");
        system.displayTemperatureExtremes();

        System.out.println("\nCities with Humidity > 80%:");
        system.displayHighHumidityCities();

        System.out.println("\nGenerating Reports:");
        system.displayGroupedByCondition();
        system.displayAverageTemperature();

        System.out.println("\nAlerts:");
        system.checkAlerts();

        // ask to print specific weather or update weather
        boolean continueRunning = true;
        while (continueRunning) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Display Data for a Specific City");
            System.out.println("2. Update Weather Data for a City");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter city name to display: ");
                    String cityToDisplay = scanner.nextLine();
                    system.displayCity(cityToDisplay);
                    break;

                case 2:
                    // Update weather data for a city
                    System.out.print("Enter city name to update: ");
                    String cityToUpdate = scanner.nextLine();

                    System.out.print("Enter new temperature (°C): ");
                    double newTemperature = scanner.nextDouble();

                    System.out.print("Enter new humidity (%): ");
                    int newHumidity = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new weather condition (Sunny/Rainy/Cloudy): ");
                    String newCondition = scanner.nextLine();

                    system.updateCityWeather(cityToUpdate, newTemperature, newHumidity, newCondition);
                    break;

                case 3:
                    continueRunning = false;
                    System.out.println("Exiting the Weather Monitoring System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
