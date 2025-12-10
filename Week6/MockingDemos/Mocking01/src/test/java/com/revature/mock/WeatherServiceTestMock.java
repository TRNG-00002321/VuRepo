package com.revature.mock;

import org.mockito.Mockito;

public class WeatherServiceTestMock {
    public void testMockDemo(){
        WeatherApiClient apiClient = Mockito.mock(WeatherApiClient.class);

        WeatherService service = new WeatherService(apiClient);

        service.refresh("Frisco");

        Mockito.verify(apiClient, Mockito.times(1)).fetchTemperature("Frisco");

    }
}
