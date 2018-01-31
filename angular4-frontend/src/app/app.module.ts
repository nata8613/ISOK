import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule }    from '@angular/http';
import { FormsModule } from '@angular/forms';

import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';



import { HomeInsuranceService } from './home-insurance.service';

import { HomeinsformComponent } from './homeinsform/homeinsform.component';
import { MainStepComponent } from './main-step/main-step.component';
import { UserDataStepComponent } from './user-data-step/user-data-step.component';
import { AdditionalStepComponent } from './additional-step/additional-step.component';
import { CheckoutStepComponent } from './checkout-step/checkout-step.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UsermodalComponent } from './usermodal/usermodal.component';

import { BootstrapModalModule } from 'ng2-bootstrap-modal';
import { ModelDataService } from './data/model.service';
import { DataService } from './data/data.service';

const appRoutes: Routes = [
    
    {
    path: 'MainStep',
    component: MainStepComponent,
    data: { title: 'Main step' }
    },
   {
    path: 'UserDataStep',
    component: UserDataStepComponent,
    data: { title: 'User data step' }
    },
   {
    path: 'AdditionalStep',
    component: AdditionalStepComponent,
    data: { title: 'Additional step' }
    },
   {
    path: 'CheckoutStep',
    component: CheckoutStepComponent,
    data: { title: 'Checkout step' }
  },
  {
    path: '',
    redirectTo: '/MainStep',pathMatch: 'full'
    }
];

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    HomeinsformComponent,
    MainStepComponent,
    UserDataStepComponent,
    AdditionalStepComponent,
    CheckoutStepComponent,
    NavbarComponent,
    UsermodalComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    HttpModule,
    FormsModule,
    HttpClientModule,
    BootstrapModalModule
  ],
   entryComponents: [
        UsermodalComponent
      ],
  providers: [ HomeInsuranceService, ModelDataService,DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
