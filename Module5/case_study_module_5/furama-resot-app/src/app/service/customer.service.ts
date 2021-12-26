import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../modle/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private API_URL = ' http://localhost:3000/customer';


  constructor(
    private httpClient: HttpClient) {
  }

  getAllCustomer(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_URL);
  }

  // set customers(value: Customer[]) {
  //   this.customers = value;
  // }
  findCustomerById(id: number): Observable<Customer>{
    return this.httpClient.get<Customer>(this.API_URL + '/' + id);
  }

  saveCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient.post<Customer>(this.API_URL, customer);
  }
  updateCustomer(id: number, customer: Customer): Observable<Customer> {
    return this.httpClient.put<Customer>(this.API_URL + '/' + id, customer);
  }
  deleteCustomer(id: number): Observable<Customer> {
    return this.httpClient.delete<Customer>(this.API_URL + '/' + id);
  }


}
