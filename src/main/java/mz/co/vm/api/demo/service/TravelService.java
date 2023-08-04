package mz.co.vm.api.demo.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import mz.co.vm.api.demo.bean.City;

/**
 * @author Humberto Pfumo
 * 
 * This is a Class Service
 * that does all the work
 * 
 * */

@Service
public class TravelService {
	
	@Autowired
	public WeatherService weatherService;
	
	@Autowired
	private ExchangeService exchangeService;
	
	@Autowired
	private CountryInfoService countryInfoService;
	
	//Return the weather
	public double getWeather(String cityName, City city) {
		String weather = weatherService.getWeatherForecast(cityName);
		
		Map<String, Object> jsonMap = new HashMap<>();
        try {
            jsonMap = new ObjectMapper().readValue(weather, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (jsonMap.containsKey("main")) {
            Map<String, Object> mainMap = (Map<String, Object>) jsonMap.get("main");
            if(jsonMap.containsKey("sys")) {
            	Map<String, Object> sys = (Map<String, Object>) jsonMap.get("sys");
            	city.setCountryCode((String)sys.get("country"));
            }
            if (mainMap.containsKey("temp")) {
            	System.out.println(mainMap.get("temp"));
                return (double) mainMap.get("temp");
            }
        }
		 
		return 0;
	}
	
	public String getExchange() {
		return exchangeService.getExchange();
	}
	
	// REturn the number of a population in a Country
	public int getPopulation(City city) {
		try {
			
			ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode rootNode;
			rootNode = objectMapper.readTree(countryInfoService.getPopulation(city.getCountryCode()));
			
	        JsonNode dataArray = rootNode.get(1);
	        
	        if (dataArray.isArray()) {
	            for (JsonNode entry : dataArray) {
	                String date = entry.path("date").asText();
	                if ("2022".equals(date)) {
	                    int population = entry.path("value").asInt();
	                    return population;
	                }
	            }
	        }
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public double getGDP(City city) {
		
		try {
			
			ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode rootNode;
			rootNode = objectMapper.readTree(countryInfoService.getGDP("MZ"));
			
	        JsonNode dataArray = rootNode.get(1);
	        
	        if (dataArray.isArray()) {
	            for (JsonNode entry : dataArray) {
	                String date = entry.path("date").asText();
	                if ("2022".equals(date)) {
	                	Double gdp = entry.path("value").asDouble();
	                    System.out.println(gdp +" ");
	                    return gdp;
	                }
	            }
	        }
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0.0;
	}
	
	public City getInformation(String cityName) {
		
		City city = new City();
		
		double weather = getWeather(cityName, city);
		//From Kelvin to Celcius
		city.setWeather(weather - 173.15);
		
		double gdp = getGDP(city);
		city.setGdp(gdp);
		
		int population = getPopulation(city);
		city.setCurrentPopulation(population);
		
		city.setExchangeRate(getExchange());
		
		return city;
		
	}
	
}
