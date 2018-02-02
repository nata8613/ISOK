import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RiskListComponent } from './risk-list/risk-list.component';
import { RiskCreateComponent } from './risk-create/risk-create.component';
 
const routes: Routes = [
  {path: 'risk', component: RiskListComponent},
  {path: 'risk/create', component: RiskCreateComponent},
  {path: 'risk/edit/:id', component: RiskCreateComponent}
];



@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RiskRoutingModule { }
