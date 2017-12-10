import { Component, OnInit } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {TravelInsuranceService} from '../travel-insurance.service';
import {TravelInsurance} from '../travelInsurance.interface';
import {Person} from '../person.interface';

@Component({
  selector: 'app-travelinsform',
  templateUrl: './travelinsform.component.html',
  styleUrls: ['./travelinsform.component.css']
})
export class TravelinsformComponent implements OnInit {

  travelInsurance : TravelInsurance = {duration: 0, region: '', numberOfPeople: 0, ages: '', sport: '', ammount: 0}
  section1 : Boolean = true;

  regions : String[];
  all_ages : String[];
  sports : String[];
  insuranceValues : String[];

  price1 : number=0;

  section2 : Boolean = false;
  arr : number[] = []; 
  people : Person[] = [];
  constructor(private insuranceService : TravelInsuranceService) { }

  ngOnInit() {
    this.getTravelRegions();
    this.getAges();
    this.getSports();
    this.getInsuranceValues();
  }

  getTravelRegions():void{
    this.insuranceService.getTravelRegions().subscribe(data => this.regions = data,
      err => {
        console.log(err);
      });
  }

  getAges():void {
    this.insuranceService.getAges().subscribe(data => this.all_ages = data,
      err => {
        console.log(err);
      });
  }

  getSports():void {
    this.insuranceService.getSports().subscribe(data => this.sports = data,
      err => {
        console.log(err);
      });
  }

  getInsuranceValues():void{
    this.insuranceService.getInsuranceValues().subscribe(data => this.insuranceValues = data,
      err => {
        console.log(err);
      });
  }

  onSubmit() {
    this.insuranceService.createInsurance(this.travelInsurance).subscribe(
      value => {
        console.log('[POST] create Insurance successfully', value);
        this.price1 = value;
        this.section1 = false;
        this.section2 = true;
        for(var i=0; i<this.travelInsurance.numberOfPeople; i++){
          this.arr.push(0);
          this.people.push({firstName:"", lastName:"", jmbg:0, passportNumber:0, address:'', telNum:'', email:''});
        }
      }, error => {
        console.log('FAIL to create Insurance!' + error);
      },
      () => {
        console.log('POST Insurance - now completed.');
      });
  }

 
}
