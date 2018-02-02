import { Component, OnInit ,OnDestroy} from '@angular/core';
import { MainModel } from '../data/model';
import { ModelDataService } from '../data/model.service';

import {HomeInsuranceView } from "../HomeInsuranceView";
import {HomeInsuranceOption} from "../HomeInsuranceOption";
import {HomeInsuranceService} from "../home-insurance.service";
import {SelectedOptions} from "../selectedOptions";

@Component({
  selector: 'app-main-step',
  templateUrl: './main-step.component.html',
  styleUrls: ['./main-step.component.css']
})
export class MainStepComponent implements OnInit {
  title = 'Please tell us about yourself.';
  form: any;
  mainmodel : MainModel;
  totalPrice : number = 100;
  homeInsuranceViews: HomeInsuranceView[];
  selectedOption:HomeInsuranceOption;

  item1 : HomeInsuranceView ;
  item2 : HomeInsuranceView ;
  item3 : HomeInsuranceView ;
  item4 : HomeInsuranceView ;

  permission : boolean = true;

  previousSelected1 : SelectedOptions[] = [];
  daysDiff : number = 0;
  constructor(private modelDataService : ModelDataService, private homeInsuranceService : HomeInsuranceService) { }

  ngOnInit() {
    this.getMainStepView();
  	 this.mainmodel = this.modelDataService.getMainData();
     console.log('Main feature loaded!');
  }

    getMainStepView(): void {
    this.homeInsuranceService.getMainStepView().subscribe(data => this.homeInsuranceViews = data,
      err => {
        console.log(err);
      }, () => {this.item1 = this.homeInsuranceViews[0], this.item2 = this.homeInsuranceViews[1], this.item3 = this.homeInsuranceViews[2], this.item4 = this.homeInsuranceViews[3]});
    }

    onChange(newVal, selectedVal) {

      let date1: string = this.mainmodel.dateStart;
      let date2: string = this.mainmodel.dateEnd;

      let diffInMs: number = Date.parse(date2) - Date.parse(date1);
      let diffInDays: number = diffInMs / 1000 / 60 / 60 / 24;

      this.daysDiff = diffInDays;


            if(typeof this.previousSelected1 !== 'undefined' && this.previousSelected1.length > 0) {
              if(this.previousSelected1.some(x => x.labelName === selectedVal)) {
                //ako vec ima uradi nesto
                this.permission = false;
                this.totalPrice = 0;
                this.mainmodel.totalPrice = this.totalPrice.toString();
                for(let entry of this.previousSelected1) {

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

                this.totalPrice = this.totalPrice * (Number(konkretnaVrijednost.price)*Number(this.mainmodel.numOfPersonsLess) +
                Number(konkretnaVrijednost.price)*Number(this.mainmodel.numOfPersonsMore))*this.daysDiff ;
                this.mainmodel.totalPrice = this.totalPrice.toString();

                }
              } else {
                //ako nema dodaj ga u listu
                this.previousSelected1.push(new SelectedOptions(newVal,selectedVal));
              }
      } else {
        this.previousSelected1.push(new SelectedOptions(newVal,selectedVal));
      }


      if(this.permission) { //ako ga nije prije bilo, dodaj na postojece
        for(let entry of this.homeInsuranceViews) {
          for(let option of entry.optionList) {
            if(option.id == newVal) {
              this.totalPrice = this.totalPrice + (Number(option.price)*Number(this.mainmodel.numOfPersonsLess) +
               Number(option.price)*Number(this.mainmodel.numOfPersonsMore))*this.daysDiff;
              this.mainmodel.totalPrice = this.totalPrice.toString();
               break;
             }
          }
        }

      } //end if this.permission

    this.permission = true;
    }  //end of onChange
  
}
