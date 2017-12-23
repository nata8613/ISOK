import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {FormsModule} from '@angular/forms';

import {Person} from '../person.interface';
import { PeopleService } from '../people.service';

@Component({
  selector: 'app-people',
  templateUrl: './people.component.html',
  styleUrls: ['./people.component.css']
})
export class PeopleComponent implements OnInit {

  @Input() arrayOfPeople : number[];
  @Input() people : Person[];
  @Input() price1 : number;

  @Output() priceEvent = new EventEmitter<number>();

  section3 : Boolean = true;
  section4 : Boolean = false;
  constructor( private peopleService: PeopleService) {  }

  ngOnInit() {
  }

  receivePrice($event) {
    this.price1 = $event
    this.priceEvent.emit(this.price1);
  }
  onSubmitPeople() {
    this.peopleService.sendPeopleData(this.people).subscribe(
      value => {
        console.log('[POST] create Insurance successfully', value);
        this.section3 = false;
        this.section4 = true;
        this.priceEvent.emit(this.price1);
      }, error => {
        console.log('FAIL to create Insurance!' + error);
      },
      () => {
        console.log('POST Insurance - now completed.');
      });
  }
}
