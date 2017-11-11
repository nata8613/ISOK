import { Component, OnInit } from '@angular/core';

declare let paypal: any;

@Component({
  selector: 'app-homeinsform',
  templateUrl: './homeinsform.component.html',
  styleUrls: ['./homeinsform.component.css']
})
export class HomeinsformComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  ngAfterViewInit(): void {
   
      paypal.Button.render({
        env: 'sandbox',
        


        client: {
          production: 'EGwY_-5zByiyP8Km2cTU4Wf70CHlwZr9AJqF9BIwLBf-xyDcMg6tbVGBPLo-NZTlP4pcgVBCCrDIdi1k',
          sandbox: 'AQSA9iBWQSdWQWVGyusPw70GcuVoB91i-nVZCSCuW2QpFJa7-HWUT2ABimq3PMCnqOsOLIH1zREZEnl4'
        },
        commit: true,
        payment: function (data, actions) {
          return actions.payment.create({
            payment: {
              transactions: [
                {
                  amount: { total: '1.00', currency: 'USD' }
                }
              ]
            }
          })
        },
        onAuthorize: function(data, actions) {
          return actions.payment.execute().then(function(payment) {
            // TODO
          })
        }
      }, '#paypal-button');
   
  }

}
