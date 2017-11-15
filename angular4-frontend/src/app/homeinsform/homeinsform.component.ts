import { Component, OnInit } from '@angular/core';
import {InsuranceType } from "../InsuranceType";
import {HomeAge } from "../HomeAge";
import {HomeSurface } from "../HomeSurface";
import {HomeValue } from "../HomeValue";
import {HomeInsuranceView } from "../HomeInsuranceView";
import {HomeInsuranceOption} from "../HomeInsuranceOption";

import {HomeInsuranceService} from "../home-insurance.service";

import { Headers,Response, Http } from '@angular/http';

import {Observable} from 'rxjs/Rx';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

declare let paypal: any;

@Component({
  selector: 'app-homeinsform',
  templateUrl: './homeinsform.component.html',
  styleUrls: ['./homeinsform.component.css']
})
export class HomeinsformComponent implements OnInit {

  homeInsuranceViews: HomeInsuranceView[];
  selectedOption:HomeInsuranceOption;
  insuranceTypes : InsuranceType[];
  homeAges : HomeAge[];
  homeSurfaces : HomeSurface[];
  homeValues : HomeValue[];
  selectedValue = "";
  priceSum : number;

  constructor(
  	private homeInsuranceService : HomeInsuranceService
  	) { }

  ngOnInit() {

    
    this.getHomeInsuranceView();
    this.priceSum = 19;
  }

  onChange(value) : void {
    console.log('Course Value',value);
  }

   getHomeInsuranceView(): void {
    this.homeInsuranceService.getHomeInsuranceView().subscribe(data => this.homeInsuranceViews = data,
      err => {
        console.log(err);
      });
    }

  ngAfterViewInit(): void {
   
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
                  amount: { total: '1.00', currency: 'EUR' }
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
