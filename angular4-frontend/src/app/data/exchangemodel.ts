import { MainModel, VehicleModel, UserDataModel , HomeModel, PaymentModel } from '../data/model';

export class ExchangeModel {
	mainmodel: MainModel ;
	userDataModel:UserDataModel[];
	vehicleModel: VehicleModel;
	homeModel : HomeModel;
	paymentModel: PaymentModel;

	constructor(mainmodel: MainModel,userDataModel:UserDataModel[], vehicleModel: VehicleModel,homeModel : HomeModel, paymentModel: PaymentModel) {
		this.mainmodel = mainmodel;
		this.userDataModel = userDataModel;
		this.vehicleModel = vehicleModel;
		this.homeModel = homeModel;
		this.paymentModel = paymentModel;
	}
}

