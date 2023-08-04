package mz.co.vm.api.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mz.co.vm.api.demo.consume.ApiCaller;

/**
 * 
 * @author Humberto Pfumo
 * */
@Service
public class CountryInfoService {

	@Autowired
	private ApiCaller apicaller;
	
	private static final String CODE_POPULATION= "SP.POP.TOTL";
	
	private static final String CODE_GDP= "NY.GDP.MKTP.CD";
	
	public String getPopulation(String countryCode) {
		
		String apiUrl = "https://api.worldbank.org/v2/countries/" + countryCode+"/indicator/"+CODE_POPULATION+"?format=json";
		
		return apicaller.consumeApi(apiUrl);
		
	}
	
	public String getGDP(String countryCode) {
		
		String apiUrl = "https://api.worldbank.org/v2/countries/" + countryCode+"/indicator/"+CODE_GDP+"?format=json";
		
		return  apicaller.consumeApi(apiUrl);
		
	}
}
