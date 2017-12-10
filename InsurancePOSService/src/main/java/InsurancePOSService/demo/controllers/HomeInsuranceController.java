package InsurancePOSService.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import InsurancePOSService.demo.models.HomeInsurance;
import InsurancePOSService.demo.models.TravelInsurance;

@Controller
@RequestMapping("/homeInsurance")
@CrossOrigin("*")
public class HomeInsuranceController {

	@RequestMapping("/getHomeSurfaces")
	@ResponseBody
	public List<String> getHomeSurfaces() {
		List<String> list = new ArrayList<String>();
		list.add("0-20");
		list.add("20-30");
		list.add("30-50");
		list.add("50+");
		return list;
	}
	
	@RequestMapping("/getHomeAges")
	@ResponseBody
	public List<String> getHomeAges() {
		List<String> list = new ArrayList<String>();
		list.add("0-50");
		list.add("50-100");
		list.add("100+");
		return list;
	}
	
	@RequestMapping("/getHomeValues")
	@ResponseBody
	public List<String> getHomeValues() {
		List<String> list = new ArrayList<String>();
		list.add("0 - 2000e");
		list.add("20000 - 50000e");
		list.add("50000 - 10000e");
		list.add("100000e +");
		return list;
	}
	
	@RequestMapping("/getInsuranceReasons")
	@ResponseBody
	public List<String> getInsuranceReasons() {
		List<String> list = new ArrayList<String>();
		list.add("Flood");
		list.add("Fire");
		list.add("Robbery");
		list.add("Other");
		return list;
	}
	
	@RequestMapping(value="/createHomeInsurance", method=RequestMethod.POST)
	public ResponseEntity<Double> insuranceValue(@RequestBody HomeInsurance insurance) {
		
		// 	TO DO : Na osnovu dobijenih podataka izracunati cenu samo za osiguranje stana i vratiti
 		
		return ResponseEntity.ok(new Double(500));
	}
}
