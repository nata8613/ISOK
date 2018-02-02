package datacentar.dc.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import datacentar.dc.isok.model.MerchantLicense;
import datacentar.dc.isok.model.Role;
import datacentar.dc.isok.model.User;
import datacentar.dc.isok.repo.MerchantLicenseOldRepo;
import datacentar.dc.isok.repo.PermissionRepo;
import datacentar.dc.isok.repo.RoleRepo;
import datacentar.dc.isok.repo.UserRepo;

@Controller
@RequestMapping("/dc/user")
public class UserController {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private PermissionRepo permissionRepo;
	
	//@Autowired
	//private MerchantLicenseOldRepo merchRepo;
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value="/getUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUsers(){
		List<User> clients = (List<User>) userRepo.findAll();
		return clients;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/saveUser/", method = RequestMethod.POST)
	@ResponseBody
	public User saveUser(@RequestBody HashMap<String, Object> user) {
		ObjectMapper mapper = new ObjectMapper();
		User us = mapper.convertValue(user.get("user"), User.class);
	//	List<String> merchantIds = mapper.convertValue(user.get("merchantId"),  new TypeReference<List<String>>() {});
		User client1 = userRepo.findOne(us.getId());
		if (client1 != null)
			return null;
		/*if(merchantIds != null){
			for(String id : merchantIds){
				MerchantLicense merch = merchRepo.findOne(Long.parseLong(id));
				us.getLincenses().add(merch);
			}
		}*/
		client1 = userRepo.save(us);
		return client1;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.POST)
	@ResponseBody
	public User updateClient(@PathVariable("id") long id, @RequestBody HashMap<String, Object> user) {
		ObjectMapper mapper = new ObjectMapper();
		User us = mapper.convertValue(user.get("user"), User.class);
		//List<String> merchantIds = mapper.convertValue(user.get("merchantId"),  new TypeReference<List<String>>() {});
		User client1 = userRepo.findOne(us.getId());		
		if(client1 == null)
			return null;
		client1.setPassword(us.getPassword());
		client1.setAllowed(us.getAllowed());
		User existing = userRepo.findByUsername(us.getUsername());
		if(existing == null)
			client1.setUsername(us.getUsername());
	/*	if(merchantIds != null){
			client1.getLincenses().clear();
			for(String mrId : merchantIds){
				MerchantLicense merch = merchRepo.findOne(Long.parseLong(mrId));
				client1.getLincenses().add(merch);
			}
		}*/
		client1 = userRepo.save(client1);
		return client1;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteUser(@PathVariable("id") long id) {
		User user = userRepo.findOne(id);
		if(user == null)
			return false;
		try {
			userRepo.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/UserByUsername/", method = RequestMethod.POST)
	@ResponseBody
	public User getUserByUsername(@RequestBody String username) {
		User r = userRepo.findByUsername(username);		
		if(r == null)
			return null;
		return r;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/UserTest/", method = RequestMethod.GET)
	@ResponseBody
	public boolean testData() {
		//Set<MerchantLicense> lincenses, Set<Role> allowed
		User u1 = new User ("bladerunner", "test", new HashSet<MerchantLicense>(), new HashSet<Role>());
		User u2 = new User ("batman", "admin", new HashSet<MerchantLicense>(), new HashSet<Role>());
		Role r1 = roleRepo.findByNaziv("zaposlen");
		System.out.println("Naziv Role " + r1.getNaziv());
		Role r2 = roleRepo.findByNaziv("prodavac");
		Role r3 = roleRepo.findByNaziv("finansijski analiticar");
		
		Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder(u1.getUsername());
		String novPass = encoder.encode(u1.getPassword());
		u1.setPassword(novPass);
		u1.getAllowed().add(r1);
		u1.getAllowed().add(r2);
		u1 = userRepo.save(u1);
		encoder = new Pbkdf2PasswordEncoder(u2.getUsername());
		novPass = encoder.encode(u2.getPassword());
		u2.setPassword(novPass);
		u2.getAllowed().add(r1);
		u2.getAllowed().add(r3);
		u2 = userRepo.save(u2);
		return true;
	}
}
