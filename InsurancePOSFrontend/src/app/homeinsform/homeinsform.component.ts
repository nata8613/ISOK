import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {HomeInsuranceService} from '../home-insurance.service';

import {HomeInsurance} from '../homeInsurance.interface';
import {Policy} from '../policy.interface';
import {RiskItem} from '../riskItem.interface';
import { NgForm } from '@angular/forms/src/directives/ng_form';

@Component({
  selector: 'app-homeinsform',
  templateUrl: './homeinsform.component.html',
  styleUrls: ['./homeinsform.component.css']
})
export class HomeinsformComponent implements OnInit {

  @Input() price1 : number;
  @Input() policy: Policy;
  @Output() priceEvent = new EventEmitter<number>();
  @Output() goBackEmitter = new EventEmitter();

  homeInsurance : HomeInsurance;

  homeSurfaces : RiskItem[];
  homeAges : RiskItem[];
  homeValues : RiskItem[];
  insuranceReasons : RiskItem[];

  section5 : Boolean = true;
  section6 : Boolean = false;

  constructor( private insuranceService : HomeInsuranceService) {
    this.getData();
   }

  ngOnInit() {
    this.homeInsurance = this.policy.homeInsurance;
  }

  receivePrice($event) {
    this.price1 = $event;
    this.priceEvent.emit(this.price1);
  }

  getData():void{
    this.insuranceService.getHomeSurfaces().subscribe(data => this.homeSurfaces = data,
    ()=> this.insuranceService.getHomeAges().subscribe(data => this.homeAges = data, 
    () => this.insuranceService.getHomeValues().subscribe(data => this.homeValues = data, 
    () => this.insuranceService.getInsuranceReasons().subscribe(data => this.insuranceReasons = data))));
  }

  onSubmit(form:NgForm) {
    if(form.invalid)
      return;
    this.insuranceService.createInsurance(this.homeInsurance).subscribe(
      value => {
        console.log('[POST] create Insurance successfully', value);
        this.price1 = value + this.price1;
        this.section5 = false; 
        this.section6 = true;
        this.priceEvent.emit(this.price1);
        this.policy = Object.assign({}, this.policy, {homeInsurance: this.homeInsurance});
      });
  }
  continue() {
        this.section5 = false; 
        this.section6 = true;
        this.priceEvent.emit(this.price1);
        this.policy = Object.assign({}, this.policy, {homeInsurance: null});
  }
  showEvent(){
    this.section5=true;
    this.section6 = false;
  }
  goBack(){
    this.goBackEmitter.emit();
  }
}
