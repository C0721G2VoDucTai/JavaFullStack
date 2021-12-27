import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {Subscription} from 'rxjs';
import {Customer} from '../../modle/customer';
import {MatDialog} from '@angular/material/dialog';
import {CustomerDeleteComponent} from '../customer-delete/customer-delete.component';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  private subscription: Subscription;
  customer: Customer | undefined;
  customers: Customer[] | undefined;
  term: any;
  p: any;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private customerService: CustomerService,
    public dialog: MatDialog
  ) {
  }

  ngOnInit()
    :
    void {
    this.subscription = this.customerService.getAllCustomer().subscribe(data => {
        this.customers = data;
        console.log(this.customers[2].customer_type.name);
      }
      , error => {
        console.log(this.customers);
      });
  }

// Mở dialog nhận id và trả về đối tượng customer
  openDialog(id): void {
    console.log(id);
    // Trả về đối tượng customer
    this.customerService.findCustomerById(id).subscribe(customerData => {
      console.log(customerData);
      const dialogRef = this.dialog.open(CustomerDeleteComponent, {
        width: '500px',
        data: {customerData},
        // Khi bấm ra ngoài dialog khong bi mat di
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

  // deleteCustomerModal(id) {
  //   this.customerService.deleteCustomer(id).subscribe(data => {
  //     this.ngOnInit();
  //   });
  // }
}
