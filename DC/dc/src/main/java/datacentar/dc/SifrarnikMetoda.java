package datacentar.dc;

import java.util.HashMap;

public class SifrarnikMetoda {
	
	public static HashMap<String, String> methods = new HashMap<String, String>();
	
	static {
		methods.put("getLicense", "M-P1-1");
		methods.put("saveMerchantLicense", "M-P1-2");
		methods.put("updateMerchantLicense", "M-P1-3");
		methods.put("deleteMerchantLicense", "M-P1-4");
		methods.put("deleteMerchantLicense", "M-P1-4");
		methods.put("getAllTransactions", "M-P2-1");
		methods.put("saveTransaction", "M-P2-2");
		methods.put("updateTransaction", "M-P2-3");
		methods.put("deleteTransaction", "M-P2-4");
		methods.put("getTransactionByMerchantOrder", "M-P2-5");
		methods.put("getTransactionByAcquirerOrder", "M-P2-6");
		methods.put("getTransactionByPayment", "M-P2-7");
		methods.put("getAllClients", "M-I1-1");
		methods.put("saveClient", "M-I1-2");
		methods.put("updateClient", "M-I1-3");
		methods.put("deleteClient", "M-I1-4");
		methods.put("findClientJMBG", "M-I1-5");
		methods.put("getCategories", "M-I2-1");
		methods.put("saveCategory", "M-I2-2");
		methods.put("updateCategory", "M-I2-3");
		methods.put("deleteCategory", "M-I2-4");
		methods.put("findCategoryName", "M-I2-5");
		methods.put("getHomeInsurance", "M-I3-1");
		methods.put("saveHomeInsurance", "M-I3-2");
		methods.put("updateHomeInsurance", "M-I3-3");
		methods.put("deleteHomeInsurance", "M-I3-4");
		methods.put("findHomeOwner", "M-I3-5");
		methods.put("getPolicies", "M-I4-1");
		methods.put("savePolicy", "M-I4-2");
		methods.put("updatePolicy", "M-I4-3");
		methods.put("deletePolicy", "M-I4-4");
		methods.put("getPolicyOwner", "M-I4-5");
		methods.put("getPolicyStart", "M-I4-6");
		methods.put("getPolicyEnd", "M-I4-7");
		methods.put("getPolicyTravel", "M-I4-8");
		methods.put("getImpacts", "M-I5-1");
		methods.put("saveImpact", "M-I5-2");
		methods.put("updateImpact", "M-I5-3");
		methods.put("deletePriceImpact", "M-I5-4");
		methods.put("getImpactByRisk", "M-I5-5");
		methods.put("getPricelists", "M-I6-1");
		methods.put("savePricelist", "M-I6-2");
		methods.put("updatePricelist", "M-I6-3");
		methods.put("deletePricelist", "M-I6-4");
		methods.put("getPricelistDateFrom", "M-I6-5");
		methods.put("getRiskItems", "M-I7-1");
		methods.put("getRiskItem", "M-I7-2");
		methods.put("saveItem", "M-I7-3");
		methods.put("updateRiskItem", "M-I7-4");
		methods.put("deleteItem", "M-I7-5");
		methods.put("getItemByRisk", "M-I7-6");
		methods.put("getAllRisks", "M-I8-1");
		methods.put("saveRisk", "M-I8-2");
		methods.put("updateRisk", "M-I8-3");
		methods.put("deleteRisk", "M-I8-4");
		methods.put("getRiskByName", "M-I8-5");
		methods.put("getAllRules", "M-I9-1");
		methods.put("saveRule", "M-I9-2");
		methods.put("updateRule", "M-I9-3");
		methods.put("deleteRule", "M-I9-4");
		methods.put("getAllTravels", "M-I10-1");
		methods.put("saveTravel", "M-I10-2");
		methods.put("updateTravel", "M-I10-3");
		methods.put("deleteTravel", "M-I10-4");
		methods.put("getAllVehicles", "M-I11-1");
		methods.put("saveVehicle", "M-I11-2");
		methods.put("updateVehicle", "M-I11-3");
		methods.put("deleteVehicle", "M-I11-4");
		methods.put("getAllUsers", "M-U1-1");
		methods.put("saveUser", "M-U1-2");
		methods.put("updateUser", "M-U1-3");
		methods.put("deleteUser", "M-U1-4");
		methods.put("getUserByUsername", "M-U1-5");
		
	}

}
