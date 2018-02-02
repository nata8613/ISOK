import { Component, OnInit } from '@angular/core';
import { MainModel, PaymentModel, UserDataModel, VehicleModel, HomeModel } from '../data/model';
import { ExchangeModel } from '../data/exchangemodel';
import { ModelDataService } from '../data/model.service';

import { Router } from '@angular/router';

import {HomeInsuranceService} from "../home-insurance.service";

declare let paypal: any;


@Component({
  selector: 'app-checkout-step',
  templateUrl: './checkout-step.component.html',
  styleUrls: ['./checkout-step.component.css']
})


export class CheckoutStepComponent implements OnInit {
  title : string = "Here is a copy of the information you have entered:";




  mainmodel : MainModel;
  userDataModel : UserDataModel [];
  vehicleModel : VehicleModel;
  homeModel :HomeModel;
  paymentModel : PaymentModel ;
  paymentModelStatus : PaymentModel ;
  responseStatus : ExchangeModel;
  exchangeModel : ExchangeModel;

  constructor(private modelDataService : ModelDataService, 
    private homeInsuranceService : HomeInsuranceService,
    private router : Router) { 

}

  ngOnInit() {
  	 this.mainmodel = this.modelDataService.getMainData();
  	 this.userDataModel = this.modelDataService.getUserData();
  	 this.vehicleModel = this.modelDataService.getVehicleData();
  	 this.homeModel = this.modelDataService.getHomeData();	

  }

    ngAfterViewInit(): void {
    	var self = this;

      paypal.Button.render({
        env: 'sandbox',
        


        client: {
          production: 'ENIWfurOGHWFiXo9oI49RRuerS6U-yhplCDwYqdjQ8ofJVgqYP0HoE4frOv9jAp_Bp9Qna_KbXIlIenM',
          sandbox: 'Abs8kOJm295DLqdwbbUyoLCIjUGEUyLZ3nTTv9RO-lPZWeITx_oIZL4IsP9BgEwhyrlUXHCypLOiqBxv'
        },
        commit: true,
        payment: function (data, actions) {
          return actions.payment.create({
            payment: {
              transactions: [
                {
                  amount: { total: Number(self.mainmodel.totalPrice)+Number(self.vehicleModel.totalPrice)
                  	+ Number(self.homeModel.totalPrice), currency: 'EUR' }
                }
              ]
            }
          })
        },
        onAuthorize: function(data, actions) {

          return actions.payment.execute().then( () => {
     
            console.log("-----------------------------------------------------------");
            console.log(data);
            console.log(actions);
            console.log("-----------------------------------------------------------");

			self.exchangeModel = new ExchangeModel(self.modelDataService.getMainData(), self.modelDataService.getUserData(),
			             	self.modelDataService.getVehicleData(), self.modelDataService.getHomeData(),
			             	new PaymentModel(data.intent, data.orderID,data.payerID ,data.paymentID ,data.paymentToken ));

			  	self.homeInsuranceService.postDataToServer(self.exchangeModel).subscribe(data => self.responseStatus = data,
			           err => console.log(err),
			           () => console.log('Request Completed')
			        ); 
          });

        }
      }
      , '#paypal-button');
   
  }


}
