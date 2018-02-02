package InsurancePOSService.demo.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import InsurancePOSService.demo.SifrarnikMetoda;
import InsurancePOSService.demo.models.Person;

@Controller
@RequestMapping("/persons")
@CrossOrigin("*")
public class PersonsController {
	
	final static Logger logger = LogManager.getLogger(PersonsController.class);
	
	@RequestMapping(value="/peopleInfo", method=RequestMethod.POST)
	@PreAuthorize("hasRole('zaposlen')")
	public ResponseEntity<List<Person>> sendingMail(@RequestBody List<Person> persons) {
		/* to do: */
		// izdvojiti onoga koji ima email (ugovarac osiguranja) i poslati mu email o uspesnoj ili neuspesnoj kupovini osiguranja
		logger.warn("Executing method " + SifrarnikMetoda.methods.get(Thread.currentThread().getStackTrace()[1].getMethodName()));
		return ResponseEntity.ok(persons);
	}
}
