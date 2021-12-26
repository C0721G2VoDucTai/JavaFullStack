import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {Subscription} from 'rxjs';
import {Customer} from '../../modle/customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  private subscription: Subscription;
  customer: Customer | undefined;
  customers: Customer[] | undefined;


  constructor(
    private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.subscription = this.customerService.getAllCustomer().subscribe(data => {
        this.customers = data;
        console.log(this.customers[2].customer_type.name);
      }
      , error => {
        console.log(this.customers);
      });
  }
}
