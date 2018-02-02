import { Component, OnInit , OnDestroy} from '@angular/core';
import { VehicleModel, HomeModel } from '../data/model';
import { ModelDataService } from '../data/model.service';
import {HomeInsuranceView } from "../HomeInsuranceView";
import {HomeInsuranceOption} from "../HomeInsuranceOption";
import {HomeInsuranceService} from "../home-insurance.service";
import {SelectedOptions} from "../selectedOptions";
import {DataService} from "../data/data.service";

@Component({
	selector: 'app-additional-step',
	templateUrl: './additional-step.component.html',
	styleUrls: ['./additional-step.component.css']
})
export class AdditionalStepComponent implements OnInit {
	title = 'We offer additional vehicle or house insurance. Check it.';
	vehicleModel : VehicleModel;
	homeModel : HomeModel;

	x : string[] = ["vehicleModel.brandAndType","vehicleModel.productionYear"];


	permissionCar : boolean = true;
	permissionHome : boolean = true;

	totalPriceCar : number = 100;
  totalPriceCarTemp : number = 100;

	totalPriceHome : number = 100;
  totalPriceHomeTemp : number = 100;

	homeInsuranceViews: HomeInsuranceView[];
	carInsuranceViews: HomeInsuranceView[];
 	selectedOption:HomeInsuranceOption;


 	item1 : HomeInsuranceView ;
	item2 : HomeInsuranceView ;
  item7 : HomeInsuranceView ;
  item8 : HomeInsuranceView ;

	item3 : HomeInsuranceView ;
	item4 : HomeInsuranceView ;
	item5 : HomeInsuranceView ;
	item6 : HomeInsuranceView ;
 	previousSelectedCar : SelectedOptions[] = [];
 	previousSelectedHome : SelectedOptions[] = [];

	constructor(private modelDataService : ModelDataService, 
		private homeInsuranceService : HomeInsuranceService, 
		private dataService : DataService) { }

	ngOnInit() {
		 this.previousSelectedCar = this.dataService.getCarData();
		 this.getCarInsuranceView();
		 this.getHomeInsuranceView();
		 this.vehicleModel = this.modelDataService.getVehicleData();
		 this.homeModel = this.modelDataService.getHomeData();

     this.previousSelectedHome = this.dataService.getHomeData();
     this.previousSelectedCar =  this.dataService.getCarData();
		 console.log('Vehicle feature loaded!');
	}

	 OnDestroy() {
  	 this.modelDataService.setVehicle(this.vehicleModel);
  	 this.modelDataService.setHome(this.homeModel);
  }

   onChangeCar(newVal, selectedVal) {

   	 if(typeof this.previousSelectedCar !== 'undefined' && this.previousSelectedCar.length > 0) {

   	 	 if(this.previousSelectedCar.some(x => x.labelName === selectedVal)) {

   	 	 	 this.permissionCar = false;
                //this.totalPriceCarTemp = 100;
                this.vehicleModel.totalPrice = this.totalPriceCarTemp.toString();
                for(let entry of this.previousSelectedCar) {

                if(entry.labelName == selectedVal) {
                  entry.id = newVal;
                }
                 
                let grupacija ;

                for(let nesto1 of this.carInsuranceViews) {
                  if(nesto1.labelName == entry.labelName) {
                    grupacija = nesto1;
                    break;
                  }
                }

                  //////

                let konkretnaVrijednost;
                for(let nesto2 of grupacija.optionList) {
                  if(nesto2.id == entry.id) {
                    konkretnaVrijednost = nesto2;
                    break;
                  }
                }

                this.totalPriceCar = this.totalPriceCarTemp + Number(this.totalPriceCarTemp) *Number(konkretnaVrijednost.price);
                this.vehicleModel.totalPrice = this.totalPriceCar.toString();
			}
   	 	 } else {
                //ako nema dodaj ga u listu
             this.previousSelectedCar.push(new SelectedOptions(newVal,selectedVal));
         }
   	 } else {
        this.previousSelectedCar.push(new SelectedOptions(newVal,selectedVal));
      }

        if(this.permissionCar) { //ako ga nije prije bilo, dodaj na postojece
        for(let entry of this.carInsuranceViews) {
          for(let option of entry.optionList) {
            if(option.id == newVal) {
              this.totalPriceCar =this.totalPriceCarTemp + Number(this.totalPriceCarTemp) * Number(option.price);
              this.vehicleModel.totalPrice = this.totalPriceCar.toString();
               break;
             }
          }
        }

      } //end if this.permission
    this.permissionCar = true;
    this.dataService.setCarData(this.previousSelectedCar);
   
	}


  getHomeInsuranceView(): void {
    this.homeInsuranceService.getHomeInsuranceView().subscribe(data => this.homeInsuranceViews = data,
      err => {
        console.log(err);
      }, () => {this.item3 = this.homeInsuranceViews[0], this.item4 = this.homeInsuranceViews[1], this.item5 = this.homeInsuranceViews[2], this.item6 = this.homeInsuranceViews[3]});
    }

    getCarInsuranceView(): void {
    this.homeInsuranceService.getCarInsuranceView().subscribe(data =>  this.carInsuranceViews = data,
      err => {
        console.log(err);
      }, () => {this.item1 = this.carInsuranceViews[0], this.item2 = this.carInsuranceViews[1], this.item7 = this.carInsuranceViews[2], this.item8 = this.carInsuranceViews[3]});
    }

    callback():void {

    }


       onChangeHome(newVal, selectedVal) {

   	 if(typeof this.previousSelectedHome !== 'undefined' && this.previousSelectedHome.length > 0) {

   	 	 if(this.previousSelectedHome.some(x => x.labelName === selectedVal)) {

   	 	 	 this.permissionHome = false;
                //this.totalPriceHomeTemp = 100;
                this.homeModel.totalPrice = this.totalPriceHomeTemp.toString();
                for(let entry of this.previousSelectedHome) {

                if(entry.labelName == selectedVal) {
                  entry.id = newVal;
                }
                 
                let grupacija ;

                for(let nesto1 of this.homeInsuranceViews) {
                  if(nesto1.labelName == entry.labelName) {
                    grupacija = nesto1;
                    break;
                  }
                }

                  //////

                let konkretnaVrijednost;
                for(let nesto2 of grupacija.optionList) {
                  if(nesto2.id == entry.id) {
                    konkretnaVrijednost = nesto2;
                    break;
                  }
                }

                this.totalPriceHome = this.totalPriceHomeTemp + Number(this.totalPriceHomeTemp) * Number(konkretnaVrijednost.price);
                this.homeModel.totalPrice = this.totalPriceHome.toString();
			}
   	 	 } else {
                //ako nema dodaj ga u listu
             this.previousSelectedHome.push(new SelectedOptions(newVal,selectedVal));
         }
   	 } else {
        this.previousSelectedHome.push(new SelectedOptions(newVal,selectedVal));
      }

        if(this.permissionHome) { //ako ga nije prije bilo, dodaj na postojece
        for(let entry of this.homeInsuranceViews) {
          for(let option of entry.optionList) {
            if(option.id == newVal) {
              this.totalPriceHome =this.totalPriceHomeTemp + Number(this.totalPriceHomeTemp) * Number(option.price);
              this.homeModel.totalPrice = this.totalPriceHome.toString();
               break;
             }
          }
        }

      } //end if this.permission

    this.permissionHome = true;
    this.dataService.setHomeData(this.previousSelectedHome);
	}

}
