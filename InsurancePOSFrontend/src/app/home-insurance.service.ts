import { Injectable } from '@angular/core';
import { Headers,Response, Http } from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {RiskItem} from './riskItem.interface';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { HomeInsurance } from './homeInsurance.interface';

@Injectable()
export class HomeInsuranceService {
  private baseUrl = 'http://localhost:8090';
  private headers =  new Headers({'Content-Type': 'application/json'});

    constructor(private http: Http) {}
  
    getHomeSurfaces():  Observable<RiskItem[]> {
      return this.http.get(this.baseUrl + '/homeInsurance/getHomeSurfaces/')
      .map((response:Response) => {return response.json()})
        .catch((error:any) => Observable.throw(error || 'Server error'));
    }

    getHomeAges():  Observable<RiskItem[]> {
      return this.http.get(this.baseUrl + '/homeInsurance/getHomeAges/')
      .map((response:Response) => {return response.json()})
        .catch((error:any) => Observable.throw(error || 'Server error'));
    }
  
    getHomeValues():  Observable<RiskItem[]> {
      return this.http.get(this.baseUrl + '/homeInsurance/getHomeValues/')
      .map((response:Response) => {return response.json()})
        .catch((error:any) => Observable.throw(error || 'Server error'));
    }

    getInsuranceReasons():  Observable<RiskItem[]> {
      return this.http.get(this.baseUrl + '/homeInsurance/getInsuranceReasons/')
      .map((response:Response) => {return response.json()})
        .catch((error:any) => Observable.throw(error || 'Server error'));
    }

    createInsurance(homeInsurance: HomeInsurance) : Observable<number> {
      return this.http.post(this.baseUrl + '/homeInsurance/createHomeInsurance/', homeInsurance, {headers: this.headers})
      .map((response:Response) => {return response.json()})
      .catch((error:any) => Observable.throw(error || 'Server error'));
    }
}
