import { Injectable } from '@angular/core';

import {InsuranceType } from "./InsuranceType";
import {HomeAge } from "./HomeAge";
import {HomeSurface } from "./HomeSurface";
import {HomeValue } from "./HomeValue";

import { Headers,Response, Http } from '@angular/http';

import {Observable} from 'rxjs/Rx';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class HomeInsuranceService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: Http) {}

  getAllInsuranceTypes():  Observable<InsuranceType[]> {
    return this.http.get(this.baseUrl + '/homeInsurance/getAllInsuranceTypes/')
	  .map((response:Response) => {return response.json()})
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  getAllHomeAges():  Observable<HomeAge[]> {
    return this.http.get(this.baseUrl + '/homeInsurance/getAllHomeAges/')
	  .map((response:Response) => {return response.json()})
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  getAllHomeSurfaces():  Observable<HomeSurface[]> {
    return this.http.get(this.baseUrl + '/homeInsurance/getAllHomeSurfaces/')
	  .map((response:Response) => {return response.json()})
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  getAllHomeValues():  Observable<HomeValue[]> {
    return this.http.get(this.baseUrl + '/homeInsurance/getAllHomeValues/')
	  .map((response:Response) => {return response.json()})
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

}
