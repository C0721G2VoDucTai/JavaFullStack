import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MedicalService} from '../../service/medical.service';
import {MatDialog} from '@angular/material/dialog';
import {Subscription} from 'rxjs';
import {Medical} from '../../model/medical';
import {DeleteComponent} from '../delete/delete.component';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  p: number;
  term: any;
  medicals: Medical[];
  private subscription: Subscription;

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              private medicalService: MedicalService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.subscription = this.medicalService.getAll().subscribe(data => {
        this.medicals = data;
        // console.log(this.questions[2].customer_type.name);
      }
      , error => {
        console.log(this.medicals);
      });
  }

  openDialog(id: any) {
    console.log(id);
    // Trả về đối tượng
    this.medicalService.findById(id).subscribe(customerData => {
      console.log(customerData);
      const dialogRef = this.dialog.open(DeleteComponent, {
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
}
