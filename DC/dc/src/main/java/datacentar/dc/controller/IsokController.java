package datacentar.dc.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import datacentar.dc.isok.model.HomeAge;
import datacentar.dc.isok.model.Risk;
import datacentar.dc.isok.repo.HomeAgeRepo;
import datacentar.dc.isok.repo.RiskRepo;
import datacentar.dc.pcc.model.Bank;
import datacentar.dc.pcc.repo.BankRepo;

@Controller
@RequestMapping("/dc/isok")
public class IsokController {

	@RequestMapping("/getRisks")
	@ResponseBody
	public List<Risk> getAllRisks(){
		
		List<Risk> risks = new ArrayList<Risk>();
		risks = (List<Risk>) riskRepo.findAll();
		System.out.println(risks.get(0));
		return risks;
	}
	
	@RequestMapping("/getHomeAges")
	@ResponseBody
	public List<HomeAge> getAllHomeAges(){
		
		List<HomeAge> ages = new ArrayList<HomeAge>();
		ages = (List<HomeAge>) homeAgeRepo.findAll();
		System.out.println(ages.get(0));
		return ages;
	}

	
	@Autowired
	private HomeAgeRepo homeAgeRepo;
	
	@Autowired
	private RiskRepo riskRepo;

}
