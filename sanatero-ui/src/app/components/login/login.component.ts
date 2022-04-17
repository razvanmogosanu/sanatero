import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ApiService} from "../../services/ApiService";
import {Router} from "@angular/router";
import {CookieService} from "ngx-cookie-service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @ViewChild('usernameElement', {static: false})
  username: ElementRef | undefined;

  @ViewChild('passwordElement', {static: false})
  password: ElementRef | undefined;


  constructor(private apiService: ApiService, private router: Router, private cookieService: CookieService) { }

  ngOnInit(): void {
  }

  onSubmit() {

    this.apiService.authUser(this.username?.nativeElement.value, this.password?.nativeElement.value).subscribe(
      data => {
        if (data == true) {
          this.cookieService.set('logged', 'true');
          this.cookieService.set('username', this.username?.nativeElement.value);
          this.router.navigateByUrl('');
        } else {
          alert('Wrong credentials');
        }
      }
    );
  }
}
