import { Component } from '@angular/core';

import { AuthService } from './login/services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Portal Z';

  constructor(public authService: AuthService) {}

  logout() {
    this.authService.logout();
  }
}