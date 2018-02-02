package com.PM.PMService;

import java.util.HashMap;

public class SifrarnikMetoda {
	
	public static HashMap<String, String> methods = new HashMap<String, String>();
	
	static {
		methods.put("saveCategory", "M1-1"); //getCategories
		methods.put("getCategories", "M1-2");
		methods.put("updateCategory", "M1-3");
		methods.put("deleteCategory", "M1-4");
		methods.put("saveRiskItem", "M2-1");
		methods.put("updateRiskItem", "M2-2");
		methods.put("deleteRiskItem", "M2-3");
		methods.put("addRisK", "M3-1");
		methods.put("updateRisk", "M3-2");
		methods.put("deleteRisk", "M3-3");
		methods.put("updateRules", "M4-1");
		
	}

}
