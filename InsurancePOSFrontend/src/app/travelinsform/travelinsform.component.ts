import { Component, OnInit } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { NgForm } from '@angular/forms';
import {TravelInsuranceService} from '../travel-insurance.service';
import {TravelInsurance} from '../travelInsurance.interface';
import {Person} from '../person.interface';
import {Policy} from '../policy.interface';
import {RiskItem} from '../riskItem.interface';

@Component({
  selector: 'app-travelinsform',
  templateUrl: './travelinsform.component.html',
  styleUrls: ['./travelinsform.component.css']
})
export class TravelinsformComponent implements OnInit {

  travelInsurance : TravelInsurance = {startingDate: null, endingDate: null, region: '', numberOfPeople: 0, ages: '', sport: '', ammount: ''}

  section1 : Boolean = true;

  regions : RiskItem[];
  all_ages : RiskItem[];
  sports : RiskItem[];
  insuranceValues : RiskItem[];

  price1 : number=0;

  section2 : Boolean = false;

  policy : Policy = {travelInsurance: this.travelInsurance, people: [],
     homeInsurance: {firstName:'', lastName:'', address:'', jmbg:0, homeSurface:'', homeAge:'', homeValue:'', insuranceReason:'', insuranceLength:0},
      carInsurance: {insuranceLength:0, numberOfKm:'', repairPrice:'', numberOfHotelDays:'', 
      alternativeVehicle:'', typeOfVehicle:'', yearOfProduction:0, regTable:'', chassisNumber:'', 
      firstName:'', lastName:'', jmbg:0}};
  constructor(private insuranceService : TravelInsuranceService) { 
    this.getData();
  }

  ngOnInit() {
    
  }

  receivePrice($event) {
    console.log("received "+$event);
    this.price1 = $event;
  }

  getData():void{
    this.insuranceService.getTravelRegions().subscribe(data => this.regions = data,
      err => {
        console.log(err);
      }, 
    () => this.insuranceService.getAges().subscribe(data => this.all_ages = data,
      err => {
        console.log(err);
      },
    () =>this.insuranceService.getSports().subscribe(data => this.sports = data,
      err => {
        console.log(err);
      },
    () => this.insuranceService.getInsuranceValues().subscribe(data => this.insuranceValues = data,
      err => {
        console.log(err);
      }))));
  }


  onSubmit(form:NgForm) {
    if(form.invalid)
      return;
    this.insuranceService.createInsurance(this.travelInsurance).subscribe(
      value => {
        console.log('[POST] create Insurance successfully', value);
        this.price1 = value;
        this.section1 = false;
        this.section2 = true;
        this.policy = Object.assign({}, this.policy, {travelInsurance: this.travelInsurance});
      }, error => {
        console.log('FAIL to create Insurance!' + error);
      },
      () => {
        console.log('POST Insurance - now completed.');
      });
  }
  showEvent(){
    this.section1 = true;
    this.section2=false;
  }
}
