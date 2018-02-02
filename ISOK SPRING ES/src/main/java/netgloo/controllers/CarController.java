package netgloo.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import netgloo.models.HomeInsuranceOption;
import netgloo.models.HomeInsuranceView;
import netgloo.models.InsuranceCategory;
import netgloo.models.PriceImpacts;
import netgloo.models.Risk;
import netgloo.models.RiskItem;

@Controller
@RequestMapping("/carInsurance")
@CrossOrigin("*")
public class CarController {
	
	
	private String urlBase;
	private RestTemplate rest;
	private HttpHeaders headers;
	private Map<String, Object> params;
	private HttpEntity<Map<String, Object>> requestEntity;
	
	
	public CarController(){
		urlBase = "http://localhost:8080/dc/isok/";
		rest = new RestTemplate();
		headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json");
	    headers.add("Accept", "*/*");
		params = new HashMap<String, Object>();
	}
	
	@RequestMapping("/getCarInsuranceData")
	@ResponseBody
	public List<HomeInsuranceView> getTravelInsuranceData() {

		List<HomeInsuranceView> listForView = new ArrayList<HomeInsuranceView>();

		System.out.println("Poslao upit");
		
		InsuranceCategory ic = rest.postForObject(this.urlBase+"categoryName/VehicleInsurance", null, InsuranceCategory.class);																					// svih
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
//	
//
//	@RequestMapping("/getCarInsuranceData")
//	@ResponseBody
//	public List<HomeInsuranceView> getTravelInsuranceData() {
//		
//List<HomeInsuranceView> listForView = new ArrayList<HomeInsuranceView>();
//		
//		InsuranceCategory insuranceCategory = insuranceCategoryDao.findByCategoryName("CarInsurance");
//		List<InsuranceCategory_Risk> listInsCatRisk = insuranceCategoryRiskDao
//				.findByInsuranceCategoryID(insuranceCategory.getId());
//		
//		
//		List<Long> tempNumRisk = new ArrayList<Long>();
//		
//		for(InsuranceCategory_Risk icr : listInsCatRisk) {
//			tempNumRisk.add(icr.getRiskID());
//		}
//		List<RiskItem> riskItemList = (List<RiskItem>) riskItemDao.findByRiskIDIn(tempNumRisk); //lista svih riskitem sa homecategory
//		
//		List<Long> tempRiskItemList = new ArrayList<Long>();
//		for(RiskItem ri:riskItemList) {
//			tempRiskItemList.add(ri.getId());
//		}
//		List<PriceImpacts> listPriceImpacts = (List<PriceImpacts>) priceImpactDao.findByRiskItemIdIn(tempRiskItemList);
//		HomeInsuranceView homeInsV = null;
//		for(Long l : tempNumRisk) {
//			homeInsV = new HomeInsuranceView();
//			homeInsV.setLabelName(riskDao.findOne(l).getRiskName()); //postavljanje labele
//			
//			List<HomeInsuranceOption> temp = new ArrayList<HomeInsuranceOption>();
//			for(RiskItem ri:riskItemList) {
//				
//				HomeInsuranceOption hio = null;
//				if(ri.getRiskID() == l) {
//					hio = new HomeInsuranceOption();
//					hio.setId(String.valueOf(ri.getId()));
//					hio.setName(ri.getItemName());
//					//JOS CIJENU IZVUCI u hio
//					hio.setPrice(findByRiskItemID(listPriceImpacts,ri.getId()));
//				}
//				if(hio != null)
//					temp.add(hio);
//			}
//			homeInsV.getOptionList().addAll(temp);
//			listForView.add(homeInsV);
//		}
//			System.out.println(listForView);
//			
//			
//			return listForView;
//		
//	}
//	
//		public double findByRiskItemID(List<PriceImpacts> listPriceImpacts, Long riskItemID) {
//			double num = 0 ;
//			for(PriceImpacts pi : listPriceImpacts) {
//				if(pi.getRiskItemId() == riskItemID) {
//					num = pi.getValue();
//					break;
//				}
//			}
//			return num;
//		}
	

}
