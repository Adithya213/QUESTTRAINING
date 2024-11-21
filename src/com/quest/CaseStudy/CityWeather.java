package com.quest.CaseStudy;

public class CityWeather {
    private String cityName;
    private double temperature;//in c
    private int humidity; //in %
    private String condition;//sunny,rainy, cloudy

    public CityWeather(String cityName, double temperature, int humidity, String condition) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.condition = condition;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "City: " + cityName + ", Temperature: " + temperature + "°C, Humidity: " + humidity + "%, Condition: " + condition;
    }
}

