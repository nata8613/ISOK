import { Component, OnInit } from '@angular/core';
import { DataAcqToPcc } from '../dataAcqToPcc';
import { NgForm } from '@angular/forms';
import {PaymentService} from '../payment.service';

@Component({
  selector: 'app-payment-form',
  templateUrl: './payment-form.component.html',
  styleUrls: ['./payment-form.component.css']
})
export class PaymentFormComponent implements OnInit {
  
  formData: DataAcqToPcc = {acquirerOrderId: '', acquirerTimestamp: new Date(), pan:'',
    secuityCode: 0, cardHolderName:'', validDate:null, amount:0} 
  
  constructor(private paymentService : PaymentService) { }

  ngOnInit() {
  }

  onSubmit(form:NgForm) {
    if(form.invalid)
      return;
      console.log(this.formData.acquirerOrderId);
      console.log(this.formData.pan);
    this.paymentService.sendPayment(this.formData).subscribe(
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
