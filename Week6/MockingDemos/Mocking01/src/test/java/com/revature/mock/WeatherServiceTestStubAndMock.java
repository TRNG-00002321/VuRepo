package com.revature.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WeatherServiceTestStubAndMock {
    @Test
    public void testWeatherServiceWithStubAndMock(){
        // creating a test double, mocking the dependency
        WeatherApiClient apiClient = Mockito.mock(WeatherApiClient.class);

        // STUBBING: define what the mock should return (return a fixed value)
        Mockito.when(apiClient.fetchTemperature("Plano")).thenReturn(35.0);

        WeatherService weatherService = new WeatherService(apiClient);

        String message = weatherService.getWeatherMessage("Plano");
        Assertions.assertEquals("It's Hot in ", message);

        Mockito.verify(apiClient, Mockito.times(2)).fetchTemperature("Plano");

    }
}
