package mz.co.vm.api.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import mz.co.vm.api.demo.bean.City;
import mz.co.vm.api.demo.service.TravelService;
import mz.co.vm.api.demo.service.WeatherService;

@SpringBootTest
class DemoApplicationTests {
	
	@Mock
    private WeatherService weatherService;

    private TravelService travelService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        travelService = new TravelService();
        travelService.weatherService = weatherService;
    }

    @Test
    void testGetWeather() throws IOException {
        String cityName = "Maputo";
        String weatherData = "{\"main\": {\"temp\": 293.97}, \"sys\": {\"country\": \"MZ\"}}";

        when(weatherService.getWeatherForecast(cityName)).thenReturn(weatherData);

        City city = new City();
        double weather = travelService.getWeather(cityName, city);

        assertEquals(293.97, weather);

        verify(weatherService, times(1)).getWeatherForecast(cityName);
    }

}
