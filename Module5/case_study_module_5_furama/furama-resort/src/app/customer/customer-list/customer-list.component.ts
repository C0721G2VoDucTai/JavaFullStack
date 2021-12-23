import { Component, OnInit } from '@angular/core';
import {CustomerServiceService} from '../../Service/customer-service.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {

  constructor(private customerServiceService: CustomerServiceService) { }

  ngOnInit(): void {
    // @ts-ignore
    this.customerServiceService.getCustomer()._subscribe((data) =>{
      console.log('data', data);
    });
  }

}
