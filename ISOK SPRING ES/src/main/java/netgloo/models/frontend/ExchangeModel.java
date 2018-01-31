package netgloo.models.frontend;

import java.util.ArrayList;

public class ExchangeModel {
	
	private MainModel mainmodel;
	private ArrayList<UserDataModel> userDataModel;
	private VehicleModel vehicleModel;
	private HomeModel homeModel;
	private PaymentModel paymentModel;
	public ExchangeModel() {
		super();
	}
	public ExchangeModel(MainModel mainmodel, ArrayList<UserDataModel> userDataModel, VehicleModel vehicleModel,
			HomeModel homeModel, PaymentModel paymentModel) {
		super();
		this.mainmodel = mainmodel;
		this.userDataModel = userDataModel;
		this.vehicleModel = vehicleModel;
		this.homeModel = homeModel;
		this.paymentModel = paymentModel;
	}

	public MainModel getMainmodel() {
		return mainmodel;
	}
	public void setMainmodel(MainModel mainmodel) {
		this.mainmodel = mainmodel;
	}
	public ArrayList<UserDataModel> getUserDataModel() {
		return userDataModel;
	}
	public void setUserDataModel(ArrayList<UserDataModel> userDataModel) {
		this.userDataModel = userDataModel;
	}
	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public HomeModel getHomeModel() {
		return homeModel;
	}
	public void setHomeModel(HomeModel homeModel) {
		this.homeModel = homeModel;
	}
	public PaymentModel getPaymentModel() {
		return paymentModel;
	}
	public void setPaymentModel(PaymentModel paymentModel) {
		this.paymentModel = paymentModel;
	}
	
	

}
