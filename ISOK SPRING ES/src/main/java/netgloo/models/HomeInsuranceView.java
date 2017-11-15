package netgloo.models;

import java.util.ArrayList;

public class HomeInsuranceView {
	
	private String labelName;
	private ArrayList<HomeInsuranceOption> optionList;
	

	public HomeInsuranceView() {
		super();
		this.optionList = new ArrayList<HomeInsuranceOption>();
	}

	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public ArrayList<HomeInsuranceOption> getOptionList() {
		return optionList;
	}
	public void setOptionList(ArrayList<HomeInsuranceOption> optionList) {
		this.optionList = optionList;
	}
	
	
}
