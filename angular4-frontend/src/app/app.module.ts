import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule }    from '@angular/http';

import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { AboutComponent } from './about/about.component';
import { HeroComponent } from './hero/hero.component';
import { FeatureComponent } from './feature/feature.component';
import { ParallaxComponent } from './parallax/parallax.component';
import { ContactComponent } from './contact/contact.component';
import { HomeinsuranceComponent } from './homeinsurance/homeinsurance.component';

import { UserserviceService } from './userservice.service';
import { MainComponent } from './main/main.component';
import { HomeinsformComponent } from './homeinsform/homeinsform.component';

const appRoutes: Routes = [
  {
    path: 'HomeInsurance',
    component: HomeinsuranceComponent,
    data: { title: 'Home Insurance' }
  },
   {
    path: '',
    component: MainComponent,
    data: { title: 'Main ISOK Insurance' }
  }
];

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    AboutComponent,
    HeroComponent,
    FeatureComponent,
    ParallaxComponent,
    ContactComponent,
    HomeinsuranceComponent,
    MainComponent,
    HomeinsformComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    HttpModule
  ],
  providers: [UserserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
