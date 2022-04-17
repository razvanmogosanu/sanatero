import { Component, OnInit } from '@angular/core';
import {CookieService} from "ngx-cookie-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private cookieService: CookieService, private router: Router) { }

  ngOnInit(): void {
  }

  isLogged() {
    const cookies = this.cookieService.get('logged');
    return !( !cookies || cookies == 'false');
  }

  logOut() {
    this.cookieService.deleteAll();
    this.router.navigateByUrl('login');
  }
}
