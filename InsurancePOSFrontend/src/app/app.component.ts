import { User } from './shared/user.model';
import { KeycloakService } from './shared/keycloak.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  
   profile: User;

    constructor(private keycloakService: KeycloakService ) {}

    public ngOnInit(): void {
        this.profile = this.keycloakService.getUser();
    }
}
