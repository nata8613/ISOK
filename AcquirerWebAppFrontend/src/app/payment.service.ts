import { Injectable } from '@angular/core';
import { Headers,Response, Http } from '@angular/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import {DataAcqToPcc} from './dataAcqToPcc';
@Injectable()
export class PaymentService {
  private baseUrl = 'http://localhost:8883';
  private headers = new Headers({'Content-Type': 'application/json'})
  constructor(private http: Http) { }

  sendPayment(data: DataAcqToPcc): Observable<DataAcqToPcc> {
    var paymentId = Math.random()*10000000000 +1;
    var orderId =  Math.random()*10000000000 + 1;
    var timeStamp = new Date();
    var newData = Object.assign({}, data, {
      acquirerOrderId: orderId,
      acquirerTimestamp: timeStamp
    })
    return this.http.post(this.baseUrl + '/getData/'+paymentId, newData, {headers: this.headers})
    .map((response:Response) => {console.log(response.json()); return response.json()})
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }
}
