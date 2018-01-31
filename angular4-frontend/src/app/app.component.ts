import { Component ,OnInit, Input } from '@angular/core';
import { ModelDataService } from './data/model.service';
import { UserDataModel } from './data/model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit {
  title = 'app';
  @Input() mainData;
  @Input() vehicleData;
  @Input() homeData;
  @Input() userData;
  constructor(private modelDataService: ModelDataService){}
  
  ngOnInit() {
        this.mainData = this.modelDataService.getMainData();
        this.vehicleData = this.modelDataService.getVehicleData();
        this.homeData = this.modelDataService.getHomeData();
        this.userData = this.modelDataService.getUserData();
        console.log(this.title + ' loaded!');
    }
}
