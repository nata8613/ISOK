import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RiskRoutingModule } from './risk-routing.module';
import { RiskComponent } from './risk.component';
import { RiskListComponent } from './risk-list/risk-list.component';
import { RiskCreateComponent } from './risk-create/risk-create.component';

@NgModule({
  imports: [
    CommonModule,
    RiskRoutingModule
  ],
  declarations: [RiskComponent, RiskListComponent, RiskCreateComponent]
})
export class RiskModule { }
