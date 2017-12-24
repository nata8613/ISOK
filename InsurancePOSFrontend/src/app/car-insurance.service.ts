import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Rx';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {CarInsurance} from './carInsurance.interface';

@Injectable()
export class CarInsuranceService {

  private baseUrl = 'http://localhost:8080';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) { }

  getKilometers():  Observable<String[]> {
    return this.http.get(this.baseUrl + '/carInsurance/getKilometers/')
    .map((response:Response) => {return response})
      .catch((error:any) => Observable.throw(error || 'Server error'));
  }

  getPrices():  Observable<String[]> {
    return this.http.get(this.baseUrl + '/carInsurance/getPrices/')
    .map((response:Response) => {return response})
      .catch((error:any) => Observable.throw(error || 'Server error'));
  }

  getHotelDays():  Observable<String[]> {
    return this.http.get(this.baseUrl + '/carInsurance/getHotelDays/')
    .map((response:Response) => {return response})
      .catch((error:any) => Observable.throw(error || 'Server error'));
  }

  getAltVehicle():  Observable<String[]> {
    return this.http.get(this.baseUrl + '/carInsurance/getAltVehicle/')
    .map((response:Response) => {return response})
      .catch((error:any) => Observable.throw(error || 'Server error'));
  }

  createInsurance(carInsurance: CarInsurance) : Observable<number> {
    return this.http.post(this.baseUrl + '/carInsurance/createCarInsurance/', carInsurance, {headers: this.headers})
    .map((response:Response) => {return response})
    .catch((error:any) => Observable.throw(error || 'Server error'));
  }
}