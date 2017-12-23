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

import InsurancePOSService.demo.models.TravelInsurance;

@Controller
@RequestMapping("/carInsurance")
@CrossOrigin("*")
public class CarInsuranceController {
	
	@RequestMapping("/getKilometers")
	@ResponseBody
	public List<String> getKilometers() {
		List<String> list = new ArrayList<String>();
		list.add("0 - 5km");
		list.add("5 - 50km");
		list.add("50 - 100km");
		return list;
	}
	
	@RequestMapping("/getPrices")
	@ResponseBody
	public List<String> getPrices() {
		List<String> list = new ArrayList<String>();
		list.add("0 - 500e");
		list.add("500 - 1500e");
		list.add("1500 - 5000e");
		return list;
	}
	
	@RequestMapping("/getHotelDays")
	@ResponseBody
	public List<String> getHotelDays() {
		List<String> list = new ArrayList<String>();
		list.add("0 - 2");
		list.add("2 - 5");
		list.add("5 - 10");
		list.add("5+");
		return list;
	}
	
	@RequestMapping("/getAltVehicle")
	@ResponseBody
	public List<String> getAltVehicle() {
		List<String> list = new ArrayList<String>();
		list.add("Kombi");
		list.add("Auto");
		return list;
	}
	
	@RequestMapping(value="/createCarInsurance", method=RequestMethod.POST)
	public ResponseEntity<Double> insuranceValue(@RequestBody CarInsuranceController insurance) {
		
		// 	TO DO : Na osnovu dobijenih podataka izracunati cenu samo za osiguranje pomoc na putu i vratiti
 		
		return ResponseEntity.ok(new Double(700));
	}
}
