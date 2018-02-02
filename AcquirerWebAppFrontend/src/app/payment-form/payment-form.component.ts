import { Component, OnInit } from '@angular/core';
import { DataAcqToPcc } from '../dataAcqToPcc';
import { NgForm } from '@angular/forms';
import {PaymentService} from '../payment.service';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-payment-form',
  templateUrl: './payment-form.component.html',
  styleUrls: ['./payment-form.component.css']
})
export class PaymentFormComponent implements OnInit {
  
  paymentId: number=0;
  formData: DataAcqToPcc = {acquirerOrderId: '', acquirerTimestamp: new Date(), pan:'',
    secuityCode: 0, cardHolderName:'', validDate:null, amount:0} 
  
  constructor(private route: ActivatedRoute, private paymentService : PaymentService)  {
    this.route.params.subscribe( params => this.paymentId = +params['paymentId']);
  }
  ngOnInit() {
  }

  onSubmit(form:NgForm) {
    if(form.invalid)
      return;
    this.paymentService.sendPayment(this.formData, this.paymentId).subscribe(
      value => {
        console.log('[POST] create Insurance successfully', value);
            }, error => {
        console.log('FAIL to create Insurance!' + error);
      },
      () => {
        console.log('POST Insurance - now completed.');
      });
  }

}
