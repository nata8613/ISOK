import { Injectable } from '@angular/core';

import {InsuranceType } from "./InsuranceType";
import {HomeAge } from "./HomeAge";
import {HomeSurface } from "./HomeSurface";
import {HomeValue } from "./HomeValue";

import {HomeInsuranceView} from "./HomeInsuranceView";
import { PaymentModel } from './data/model';

import { Headers,Response, Http, RequestOptions } from '@angular/http';

import {Observable} from 'rxjs/Rx';
import { ExchangeModel } from './data/exchangemodel';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class HomeInsuranceService {

  private baseUrl = 'http://localhost:8090';

  constructor(private http: Http) {}

  getHomeInsuranceView():  Observable<HomeInsuranceView[]> {
    return this.http.get(this.baseUrl + '/homeInsurance/getHomeInsuranceData/')
    .map((response:Response) => {return response.json()})
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

    getMainStepView():  Observable<HomeInsuranceView[]> {
    return this.http.get(this.baseUrl + '/travelInsurance/getTravelInsuranceData/')
    .map((response:Response) => {return response.json()})
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

    getCarInsuranceView():  Observable<HomeInsuranceView[]> {
    return this.http.get(this.baseUrl + '/carInsurance/getCarInsuranceData/')
    .map((response:Response) => {return response.json()})
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  postDataToServer(exchangeModel : ExchangeModel) : Observable<ExchangeModel> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
     return this.http.post(this.baseUrl + '/travelInsurance/saveData/', exchangeModel, options)
               .map((response:Response) => {return response.json()})
               .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }




}
