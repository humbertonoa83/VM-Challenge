package mz.co.vm.api.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mz.co.vm.api.demo.bean.City;
import mz.co.vm.api.demo.service.TravelService;

@RestController
public class TravelController {
	
	@Autowired
	private TravelService travelService;

	@GetMapping("/information")
	public City test(@RequestParam(value = "city", defaultValue = "Maputo") String city) {
		return travelService.getInformation(city);
	}
}
