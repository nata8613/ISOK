package InsurancePOSService.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import InsurancePOSService.demo.models.Person;
import InsurancePOSService.demo.models.TravelInsurance;

@Controller
@RequestMapping("/persons")
@CrossOrigin("*")
public class PersonsController {
	@RequestMapping(value="/peopleInfo", method=RequestMethod.POST)
	public ResponseEntity<List<Person>> insuranceValue(@RequestBody List<Person> persons) {
		/* to do: */
		// izdvojiti onoga koji ima email (ugovarac osiguranja) i poslati mu email o uspesnoj ili neuspesnoj kupovini osiguranja
		return ResponseEntity.ok(persons);
	}
}
