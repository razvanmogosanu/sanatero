import {HttpClient} from '@angular/common/http';
import {CookieService} from 'ngx-cookie-service';
import {Router} from '@angular/router';
import {Injectable, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {MedicalRecord} from "../models/MedicalRecord.model";


@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private BASE_URL = 'http://localhost:8080';
  private LOGIN_USER_URL = `${this.BASE_URL}/user/login`;
  private BIGGEST_EXPENSES_USER_URL = `${this.BASE_URL}/user/user_with_biggest_expenses`;
  private GET_ALL_ASSISTANCE_USER_URL = `${this.BASE_URL}/assistance`;
  private GET_ALL_DOCTORS_USER_URL = `${this.BASE_URL}/user/get_all_doctors`;
  private ADD_TO_MEDICAL_RECORD_URL = `${this.BASE_URL}/medical_record/add`;


  constructor(private http: HttpClient, private cookies: CookieService, private router: Router) {
  }


  authUser(usernameParam: string, passwordParam: string): Observable<any> {
    const body = {
      username: usernameParam,
      password: passwordParam
    };
    return this.http.get(this.LOGIN_USER_URL, { headers: body});
  }

  getAllMedicalAssistance(): Observable<any> {
    return this.http.get(this.GET_ALL_ASSISTANCE_USER_URL);
  }

  getUserWithBiggestExpenses(): Observable<any> {
    return this.http.get(this.BIGGEST_EXPENSES_USER_URL);
  }

  getAllDoctors(): Observable<any> {
    return this.http.get(this.GET_ALL_DOCTORS_USER_URL);
  }

  addToMedicalRecord(medicalRecord: MedicalRecord) {
    return this.http.post(this.ADD_TO_MEDICAL_RECORD_URL, medicalRecord);
  }
}
