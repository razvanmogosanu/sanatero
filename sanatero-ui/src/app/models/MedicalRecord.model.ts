import {MedicalAssistance} from "./MedicalAssistance.model";
import {User} from "./User.model";

export class MedicalRecord {
  id?: number;
  date?: Date;
  medicalAssistance?: MedicalAssistance;
  patient?: User;
  caregiver?: User;


  constructor(date: Date, medicalAssistance: MedicalAssistance, patient: User, caregiver: User) {
    this.date = date;
    this.medicalAssistance = medicalAssistance;
    this.patient = patient;
    this.caregiver = caregiver;
  }
}
