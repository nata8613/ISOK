import { Injectable }  from '@angular/core';
import { MainModel, UserDataModel, VehicleModel, HomeModel } from '../data/model';
import {SelectedOptions} from "../selectedOptions";

@Injectable()
export class DataService {
    private carModel : SelectedOptions[] = [];

    getCarData():  SelectedOptions[] {
        return this.carModel;
    }

    setCarData(carmodel : SelectedOptions[]) {
        this.carModel = carmodel;
    }
	
}