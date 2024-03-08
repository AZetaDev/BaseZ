import { Component } from '@angular/core';

import { AuthService } from './login/services/auth.service';
import { PrimeNGConfig } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'Portal Z';

  constructor(public authService: AuthService, private primengConfig: PrimeNGConfig) {}

  logout() {
    this.authService.logout();
  }

  ngOnInit() {
    this.primengConfig.ripple = true;
  }
}