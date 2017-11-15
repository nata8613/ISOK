import { Injectable } from '@angular/core';

import {InsuranceType } from "./InsuranceType";
import {HomeAge } from "./HomeAge";
import {HomeSurface } from "./HomeSurface";
import {HomeValue } from "./HomeValue";

import {HomeInsuranceView} from "./HomeInsuranceView";

import { Headers,Response, Http } from '@angular/http';

import {Observable} from 'rxjs/Rx';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class HomeInsuranceService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: Http) {}

  getHomeInsuranceView():  Observable<HomeInsuranceView[]> {
    return this.http.get(this.baseUrl + '/homeInsurance/getHomeInsuranceData/')
    .map((response:Response) => {return response.json()})
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

}
