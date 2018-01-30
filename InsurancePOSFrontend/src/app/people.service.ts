import { Injectable } from '@angular/core';
import { Headers,Response, Http } from '@angular/http';
import {Observable} from 'rxjs/Rx';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { TravelinsformComponent } from './travelinsform/travelinsform.component';
import {Person} from './person.interface';

@Injectable()
export class PeopleService {
  private baseUrl = 'http://localhost:8090';
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor( private http: Http) { }

  sendPeopleData(people: Person[]) : Observable<Person[]> {
    return this.http.post(this.baseUrl + '/persons/peopleInfo/', people, {headers: this.headers})
    .map((response:Response) => {return response})
    .catch((error:any) => Observable.throw(error || 'Server error'));
  }
}
