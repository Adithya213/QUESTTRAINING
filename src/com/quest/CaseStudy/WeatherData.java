package com.quest.CaseStudy;

public interface WeatherData {
    void addCityWeather(String cityName, double temperature, int humidity, String condition);
    void updateCityWeather(String cityName, double temperature, int humidity, String condition);
    void displayAllCities();
    void displayCity(String cityName);
    void displayTemperatureExtremes();
    void displayHighHumidityCities();
    void displayGroupedByCondition();
    void displayAverageTemperature();
    void checkAlerts();
}

