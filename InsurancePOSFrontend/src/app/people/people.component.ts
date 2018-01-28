import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {FormsModule} from '@angular/forms';

import {Person} from '../person.interface';
import { PeopleService } from '../people.service';
import {Policy} from '../policy.interface';
import { NgForm } from '@angular/forms/src/directives/ng_form';

@Component({
  selector: 'app-people',
  templateUrl: './people.component.html',
  styleUrls: ['./people.component.css']
})
export class PeopleComponent implements OnInit {

  @Input() price1 : number;
  @Input() policy : Policy;
  @Output() goBackEmitter = new EventEmitter();
  @Output() priceEvent = new EventEmitter<number>();

  section2 : Boolean = true;
  section3 : Boolean = false;
  section4 : Boolean = false;
  people: Person[] = [];
  currentClient: Person = {firstName:'', lastName:'', jmbg:0, passportNumber:0, address:'', telNum:'', email:'', index: this.people.length};
  constructor( private peopleService: PeopleService) {  }

  ngOnInit() {
    this.people = this.policy.people;
    this.currentClient = Object.assign({}, this.currentClient, {index: this.people.length})
  }

  receivePrice($event) {
    this.price1 = $event
    this.priceEvent.emit(this.price1);
  }
  continue() {
    this.peopleService.sendPeopleData(this.people).subscribe(
      value => {
        console.log('[POST] create Insurance successfully', value);
        this.section2 = false;
        this.section3 = false;
        this.section4 = true;
        this.priceEvent.emit(this.price1);
        this.policy = Object.assign({}, this.policy, {people: this.people});
      }, error => {
        console.log('FAIL to create Insurance!' + error);
      },
      () => {
        console.log('POST Insurance - now completed.');
      });
  }
  addClient(){
    this.section3 = true;
  }
  submitClient(clientForm: NgForm){
    if(clientForm.invalid)
      return;
    var index = this.currentClient.index;
    if(this.people.find(x => x.index == index) != undefined){
      var indexFound;
      this.people.some(function(person, ind) {
        if(person.index == index){
          indexFound = ind;
          return true;
        }
      });
      this.people.splice(indexFound,1);
      this.people.push(this.currentClient);
    }
    else
      this.people.push(this.currentClient);
    this.section3 = false;
    this.currentClient= {firstName:'', lastName:'', jmbg:0, passportNumber:0, address:'', telNum:'', email:'', index: this.people.length};
    this.policy = Object.assign({}, this.policy, {people: this.people});
  }
  editClient(index:number){
    this.section3 = true;
    var client: Person = this.people.find(x=> x.index == index);
    this.currentClient= {firstName:client.firstName, lastName:client.lastName, jmbg:client.jmbg, passportNumber:client.passportNumber, address:client.address, telNum:client.telNum, email:client.email, index: client.index};
  }
  deleteClient(index:number){
    var indexFound;
    this.people.some(function(person, ind) {
      if(person.index == index){
        indexFound = ind;
        return true;
      }
    });
    this.people.splice(indexFound,1);
  }
  showEvent(){
    this.section2=true;
    this.section4 = false;
  }

  goBack(){
    this.goBackEmitter.emit();
  }
}
