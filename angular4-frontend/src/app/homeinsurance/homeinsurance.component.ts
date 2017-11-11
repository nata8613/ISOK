import { Component, OnInit } from '@angular/core';
import {UserserviceService} from "../userservice.service";
import {User} from "../User";

@Component({
  selector: 'app-homeinsurance',
  templateUrl: './homeinsurance.component.html',
  styleUrls: ['./homeinsurance.component.css']
})
export class HomeinsuranceComponent implements OnInit {
  users : User[];

  constructor(
	private userService : UserserviceService,
  	) { }

  ngOnInit() {
  	this.getAllUsers();
  }

  getAllUsers(): void {
  		console.log("poziv metode iz servisa - getUsers");
  	this.userService.getUsers().subscribe(users => this.users = users,
      err => {
        console.log(err);
      })
  	console.log(this.users);
  }

}
