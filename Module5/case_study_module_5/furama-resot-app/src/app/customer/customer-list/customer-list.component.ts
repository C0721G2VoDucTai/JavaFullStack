import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {Subscription} from 'rxjs';
import {Customer} from '../../modle/customer';
import {MatDialog} from '@angular/material/dialog';
import {CustomerDeleteComponent} from '../customer-delete/customer-delete.component';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

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
  sForm: FormGroup;
  showBack;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private customerService: CustomerService,
    public dialog: MatDialog,
    private fb: FormBuilder
  ) {
  }

  ngOnInit(): void {
    // if (this.sForm.value.sName === '' && this.sForm.value.sName === '') {
    this.showBack = 'False';
    this.subscription = this.customerService.getAllCustomer().subscribe(data => {
        this.customers = data;
        console.log(this.customers[2].customer_type.name);
      }
      , error => {
        console.log(this.customers);
      });
    // }
    this.sForm = this.fb.group({
      sName: [''],
      sAddress: [''],
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
  onSearchSubmit() {
    const name = this.sForm.value.sName;
    const address = this.sForm.value.sAddress;
    if (name && address === '') {
      this.subscription = this.customerService.searchName(name).subscribe(data => {
          this.customers = data;
          this.showBack = 'True';
        }
        , error => {
        });
    } else if (name === '' && address) {
      this.subscription = this.customerService.searchAddress(address).subscribe(data => {
          this.customers = data;
          this.showBack = 'True';
        }
        , error => {
        });
    } else if (name && address) {
      this.subscription = this.customerService.searchNameAddress(name, address).subscribe(data => {
          this.customers = data;
          this.showBack = 'True';
        }
        , error => {
        });
    } else {
      this.ngOnInit();
    }

  }

  Back() {
    this.ngOnInit();
  }
}
