import { Injectable } from '@angular/core';
import {User } from "./User";
import { Headers,Response, Http } from '@angular/http';

import {Observable} from 'rxjs/Rx';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class UserserviceService {

 private baseUrl = 'http://localhost:8080';

  constructor(private http: Http) { }

  getUsers():  Observable<User[]> {
    return this.http.get(this.baseUrl + '/users/getAll/')
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }


}
