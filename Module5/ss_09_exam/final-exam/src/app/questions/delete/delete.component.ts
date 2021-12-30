import {Component, Inject, OnInit} from '@angular/core';
import {Questions} from '../../model/questions';
import {Subscription} from 'rxjs';
import {QuestionsService} from '../../service/questions.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  id: number;
  question: Questions;
  private subscription: Subscription;

  constructor(
    private questionsService: QuestionsService,
    public dialogRef: MatDialogRef<DeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {
  }

  onNoClick(): void {

    this.dialogRef.close();
  }

  ngOnInit(): void {
    console.log(this.data.customerData.id);
    this.question = this.data.customerData;
  }

  deleteCustomer() {
    this.subscription = this.questionsService.deleteQ(this.question.id).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
