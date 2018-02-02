import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule }    from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { UpdateComponent } from './update/update.component';
import { DiscountComponent } from './discount/discount.component';
import { PricelistComponent } from './pricelist/pricelist.component';

const appRoutes: Routes = [
  {
     path: '',
     component: AppComponent
  },
  {
     path: 'discount',
     component: DiscountComponent
  }
]; 
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    UpdateComponent,
    DiscountComponent,
    PricelistComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
