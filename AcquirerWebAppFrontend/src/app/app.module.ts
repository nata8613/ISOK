import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule }    from '@angular/http';

import { AppComponent } from './app.component';
import { PaymentFormComponent } from './payment-form/payment-form.component';
import {PaymentService} from './payment.service';

import {PANDirective} from './validators/panValidator.directive';
import {CustomDateStartDirective} from './validators/dateStartValidator.directive';
import {CustomMinDirective} from './validators/minValidator.directive';

const appRoutes: Routes = [
  {
    path: 'Payment/:paymentId',
    component: PaymentFormComponent
  },
  {
    path: '',
    component: PaymentFormComponent,
    data: {title: 'Home'}
  }
];


@NgModule({
  declarations: [
    AppComponent,
    PaymentFormComponent,
    PANDirective,
    CustomDateStartDirective,
    CustomMinDirective
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    HttpModule,
  ],
  providers: [PaymentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
