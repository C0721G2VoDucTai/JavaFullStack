import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Subscription} from 'rxjs';
import {CustomerType} from '../../modle/customer-type';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CustomerTypeService} from '../../service/customer-type.service';
import {CustomerService} from '../../service/customer.service';
import {Customer} from '../../modle/customer';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customerEditForm = new FormGroup({
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
  id: number;
  subscription: Subscription;
  customerTypes: CustomerType[];
  customer: Customer;

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private customerTypeService: CustomerTypeService,
              private customerService: CustomerService,
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
    console.log('Alo');
    this.subscription = this.customerTypeService.getAllCustomerType().subscribe(data => {
        this.customerTypes = data;
        console.log(this.customerTypes);
      }
      , error => {
      });
  }

  onSubmit() {
    console.log(this.customerEditForm.value);
    console.log(this.customerEditForm.value.customer_type);
    if (this.customerEditForm.valid) {
      this.customerTypes.forEach(value => {
        console.log(value);
        if (this.customerEditForm.value.customer_type == value.id) {
          this.customerEditForm.value.customer_type = value;
        }
      });
      if (this.customerEditForm.valid) {
        this.subscription = this.customerService.updateCustomer(this.id, this.customerEditForm.value).subscribe(data => {
            console.log(this.customerEditForm.value);
            alert('Edit customer successfully');
            // @ts-ignore
            this.router.navigate(['/customer']);
          }
          , error => {
            console.log('Not found');
          });
      }
    }
  }

  get name() {
    return this.customerEditForm.get('name');
  }

  get customer_type() {
    return this.customerEditForm.get('customer_type');
  }

  get gender() {
    return this.customerEditForm.get('gender');
  }

  get birthday() {
    return this.customerEditForm.get('birthday');
  }

  get id_card() {
    return this.customerEditForm.get('id_card');
  }

  get phone() {
    return this.customerEditForm.get('phone');
  }

  get address() {
    return this.customerEditForm.get('address');
  }

  get email() {
    return this.customerEditForm.get('email');
  }

}
