import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerService} from '../../service/customer.service';
import {MatDialog} from '@angular/material/dialog';
import {Subscription} from 'rxjs';
import {EmployeeService} from '../../service/employee.service';
import {Employee} from '../../modle/employee';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  private subscription: Subscription;
  public employees: Employee[];
  term: string;
  p: number;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private employeeService: EmployeeService,
    public dialog: MatDialog
  ) {
  }

  ngOnInit(): void {
    this.subscription = this.employeeService.getAllEmployee().subscribe(data => {
        this.employees = data;
        console.log(this.employees);
      }
      , error => {
        console.log(this.employees);
      });
  }

  openDialog(id: any) {
  }
}
