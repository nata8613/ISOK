package netgloo.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import netgloo.models.Client;
import netgloo.models.HomeInsurance;
import netgloo.models.HomeInsuranceOption;
import netgloo.models.HomeInsuranceView;
import netgloo.models.InsuranceCategory;
import netgloo.models.Policy;
import netgloo.models.PriceImpacts;
import netgloo.models.Risk;
import netgloo.models.RiskItem;
import netgloo.models.TravelInsurance;
import netgloo.models.VehicleInsurance;
import netgloo.models.frontend.ExchangeModel;
import netgloo.models.frontend.HomeModel;
import netgloo.models.frontend.MainModel;
import netgloo.models.frontend.UserDataModel;
import netgloo.models.frontend.VehicleModel;

@Controller
@RequestMapping("/travelInsurance")
@CrossOrigin("*")
public class TravelController {
	
	
	private String urlBase;
	private RestTemplate rest;
	private HttpHeaders headers;
	private Map<String, Object> params;
	private HttpEntity<Map<String, Object>> requestEntity;
	
	
	public TravelController(){
		urlBase = "http://localhost:8080/dc/isok/";
		rest = new RestTemplate();
		headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json");
	    headers.add("Accept", "*/*");
		params = new HashMap<String, Object>();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/saveData")
	@ResponseBody
	public String saveData(@RequestBody ExchangeModel exchangeModel) {

		// TODO : prepakovati u zanine modele i pozvati njene metode za cuvanje
		MainModel mainModel = exchangeModel.getMainmodel();
		ArrayList<UserDataModel> userDataModel = exchangeModel.getUserDataModel();
		VehicleModel vehicleModel = exchangeModel.getVehicleModel();
		HomeModel homeModel = exchangeModel.getHomeModel();
		
		Policy policyDal = new Policy();
		Set<Client> clients = new HashSet<Client>();
		Client insuranceOwner = new Client();
		Set<RiskItem> riskItems = new HashSet<RiskItem>();
		
		for(UserDataModel p : userDataModel){
			if(p.getEmail()!=null && !p.getEmail().trim().isEmpty()){
				insuranceOwner = new Client(p.getFirstName(), p.getLastName(), p.getPassportNumber(), p.getJmbg(), p.getAddress(), p.getMobile(), p.getEmail(), null, null);
			}
			else
				clients.add(new Client(p.getFirstName(), p.getLastName(), p.getPassportNumber(), p.getJmbg(), p.getAddress(), p.getMobile(), p.getEmail(), null, null));
		}
		
		int totalPeople = Integer.valueOf(mainModel.getNumOfPersonsLess()) + Integer.valueOf(mainModel.getNumOfPersonsMore());
		
		TravelInsurance travelIns = new TravelInsurance(insuranceOwner.getClientEmail(), totalPeople, 300);	// THIS PRICE
		HttpEntity<TravelInsurance> requestEntity= new HttpEntity<TravelInsurance>(travelIns, this.headers);		
		TravelInsurance travelInsNew = (TravelInsurance) rest.postForObject(this.urlBase+"saveTravelInsurance/", requestEntity, TravelInsurance.class);
		
		//END SAVING TRAVELINSURANCE
		
		//ZA KUCU
		Date date1 = new Date(mainModel.getDateStart());
		Date date2 = new Date(mainModel.getDateEnd());
		int diff = daysBetween(date1,date2);
		
		if(homeModel!=null){
			HomeInsurance homeIns = new HomeInsurance(homeModel.getOwnerName(),homeModel.getOwnerName(), homeModel.getOwnerJmbg(), diff);
			HttpEntity<HomeInsurance> requestEntity2 = new HttpEntity<HomeInsurance>(homeIns, this.headers);
			HomeInsurance homeInsNew = (HomeInsurance) rest.postForObject(this.urlBase+"saveHomeIns/", requestEntity2, HomeInsurance.class);
			riskItems.add(getRiskItemById(homeModel.getHomeAge()));
			riskItems.add(getRiskItemById(homeModel.getHomeSurface()));
			riskItems.add(getRiskItemById(homeModel.getHomeValue()));
			riskItems.add(getRiskItemById(homeModel.getInsuranceType()));
			policyDal.setHomeInsurance(homeInsNew);
		}
		
		//ZA AUTA
		if(vehicleModel.getBrandAndType()!=null && Integer.parseInt(vehicleModel.getProductionYear())!=0){
			VehicleInsurance carIns  = new VehicleInsurance(vehicleModel.getBrandAndType(),vehicleModel.getProductionYear(), vehicleModel.getRegistration(), vehicleModel.getChassis(), vehicleModel.getOwnerName(), vehicleModel.getOwnerSurname(), vehicleModel.getOwnerJmbg());	
			HttpEntity<VehicleInsurance> requestEntity3 = new HttpEntity<VehicleInsurance>(carIns, this.headers);
			VehicleInsurance carInsNew = (VehicleInsurance) rest.postForObject(this.urlBase+"saveVehicleInsurance/", requestEntity3, VehicleInsurance.class);
//			if(carInsDTO.getRepairPrice()!="")
//				riskItems.add(getRiskItemById(carInsDTO.getRepairPrice()));
//			if(carInsDTO.getNumberOfHotelDays()!="")
//				riskItems.add(getRiskItemById(carInsDTO.getNumberOfHotelDays()));
//			if(carInsDTO.getAlternativeVehicle()!="")
//				riskItems.add(getRiskItemById(carInsDTO.getAlternativeVehicle()));
//			if(carInsDTO.getNumberOfKm()!="")	
//				riskItems.add(getRiskItemById(carInsDTO.getNumberOfKm()));
			policyDal.setVehicleInsurance(carInsNew);
		}
		
		//ZA KLIJENTE
		Set<Client> clientsIds = new HashSet<Client>();
		for(Client c : clients){
			HttpEntity<Client> requestEntity4 = new HttpEntity<Client>(c, this.headers);
			Client clientNew = (Client) rest.postForObject(this.urlBase+"saveClient/", requestEntity4, Client.class);
			clientsIds.add(clientNew);
		}
		
		HttpEntity<Client> requestEntity4 = new HttpEntity<Client>(insuranceOwner, this.headers);
		Client insuranceOwnerNew = (Client) rest.postForObject(this.urlBase+"saveClient/", requestEntity4, Client.class);
		clientsIds.add(insuranceOwnerNew);
		
		double sumPrice = Double.parseDouble(mainModel.getTotalPrice()) + Double.parseDouble(vehicleModel.getTotalPrice()) +
				Double.parseDouble(homeModel.getTotalPrice());
		policyDal.setClients(clientsIds);
		policyDal.setContractStart(date1);
		policyDal.setContractEnd(date2);
		policyDal.setInsuranceOwner(insuranceOwnerNew);
		policyDal.setPriceSummed(sumPrice);
		policyDal.setTravelInsurance(travelInsNew);
		
		riskItems.add(getRiskItemById(mainModel.getPriceRange()));
		riskItems.add(getRiskItemById(mainModel.getState()));
		if(mainModel.getSport()!="")
			riskItems.add(getRiskItemById(mainModel.getSport()));
		riskItems.add(getRiskItemById(mainModel.getTotalPrice()));
		
		policyDal.setRiskItems(riskItems);
		HttpEntity<Policy> requestEntity5 = new HttpEntity<Policy>(policyDal, this.headers);
		Policy response = (Policy)rest.postForObject(this.urlBase+"savePolicy/", requestEntity5, Policy.class);
		System.out.println("Response is " + response.getPriceSummed());
		
		return "DONE";
	}
	
	private RiskItem getRiskItemById(String id){
		this.params.put("id", id);
		this.requestEntity = new HttpEntity<Map<String, Object>>(this.params, this.headers);
		RiskItem item = (RiskItem)rest.postForObject(this.urlBase+"getRiskItem/", this.requestEntity, RiskItem.class);
		return item;
	}
	
	 public int daysBetween(Date d1, Date d2) {
	        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	    }

	@RequestMapping("/getTravelInsuranceData")
	@ResponseBody
	public List<HomeInsuranceView> getTravelInsuranceData() {

		List<HomeInsuranceView> listForView = new ArrayList<HomeInsuranceView>();

		System.out.println("Poslao upit");
		
		InsuranceCategory ic = rest.postForObject(this.urlBase+"categoryName/TravelInsurance", null, InsuranceCategory.class);																					// svih
		List<Risk> newRisks = new ArrayList();
		newRisks.addAll(ic.getRisks());
		Collections.sort(newRisks, new Comparator<Risk>(){
		     public int compare(Risk o1, Risk o2){
		         if(o1.getId() == o2.getId())
		             return 0;
		         return o1.getId() < o2.getId() ? -1 : 1;
		     }
		});
		List<RiskItem> riskItemList = new ArrayList<RiskItem>();// riskitem
		HomeInsuranceView homeInsV = null;
		for(Risk r : newRisks){
			List<HomeInsuranceOption> temp = new ArrayList<HomeInsuranceOption>();
			riskItemList.addAll(r.getRiskItems());
			homeInsV = new HomeInsuranceView();
			homeInsV.setLabelName(r.getRiskName());
			
			for (RiskItem ri : r.getRiskItems()) {

				HomeInsuranceOption hio = null;
					hio = new HomeInsuranceOption();
					hio.setId(String.valueOf(ri.getId()));
					hio.setName(ri.getItemName());
					// JOS CIJENU IZVUCI u hio
					PriceImpacts priceIp = ri.getImpacts().iterator().next();
					hio.setPrice(priceIp.getValue());
				if (hio != null)
					temp.add(hio);
			}
			homeInsV.getOptionList().addAll(temp);
			listForView.add(homeInsV);
		}																						// sa
																								// homecategory

		
		System.out.println(listForView);

		return listForView;

	}

}
