import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Subscription} from 'rxjs';
import {Router} from '@angular/router';
import {CustomerType} from '../../modle/customer-type';
import {CustomerTypeService} from '../../service/customer-type.service';
import {CustomerService} from '../../service/customer.service';
import {Customer} from '../../modle/customer';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customerForm = new FormGroup({
    name: new FormControl('', [Validators.required]),
    customer_type: new FormControl(),
    birthday: new FormControl('', [Validators.required]),
    gender: new FormControl('', [Validators.required]),
    id_card: new FormControl('', [Validators.required, Validators.pattern('^\\d{9}|\\d{12}$')]),
    phone: new FormControl('', [Validators.required,
      Validators.pattern('^(09|\\(84\\)\\+9)[01]\\d{7}$')]),
    email: new FormControl('', [Validators.required,
      Validators.pattern('^[a-zA-Z0-9_!#$%&\'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-z]{2,6}$')]),
    address: new FormControl('', [Validators.required])
  });
  subscription: Subscription;
  customerTypes: CustomerType[];
  customer: Customer;

  constructor(private router: Router,
              private customerTypeService: CustomerTypeService,
              private customerService: CustomerService,
  ) {
  }

  ngOnInit(): void {
    console.log('Alo');
    this.subscription = this.customerTypeService.getAllCustomerType().subscribe(data => {
        this.customerTypes = data;
        console.log(this.customerTypes);
      }
      , error => {
      });
  }

  onSubmit() {
    console.log(this.customerForm.value.customer_type);
    if (this.customerForm.valid) {
      // this.customerTypes.forEach(value => {
      //   console.log(value);
      //   if (this.customerForm.value.customer_type == value.id) {
      //     this.customerForm.value.customer_type = value;
      //   }
      // });
      console.log(this.customerForm.value);
      this.subscription = this.customerService.saveCustomer(this.customerForm.value).subscribe(data => {
          // console.log(this.customer);
          alert('Create customer successfully');
          this.router.navigate(['/customer']);
        }
        , error => {
          console.log('Not found');
        });
    }
  }

  get name() {
    return this.customerForm.get('name');
  }

  get customer_type() {
    return this.customerForm.get('customer_type');
  }

  get gender() {
    return this.customerForm.get('gender');
  }

  get birthday() {
    return this.customerForm.get('birthday');
  }

  get id_card() {
    return this.customerForm.get('id_card');
  }

  get phone() {
    return this.customerForm.get('phone');
  }

  get address() {
    return this.customerForm.get('address');
  }

  get email() {
    return this.customerForm.get('email');
  }
}
