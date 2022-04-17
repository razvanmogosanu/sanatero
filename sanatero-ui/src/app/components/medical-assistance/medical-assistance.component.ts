import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {MedicalAssistance} from "../../models/MedicalAssistance.model";
import {ApiService} from "../../services/ApiService";
import {User} from "../../models/User.model";
import {MedicalRecord} from "../../models/MedicalRecord.model";
import {CookieService} from "ngx-cookie-service";

@Component({
  selector: 'app-medical-assistance',
  templateUrl: './medical-assistance.component.html',
  styleUrls: ['./medical-assistance.component.css']
})
export class MedicalAssistanceComponent implements OnInit {
  medicalAssistance: MedicalAssistance[] = [];

  @ViewChild('doctorDropdown', {static: false})
  chosenDoctor : ElementRef | undefined;

  @ViewChild('datepicker', {static: false})
  chosenDate : ElementRef | undefined;

  doctors: User[] = [];

  constructor(private apiService: ApiService, private cookieService: CookieService) { }

  ngOnInit(): void {
    this.apiService.getAllMedicalAssistance().subscribe(
      data => {
        this.medicalAssistance = data;
      }
    );

    this.apiService.getAllDoctors().subscribe(
      data => {
        this.doctors = data;
      }
    );
  }


  onDateChange(newDate: Date) {
    console.log(newDate);
  }

  programeaza(medicalAssistance: any) {
    console.log('CUCKO', this.chosenDoctor)
    const obj = new MedicalRecord(this.chosenDate?.nativeElement.value,
                                  medicalAssistance,
                                  new User(this.cookieService.get('username')),
                                  new User(this.chosenDoctor?.nativeElement.value));

    this.apiService.addToMedicalRecord(obj).subscribe();
  }
}
