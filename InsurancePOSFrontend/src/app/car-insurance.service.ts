import { Injectable } from '@angular/core';
import { Headers,Response, Http } from '@angular/http';
import {Observable} from 'rxjs/Rx';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {CarInsurance} from './carInsurance.interface';
import {RiskItem} from './riskItem.interface';
import {Policy} from './policy.interface';

@Injectable()
export class CarInsuranceService {

  private baseUrl = 'http://localhost:8090';
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) { }

  getKilometers():  Observable<RiskItem[]> {
    return this.http.get(this.baseUrl + '/carInsurance/getKilometers/')
    .map((response:Response) => {return response.json()})
      .catch((error:any) => Observable.throw(error || 'Server error'));
  }

  getPrices():  Observable<RiskItem[]> {
    return this.http.get(this.baseUrl + '/carInsurance/getPrices/')
    .map((response:Response) => {return response.json()})
      .catch((error:any) => Observable.throw(error || 'Server error'));
  }

  getHotelDays():  Observable<RiskItem[]> {
    return this.http.get(this.baseUrl + '/carInsurance/getHotelDays/')
    .map((response:Response) => {return response.json()})
      .catch((error:any) => Observable.throw(error || 'Server error'));
  }

  getAltVehicle():  Observable<RiskItem[]> {
    return this.http.get(this.baseUrl + '/carInsurance/getAltVehicle/')
    .map((response:Response) => {return response.json()})
      .catch((error:any) => Observable.throw(error || 'Server error'));
  }

  createInsurance(carInsurance: CarInsurance) : Observable<number> {
    return this.http.post(this.baseUrl + '/carInsurance/createCarInsurance/', carInsurance, {headers: this.headers})
    .map((response:Response) => {return response.json()})
    .catch((error:any) => Observable.throw(error || 'Server error'));
  }

  sendPolicy(policy: Policy): Observable<Response> {
    return this.http.post(this.baseUrl + '/policy/savePolicy/', policy, {headers: this.headers})
    .map((response:Response) => {console.log("Redirecting")})
    .catch((error:any) => Observable.throw(error || 'Server error'));
  }
}
