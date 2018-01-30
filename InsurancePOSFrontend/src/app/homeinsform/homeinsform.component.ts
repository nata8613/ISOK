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
      err => {
        console.log(err);
      },
    ()=> this.insuranceService.getHomeAges().subscribe(data => this.homeAges = data, 
      err => {
        console.log(err );
      }, 
    () => this.insuranceService.getHomeValues().subscribe(data => this.homeValues = data,
      err => {
        console.log(err);
      }, 
    () => this.insuranceService.getInsuranceReasons().subscribe(data => this.insuranceReasons = data,
      err => {
        console.log(err);
      }))));
  }

  onSubmit(form:NgForm) {
    if(form.invalid)
      return;
    this.insuranceService.createInsurance(this.homeInsurance).subscribe(
      value => {
        console.log('[POST] create Insurance successfully', value);
        this.section5 = false; 
        this.section6 = true;
        this.policy = Object.assign({}, this.policy, {homeInsurance: this.homeInsurance, priceHome:value});
        this.price1 = this.policy.priceCar + this.policy.priceHome + this.policy.priceTravel;
        this.priceEvent.emit(this.price1);
      }, error => {
        console.log('FAIL to create Insurance!' + error);
      },
      () => {
        console.log('POST Insurance - now completed.');
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
