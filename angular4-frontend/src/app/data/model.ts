export class MainModel {
    dateStart: string = '';
    dateEnd : string = '';
    numOfPersonsLess: string = '';
    numOfPersonsMore: string = '';
    state : string = '';
    priceRange: string = '';
    sport: string = '';
    email: string = '';
    personalAge: string = '';
    totalPrice: string = '';
}

export class UserDataModel {
	firstName: string = '';
	lastName: string = '';
	passportNumber: string = '';
	jmbg: string = '';
	address: string = '';
	mobile: string = '';
	email: string = '';
}

export class VehicleModel {
	ownerName: string = '';
	ownerSurname: string = '';
	ownerJmbg: string = '';
	brandAndType: string = '';
	productionYear: string = '';
	registration: string = '';
	chassis: string = '';
	totalPrice: string = '';
	repairPrice : string = '';
	hotelDays : string = '';
	altVehicle : string = '';
	transportKm : string = '';
}

export class HomeModel {
	ownerName: string = '';
	ownerJmbg: string = '';
	homeAddress: string = '';
	homeAge: string = '';
	homeSurface: string = '';
	homeValue: string = '';
	insuranceType: string = '';
	totalPrice: string = '';
}

export class PaymentModel {
    intent: string = '';
    orderID : string = '';
    payerID : string = '';
    paymentID : string = '';
    paymentToken : string = '';

    constructor( intent: string,  orderID : string, payerID : string, paymentID : string, paymentToken : string) {
    	this.intent = intent;
    	this.orderID = orderID;
    	this.payerID = payerID;
    	this.paymentID = paymentID;
    	this.paymentToken = paymentToken;
    }
}