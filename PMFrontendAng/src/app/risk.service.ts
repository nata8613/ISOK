import { Injectable } from '@angular/core';
import {InsuranceCategory} from "./insuranceCategory";

import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import { Observable } from "rxjs/Observable";

@Injectable()
export class RiskService {

  private apiUrl = 'http://localhost:8888/update/getCategories';
  constructor(private http: Http) { }

  
  findAll(): Observable<InsuranceCategory[]>  {
    return this.http.get(this.apiUrl)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }
 
  findById(id: number): Observable<InsuranceCategory> {
    return null;
  }
 
  saveUser(user: InsuranceCategory): Observable<InsuranceCategory> {
    return null;
  }
 
  deleteUserById(id: number): Observable<boolean> {
    return null;
  }
 
  updateUser(user: InsuranceCategory): Observable<InsuranceCategory> {
    return null;
  }

}
