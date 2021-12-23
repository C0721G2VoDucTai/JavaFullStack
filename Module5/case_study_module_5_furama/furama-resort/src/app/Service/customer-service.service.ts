import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  private REST_API_SERVER = ' http://localhost:3000';
  private httpOptions = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor(private httpClient: HttpClient) { }
  public getCustomer(): Observable<any>{
    const url = `${this.REST_API_SERVER}`;
    // @ts-ignore
    return this.httpClient.get<any>(url, this.httpOptions);
  }
}
