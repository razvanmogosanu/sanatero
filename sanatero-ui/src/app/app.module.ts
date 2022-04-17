import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HttpClientModule } from "@angular/common/http";
import { MedicalAssistanceComponent } from './components/medical-assistance/medical-assistance.component';
import {EditorModule} from 'primeng/editor'
import {BsDropdownModule} from "ngx-bootstrap/dropdown";
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {BsDatepickerConfig, BsDatepickerModule} from "ngx-bootstrap/datepicker";
import {AlertConfig, AlertModule} from "ngx-bootstrap/alert";
import {CollapseModule} from "ngx-bootstrap/collapse";
import {CarouselModule} from "ngx-bootstrap/carousel";
import {ButtonsModule} from "ngx-bootstrap/buttons";
import {AccordionModule} from "ngx-bootstrap/accordion";
import { StatisticsComponent } from './components/statistics/statistics.component';

const appRoutes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'services',
    component: MedicalAssistanceComponent
  },
  {
    path: 'statistics',
    component: StatisticsComponent
  },

];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    MedicalAssistanceComponent,
    StatisticsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    AccordionModule,
    AlertModule,
    ButtonsModule,
    CarouselModule,
    CollapseModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    EditorModule,
    BsDropdownModule.forRoot(),
    BsDropdownModule,
    BsDatepickerModule,
    BsDatepickerModule.forRoot(),
  ],
  providers: [AlertConfig, BsDatepickerConfig],
  bootstrap: [AppComponent]
})
export class AppModule { }
