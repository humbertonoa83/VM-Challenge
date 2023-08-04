package mz.co.vm.api.demo.consume;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Humberto 
 * 
 * This is an API Class Caller
 * Makes an HTTP GET call to the API URL
 * */
@Service
public class ApiCaller {
	
	private final RestTemplate restTemplate;

    public ApiCaller() {
    	
        this.restTemplate = new RestTemplate();
    }

    public String consumeApi(String url) {
    	try {
            return restTemplate.getForObject(url, String.class);    		
    	}catch(HttpClientErrorException exception) {
    		exception.printStackTrace();
    	}
    	
    	return "City Not Found";
    }
}
