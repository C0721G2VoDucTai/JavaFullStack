import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CustomerType} from '../modle/customer-type';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  private API_URL = ' http://localhost:3000/customer_type';


  constructor(
    private httpClient: HttpClient) {
  }

  getAllCustomerType(): Observable<CustomerType[]> {
    return this.httpClient.get<CustomerType[]>(this.API_URL);
  }
}
