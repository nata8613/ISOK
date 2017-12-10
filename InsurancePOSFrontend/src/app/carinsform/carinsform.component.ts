import { Component, OnInit, Input, Output} from '@angular/core';
import {CarInsuranceService} from '../car-insurance.service';

import {CarInsurance} from '../carInsurance.interface';

@Component({
  selector: 'app-carinsform',
  templateUrl: './carinsform.component.html',
  styleUrls: ['./carinsform.component.css']
})
export class CarinsformComponent implements OnInit {

  @Input() price1 : number;
  section7 : Boolean = true;
  carInsurance : CarInsurance;

  numberOfKms : String[];
  repairPrices : String[];
  numbersOfHotelDays : String[];
  alternativeVehicles : String[];

  constructor(private carService : CarInsuranceService) { }

  ngOnInit() {
    this.getNumberOfKms();
    this.getNumbersOfHotelDays();
    this.getRepairPrices();
    this.getVehicles();
    this.carInsurance = {insuranceLength:0, numberOfKm:'', repairPrice:'', numberOfHotelDays:'', 
    alternativeVehicle:'', typeOfVehicle:'', yearOfProduction:0, regTable:'', chassisNumber:'', 
    firstName:'', lastName:'', jmbg:0};
  }

  getNumberOfKms():void{
    this.carService.getKilometers().subscribe(data => this.numberOfKms = data,
      err => {
        console.log(err);
      });
  }

  getRepairPrices():void{
    this.carService.getPrices().subscribe(data => this.repairPrices = data,
      err => {
        console.log(err);
      });
  }

  getNumbersOfHotelDays():void{
    this.carService.getHotelDays().subscribe(data => this.numbersOfHotelDays = data,
      err => {
        console.log(err);
      });
  }

  getVehicles():void{
    this.carService.getAltVehicle().subscribe(data => this.alternativeVehicles = data,
      err => {
        console.log(err);
      });
  }

  onSubmit() {
    this.carService.createInsurance(this.carInsurance).subscribe(
      value => {
        console.log('[POST] create Car Insurance successfully', value);
        this.price1 = value + this.price1;
        this.section7 = false;
      }, error => {
        console.log('FAIL to create Insurance!' + error);
      },
      () => {
        console.log('POST Insurance - now completed.');
      });
  }
}
