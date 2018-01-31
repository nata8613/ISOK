import { Injectable }  from '@angular/core';
import { MainModel, UserDataModel, VehicleModel, HomeModel } from '../data/model';

@Injectable()
export class ModelDataService {

	private mainModel : MainModel = new MainModel();
    private userDataModel : UserDataModel[] = [];
    private vehicleModel : VehicleModel = new VehicleModel();
    private homeModel : HomeModel = new HomeModel();
    private user : UserDataModel = new UserDataModel();

    getMainData(): MainModel {
        // Return the entire MAIN Data
        return this.mainModel;
    }

    setMain(mainModel: MainModel) {
        
        this.mainModel.dateStart = mainModel.dateStart;
        this.mainModel.dateEnd = mainModel.dateEnd;
        this.mainModel.numOfPersonsLess = mainModel.numOfPersonsLess;
        this.mainModel.numOfPersonsMore = mainModel.numOfPersonsMore;
        this.mainModel.state = mainModel.state;
        this.mainModel.priceRange = mainModel.priceRange;
        this.mainModel.sport = mainModel.sport;
        this.mainModel.email = mainModel.email;
        this.mainModel.totalPrice = mainModel.totalPrice;


    }

    getVehicleData(): VehicleModel {
        return this.vehicleModel;
    }

    getVehicle() : VehicleModel {
        var vehicle : VehicleModel = {
            ownerName: this.vehicleModel.ownerName,
            ownerSurname: this.vehicleModel.ownerSurname,
            ownerJmbg: this.vehicleModel.ownerJmbg,
            brandAndType: this.vehicleModel.brandAndType,
            productionYear: this.vehicleModel.productionYear,
            registration: this.vehicleModel.registration,
            chassis: this.vehicleModel.chassis,
            totalPrice: this.vehicleModel.totalPrice

        };
        return vehicle;
    }

    setVehicle(vehicleModel: VehicleModel) {
        
        this.vehicleModel.ownerName = vehicleModel.ownerName;
        this.vehicleModel.ownerSurname = vehicleModel.ownerSurname;
        this.vehicleModel.ownerJmbg = vehicleModel.ownerJmbg;
        this.vehicleModel.brandAndType = vehicleModel.brandAndType;
        this.vehicleModel.productionYear = vehicleModel.productionYear;
        this.vehicleModel.registration = vehicleModel.registration;
        this.vehicleModel.chassis = vehicleModel.chassis;
        this.vehicleModel.totalPrice = vehicleModel.totalPrice;

    }


    getHomeData(): HomeModel {
        // Return the entire MAIN Data
        return this.homeModel;
    }

    getHome() : HomeModel {
        var home : HomeModel = {
            ownerName: this.homeModel.ownerName,
            ownerJmbg: this.homeModel.ownerJmbg,
            homeAddress: this.homeModel.homeAddress,
            homeAge: this.homeModel.homeAge,
            homeSurface: this.homeModel.homeSurface,
            homeValue: this.homeModel.homeValue,
            insuranceType: this.homeModel.insuranceType,
            totalPrice: this.homeModel.totalPrice
        };
        return home;
    }


    setHome(homeModel: HomeModel) {
        
        this.homeModel.ownerName = homeModel.ownerName;
        this.homeModel.ownerJmbg = homeModel.ownerJmbg;
        this.homeModel.homeAddress = homeModel.homeAddress;
        this.homeModel.homeAge = homeModel.homeAge;
        this.homeModel.homeSurface = homeModel.homeSurface;
        this.homeModel.homeValue = homeModel.homeValue;
        this.homeModel.insuranceType = homeModel.insuranceType;
        this.homeModel.totalPrice = homeModel.totalPrice;

    }

    getUserData(): UserDataModel[] {
        return this.userDataModel;
    }

    setUsers(userModel : UserDataModel[]) {
        this.userDataModel = userModel;
    }

    addUserData(numOfUsers : number) {
        if(numOfUsers != this.userDataModel.length) {
            this.userDataModel = [];
            for(var i=0; i<numOfUsers; i++) {
                this.userDataModel.push(new UserDataModel());
            }
        }
    }
}