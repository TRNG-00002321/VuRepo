package com.revature.mock;

public class WeatherService {
    private WeatherApiClient weatherApiClient;

    // Dependency injection
    public WeatherService(WeatherApiClient weatherApiClient){
        this.weatherApiClient = weatherApiClient;
    }

    public String getWeatherMessage(String city) {
        double temp = weatherApiClient.fetchTemperature(city);

        if(temp>30){
            return "It's Hot in " + city;
        }
        else if(temp>15){
            return "It's Warm in " + city;
        }
        return "It's Cold in " + city;
    }

    public void refresh(String city){
        weatherApiClient.fetchTemperature("Frisco");
    }
}
