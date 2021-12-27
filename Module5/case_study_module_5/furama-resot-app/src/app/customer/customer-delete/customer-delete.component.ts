import {Component, Inject, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Customer} from '../../modle/customer';
import {Subscription} from 'rxjs';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {
  id: number;
  customer: Customer;
  private subscription: Subscription;

  // constructor(private customerService: CustomerService,
  //             private activatedRoute: ActivatedRoute,
  //             private router: Router) {
  // }
  constructor(
    private customerService: CustomerService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    public dialogRef: MatDialogRef<CustomerDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {
  }

  onNoClick(): void {

    this.dialogRef.close();
  }

  ngOnInit(): void {
    console.log(this.data.customerData.id);
    this.customer = this.data.customerData;
    // this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
    //   this.id = +paramMap.get('id');
    //   console.log(this.id);
    //   // @ts-ignore
    //   this.subscription = this.customerService.findCustomerById(this.id).subscribe(data => {
    //     this.customer = data;
    //     console.log(this.customer);
    //   });
    // });
  }

  deleteCustomer() {
    this.subscription = this.customerService.deleteCustomer(this.customer.id).subscribe(data => {
      this.dialogRef.close();
      // this.router.navigate(['/customer']);
    });
  }
}
