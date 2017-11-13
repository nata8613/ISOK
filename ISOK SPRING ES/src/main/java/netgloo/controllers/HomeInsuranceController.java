package netgloo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import netgloo.dao.HomeAgeDAO;
import netgloo.dao.HomeInsuranceDAO;
import netgloo.dao.HomeOwnerDAO;
import netgloo.dao.HomeSurfaceDAO;
import netgloo.dao.HomeValueDAO;
import netgloo.dao.InsuranceTypeDAO;
import netgloo.models.homeInsurance.HomeAge;
import netgloo.models.homeInsurance.HomeInsurance;
import netgloo.models.homeInsurance.HomeOwner;
import netgloo.models.homeInsurance.HomeSurface;
import netgloo.models.homeInsurance.HomeValue;
import netgloo.models.homeInsurance.InsuranceType;

@Controller
@RequestMapping("/homeInsurance")
@CrossOrigin("*")
public class HomeInsuranceController {



	@RequestMapping("/getAllInsuranceTypes")
	@ResponseBody
	public List<InsuranceType> getAllInsuranceTypes() {

		try {
			List<InsuranceType> listInsuranceTypes = (List<InsuranceType>) insuranceTypeDao.findAll();
			return listInsuranceTypes;
		} catch (Exception ex) {
			return null;
		}
	}
	
	@RequestMapping("/getAllHomeAges")
	@ResponseBody
	public List<HomeAge> getAllHomeAges() {

		try {
			List<HomeAge> listHomeAges = (List<HomeAge>) homeAgeDao.findAll();
			return listHomeAges;
		} catch (Exception ex) {
			return null;
		}
	}
	
	@RequestMapping("/getAllHomeInsurances")
	@ResponseBody
	public List<HomeInsurance> getAllHomeInsurances() {

		try {
			List<HomeInsurance> listHomeInsurance = (List<HomeInsurance>) homeInsuranceDao.findAll();
			return listHomeInsurance;
		} catch (Exception ex) {
			return null;
		}
	}
	
	@RequestMapping("/getAllHomeOwners")
	@ResponseBody
	public List<HomeOwner> getAllHomeOwners() {

		try {
			List<HomeOwner> listHomeOwner = (List<HomeOwner>) homeOwnerDao.findAll();
			return listHomeOwner;
		} catch (Exception ex) {
			return null;
		}
	}
	
	@RequestMapping("/getAllHomeSurfaces")
	@ResponseBody
	public List<HomeSurface> getAllHomeSurfaces() {

		try {
			List<HomeSurface> listHomeSurface = (List<HomeSurface>) homeSurfaceDao.findAll();
			return listHomeSurface;
		} catch (Exception ex) {
			return null;
		}
	}
	
	@RequestMapping("/getAllHomeValues")
	@ResponseBody
	public List<HomeValue> getAllHomeValues() {

		try {
			List<HomeValue> listHomeValue = (List<HomeValue>) homeValueDao.findAll();
			return listHomeValue;
		} catch (Exception ex) {
			return null;
		}
	}
	
	/**
	**PRIVATE FIELDS
	*/
	
	@Autowired
	private InsuranceTypeDAO insuranceTypeDao;
	
	@Autowired
	private HomeAgeDAO homeAgeDao;
	
	@Autowired
	private HomeOwnerDAO homeOwnerDao;
	
	@Autowired
	private HomeSurfaceDAO homeSurfaceDao;
	
	@Autowired
	private HomeValueDAO homeValueDao;
	
	@Autowired
	private HomeInsuranceDAO homeInsuranceDao;
}
