package mz.co.vm.api.demo.bean;

/**
 * @author Humberto Pfumo
 * 
 * This is a Model Class of a City
 * 
 **/
public class City {
	
	private double weather;
	
	private int currentPopulation;
	
	private String exchangeRate;
	
	private double gdp;
	
	private String countryCode;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public City() {
		super();
	}

	public City(double weather, int currentPopulation, String exchangeRate, double gdp, String countryCode) {
		super();
		this.weather = weather;
		this.currentPopulation = currentPopulation;
		this.exchangeRate = exchangeRate;
		this.gdp = gdp;
		this.countryCode=countryCode;
	}

	public double getWeather() {
		return weather;
	}

	public void setWeather(double weather) {
		this.weather = weather;
	}

	public int getCurrentPopulation() {
		return currentPopulation;
	}

	public void setCurrentPopulation(int currentPopulation) {
		this.currentPopulation = currentPopulation;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public double getGdp() {
		return gdp;
	}

	public void setGdp(double gdp) {
		this.gdp = gdp;
	}
	

}
