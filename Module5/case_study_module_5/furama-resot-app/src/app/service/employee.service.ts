import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";
import {Employee} from "../modle/employee";
import {Positions} from '../modle/positions';
import {Division} from "../modle/division";
import {Education} from "../modle/education";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private API_URL = ' http://localhost:3000/employee';
  private API_URL_DIVISION = ' http://localhost:3000/division';
  private API_URL_POSITION = ' http://localhost:3000/position';
  private API_URL_EDUCATION = ' http://localhost:3000/education';


  constructor(
    private httpClient: HttpClient) {
  }
  getAllDivision(): Observable<Division[]> {
    return this.httpClient.get<Division[]>(this.API_URL_DIVISION);
  }
  getAllPosition(): Observable<Positions[]> {
    return this.httpClient.get<Positions[]>(this.API_URL_POSITION);
  }
  getAllEducation(): Observable<Education[]> {
    return this.httpClient.get<Education[]>(this.API_URL_EDUCATION);
  }

  getAllEmployee(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(this.API_URL);
  }
  findEmployeeById(id: number): Observable<Employee>{
    return this.httpClient.get<Employee>(this.API_URL + '/' + id);
  }

  saveEmployee(employee: Employee): Observable<Employee> {
    return this.httpClient.post<Employee>(this.API_URL, employee);
  }
  updateCustomer(id: number, employee: Employee): Observable<Employee> {
    return this.httpClient.put<Employee>(this.API_URL + '/' + id, employee);
  }
  deleteCustomer(id: number): Observable<Employee> {
    return this.httpClient.delete<Employee>(this.API_URL + '/' + id);
  }
}
