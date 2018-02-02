import { Injectable }  from '@angular/core';
import { MainModel, UserDataModel, VehicleModel, HomeModel } from '../data/model';
import {SelectedOptions} from "../selectedOptions";

@Injectable()
export class DataService {
    private carModel : SelectedOptions[] = [];

    private homeModel : SelectedOptions[] = [];


    getCarData():  SelectedOptions[] {
        return this.carModel;
    }

    setCarData(carmodel : SelectedOptions[]) {
        this.carModel = carmodel;
    }




    getHomeData(): SelectedOptions[] {
    	return this.homeModel;
    }

    setHomeData(homeModel : SelectedOptions[]) {
    	this.homeModel = homeModel;
    }
	
}