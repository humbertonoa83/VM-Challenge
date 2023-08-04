package mz.co.vm.api.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mz.co.vm.api.demo.consume.ApiCaller;

/**
 * 
 * @author Humberto Pfumo
 * 
 **/

@Service
public class WeatherService {

	@Autowired
	private ApiCaller apicaller;
    
	private final String openWeatherApiKey;
	
    public WeatherService(@Value("${openweathermap.api.key}") String openWeatherApiKey) {
        this.openWeatherApiKey = openWeatherApiKey;
    }
	
    public String getWeatherForecast(String city) {
    	
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + openWeatherApiKey;

        return apicaller.consumeApi(apiUrl);
    }
}
