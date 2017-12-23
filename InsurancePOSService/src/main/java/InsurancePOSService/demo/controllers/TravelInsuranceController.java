package InsurancePOSService.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import InsurancePOSService.demo.models.TravelInsurance;

@Controller
@RequestMapping("/travelInsurance")
@CrossOrigin("*")
public class TravelInsuranceController {
	
	@RequestMapping("/getRegions")
	@ResponseBody
	public List<String> getRegions() {
		List<String> list = new ArrayList<String>();
		list.add("Evropa");
		list.add("Azija");
		list.add("Severna Amerika");
		list.add("Afrika");
		list.add("Juzna Amerika");
		list.add("Australija");
		return list;
	}
	
	@RequestMapping("/getAges")
	@ResponseBody
	public List<String> getAge() {
		List<String> list = new ArrayList<String>();
		list.add("18");
		list.add("18-60");
		list.add("60+");
		return list;
	}
	
	@RequestMapping("/getSports")
	@ResponseBody
	public List<String> getSport() {
		List<String> list = new ArrayList<String>();
		list.add("None");
		list.add("Football");
		list.add("Swimming");
		list.add("Skiing");
		list.add("Ice skating");
		list.add("Ragbi");
		return list;
	}
	
	// do kog iznosa je osiguran korisnik
	@RequestMapping("/getInsuranceValues")
	@ResponseBody
	public List<String> insuranceValue() {
		List<String> list = new ArrayList<String>();
		list.add("10000e"); 	// do 10000 evra
		list.add("30000e");
		list.add("50000e");
		return list;
	}
	
	//@PostMapping("/createTravelInsurance")
	@RequestMapping(value="/createTravelInsurance", method=RequestMethod.POST)
	public ResponseEntity<Double> insuranceValue(@RequestBody TravelInsurance insurance) {
		
		// 	TO DO : Na osnovu dobijenih podataka izracunati cenu samo za putno osiguranje i vratiti
 		
		return ResponseEntity.ok(new Double(300));
	}
}
