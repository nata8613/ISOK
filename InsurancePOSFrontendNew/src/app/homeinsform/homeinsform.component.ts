import { Component, OnInit, Input } from '@angular/core';
import {HomeInsuranceService} from '../home-insurance.service';

import {HomeInsurance} from '../homeInsurance.interface';

@Component({
  selector: 'app-homeinsform',
  templateUrl: './homeinsform.component.html',
  styleUrls: ['./homeinsform.component.css']
})
export class HomeinsformComponent implements OnInit {

  @Input() price1 : number;
  
  homeInsurance : HomeInsurance;

  homeSurfaces : String[];
  homeAges : String[];
  homeValues : String[];
  insuranceReasons : String[];

  section5 : Boolean = true;
  section6 : Boolean = false;

  constructor( private insuranceService : HomeInsuranceService) { }

  ngOnInit() {
    this.getHomeSurfaces();
    this.getHomeAges();
    this.getHomeValues();
    this.getInsuranceReasons();
    this.homeInsurance = {firstName:'', lastName:'', address:'', jmbg:0, homeSurface:'', homeAge:'', homeValue:'', insuranceReason:'', insuranceLength:0};
  }

  getHomeSurfaces():void{
    this.insuranceService.getHomeSurfaces().subscribe(data => this.homeSurfaces = data,
      err => {
        console.log(err);
      });
  }

  getHomeAges():void{
    this.insuranceService.getHomeAges().subscribe(data => this.homeAges = data, 
      err => {
        console.log(err );
      });
  }

  getHomeValues():void{
    this.insuranceService.getHomeValues().subscribe(data => this.homeValues = data,
      err => {
        console.log(err);
      });
  }

  getInsuranceReasons():void{
    this.insuranceService.getInsuranceReasons().subscribe(data => this.insuranceReasons = data,
      err => {
        console.log(err);
      });
  }

  onSubmit() {
    this.insuranceService.createInsurance(this.homeInsurance).subscribe(
      value => {
        console.log('[POST] create Insurance successfully', value);
        this.price1 = value + this.price1;
        this.section5 = false; 
        this.section6 = true;
      }, error => {
        console.log('FAIL to create Insurance!' + error);
      },
      () => {
        console.log('POST Insurance - now completed.');
      });
  }
}
