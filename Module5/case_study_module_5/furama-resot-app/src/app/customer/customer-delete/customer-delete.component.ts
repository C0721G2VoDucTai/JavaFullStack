import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Customer} from '../../modle/customer';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {
  id: number;
  customer: Customer;
  private subscription: Subscription;

  constructor(private customerService: CustomerService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
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

  deleteCustomer(id: number) {
    this.subscription = this.customerService.deleteCustomer(this.id).subscribe(data => {
      alert('Create customer successfully');
      // @ts-ignore
      this.router.navigate(['/customer']);
    });
  }
}
