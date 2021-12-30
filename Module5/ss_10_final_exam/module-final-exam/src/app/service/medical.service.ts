import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Patient} from '../model/patient';
import {Medical} from '../model/medical';


@Injectable({
  providedIn: 'root'
})
export class MedicalService {
  private API_URL = ' http://localhost:3000/medical';
  private API_URL_TYPE = ' http://localhost:3000/patient';

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getAllPatient(): Observable<Patient[]> {
    return this.httpClient.get<Patient[]>(this.API_URL_TYPE);
  }

  getAll(): Observable<Medical[]> {
    return this.httpClient.get<Medical[]>(this.API_URL);
  }

  findById(id: number): Observable<Medical> {
    return this.httpClient.get<Medical>(this.API_URL + '/' + id);
  }

  updateMedical(id: number, medical: Medical): Observable<Medical> {
    return this.httpClient.put<Medical>(this.API_URL + '/' + id, medical);
  }

  deleteMedical(id: number): Observable<Medical> {
    return this.httpClient.delete<Medical>(this.API_URL + '/' + id);
  }
}
