import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public API = ' http://localhost:3000/customer';
  private httpOptions = new HttpHeaders({
    'Content-Type': 'application/json'
  });


  constructor(
    private httpClient: HttpClient) { }
  public getAllCustomer(): Observable<any>{
    // const url = `${this.REST_API_SERVER}`;
    // // @ts-ignore
    return this.httpClient.get<any>(this.API);
  }


}