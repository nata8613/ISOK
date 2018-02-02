package InsurancePOSService.demo;

import java.util.HashMap;

public class SifrarnikMetoda {
	
	public static HashMap<String, String> methods = new HashMap<String, String>();
	
	static {
		methods.put("carInsuranceValue", "M1-1");
		methods.put("homeInsuranceValue", "M1-2");
		methods.put("travelInsuranceValue", "M1-3"); //
		methods.put("savePolicy", "M1-4");
		methods.put("sendingMail", "M1-5");
	}

}
