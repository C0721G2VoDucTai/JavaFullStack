import {Component, Inject, OnInit} from '@angular/core';
import {Medical} from '../../model/medical';
import {Subscription} from 'rxjs';
import {MedicalService} from '../../service/medical.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  id: number;
  medical: Medical;
  private subscription: Subscription;

  constructor(
    private medicalService: MedicalService,
    public dialogRef: MatDialogRef<DeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    console.log(this.data.customerData.id);
    this.medical = this.data.customerData;
  }

  deleteMedical() {
    this.subscription = this.medicalService.deleteMedical(this.medical.id).subscribe(data => {
      this.dialogRef.close();
    });
  }

}
