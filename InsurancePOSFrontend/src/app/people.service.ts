import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Rx';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { TravelinsformComponent } from './travelinsform/travelinsform.component';
import {Person} from './person.interface';

@Injectable()
export class PeopleService {
  private baseUrl = 'http://localhost:8080';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor( private httpClient: HttpClient) { }

  sendPeopleData(people: Person[]) : Observable<Person[]> {
    console.log('length: ', people.length);
    console.log('name', people[1].firstName);
    return this.httpClient.post(this.baseUrl + '/persons/peopleInfo/', people, {headers: this.headers})
    .map((response:Response) => {return response})
    .catch((error:any) => Observable.throw(error || 'Server error'));
  }
}
