import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { FormsModule } from '@angular/forms';
import { HttpModule }    from '@angular/http';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { FeaturesComponent } from './features/features.component';
import { HeaderComponent } from './header/header.component';
import { MainComponent } from './main/main.component';
import { HomeinsformComponent } from './homeinsform/homeinsform.component';
import { TravelinsformComponent } from './travelinsform/travelinsform.component';

import {HomeInsuranceService} from './home-insurance.service';
import {TravelInsuranceService} from './travel-insurance.service';
import {CarInsuranceService} from './car-insurance.service';
import {PeopleService} from './people.service';
import { PeopleComponent } from './people/people.component';
import { CarinsformComponent } from './carinsform/carinsform.component';
import { CustomMinDirective } from './validators/minValidator.directive';
import {CustomDateStartDirective} from './validators/dateStartValidator.directive';
import {CustomDateEndDirective} from './validators/dateEndValidator.directive';

const appRoutes: Routes = [
  {
    path: 'HomeInsurance',
    component: HomeinsformComponent,
    data: { title: 'Home Insurance' }
  }, 
  {
    path: 'bla',
    component: MainComponent,
    data: { title: 'Main ISOK Insurance' }
  },
  {
    path: '',
    component: TravelinsformComponent,
    data: {title: 'Travel Insurance'}
  }
];

@NgModule({
  declarations: [
    AppComponent,
    FeaturesComponent,
    HeaderComponent,
    MainComponent,
    HomeinsformComponent,
    TravelinsformComponent,
    PeopleComponent,
    CarinsformComponent,
    CustomMinDirective,
    CustomDateStartDirective,
    CustomDateEndDirective
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    AngularFontAwesomeModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClientModule
  ],
  providers: [HomeInsuranceService, TravelInsuranceService, PeopleService, CarInsuranceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
