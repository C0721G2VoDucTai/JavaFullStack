import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CustomerService} from '../../service/customer.service';
import {Customer} from "../../modle/customer";

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {
  customer: Customer;
  id: number;

  constructor(private customerService: CustomerService,
              private activatedRoute: ActivatedRoute,
              private router: Router
  ) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      console.log(this.id);
      // @ts-ignore
      this.subscription = this.customerService.findCustomerById(this.id).subscribe(data => {
        this.customer = data;
        console.log(this.customer);
      });
    });
  }

}
