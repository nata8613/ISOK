import { Component, OnInit, OnDestroy,Input } from '@angular/core';
import {UsermodalComponent} from '../usermodal/usermodal.component';
import { MainModel, UserDataModel } from '../data/model';
import { ModelDataService } from '../data/model.service';

@Component({
	selector: 'app-user-data-step',
	templateUrl: './user-data-step.component.html',
	styleUrls: ['./user-data-step.component.css']
})
export class UserDataStepComponent implements OnInit{
	title = 'Please enter data about insurance users.';
	form: any;
	mainmodel : MainModel;
	numOfRows : number = 0;
	userDataModel : UserDataModel[];

	@Input() userData;

	constructor(private modelDataService : ModelDataService) {
	}



	ngOnInit(){
		this.mainmodel = this.modelDataService.getMainData();
		this.numOfRows = Number(this.mainmodel.numOfPersonsLess) + Number(this.mainmodel.numOfPersonsMore);
		this.modelDataService.addUserData(this.numOfRows);
		this.userDataModel = this.modelDataService.getUserData();
		this.userData = this.userDataModel;
	}


}
