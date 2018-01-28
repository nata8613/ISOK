import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {CarInsuranceService} from '../car-insurance.service';

import {CarInsurance} from '../carInsurance.interface';
import {Policy} from '../policy.interface';
import {RiskItem} from '../riskItem.interface';
import { NgForm } from '@angular/forms/src/directives/ng_form';

@Component({
  selector: 'app-carinsform',
  templateUrl: './carinsform.component.html',
  styleUrls: ['./carinsform.component.css']
})
export class CarinsformComponent implements OnInit {

  @Input() price1 : number;
  @Input() policy : Policy;
  @Output() priceEvent = new EventEmitter<number>();
  @Output() goBackEmitter = new EventEmitter();
  section7 : Boolean = true;
  carInsurance : CarInsurance;

  numberOfKms : RiskItem[];
  repairPrices : RiskItem[];
  numbersOfHotelDays : RiskItem[];
  alternativeVehicles : RiskItem[];

  constructor(private carService : CarInsuranceService) {
    this.getData();
   }

  ngOnInit() {
   
    this.carInsurance = this.policy.carInsurance;
  }

  getData():void{
    this.carService.getKilometers().subscribe(data => this.numberOfKms = data,
      err => {
        console.log(err);
      },
    ()=>this.carService.getPrices().subscribe(data => this.repairPrices = data,
      err => {
        console.log(err);
      }, 
    () => this.carService.getHotelDays().subscribe(data => this.numbersOfHotelDays = data,
      err => {
        console.log(err);
      },
    () => this.carService.getAltVehicle().subscribe(data => this.alternativeVehicles = data,
      err => {
        console.log(err);
      }))));
      
  }

  onSubmit(form:NgForm) {
    if(form.invalid)
      return;
    this.carService.createInsurance(this.carInsurance).subscribe(
      value => {
        console.log('[POST] create Car Insurance successfully', value);
        this.price1 = value + this.price1;
        this.priceEvent.emit(this.price1);
        this.policy = Object.assign({}, this.policy, {carInsurance: this.carInsurance});
      }, error => {
        console.log('FAIL to create Insurance!' + error);
      },
      () => {
        console.log('POST Insurance - now completed.');
      });
  }

  onFinish() {
    this.carService.sendPolicy(this.policy).subscribe(
      value => {
        this.section7 = false;
        console.log('[POST] send Policy successfully', value);
      }, error => {
        console.log('FAIL to send Policy!' + error);
      }
    )
  }
  goBack(){
    this.goBackEmitter.emit();
  }
}
