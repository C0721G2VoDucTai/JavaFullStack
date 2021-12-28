import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {QuestionsService} from '../../service/questions.service';
import {MatDialog} from '@angular/material/dialog';
import {Questions} from '../../model/questions';
import {Subscription} from 'rxjs';
import {DeleteComponent} from '../delete/delete.component';
import {QuestionType} from '../../model/question-type';

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.css']
})
export class QuestionListComponent implements OnInit {
  questions: Questions[];
  private subscription: Subscription;
  p: number;
  term: any;
  showBack;
  sForm: FormGroup;
  public questionTypes: QuestionType[];

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              private questionsService: QuestionsService,
              public dialog: MatDialog,
              private fb: FormBuilder
  ) {
  }

  ngOnInit(): void {
    console.log('Abc');
    this.showBack = false;
    this.subscription = this.questionsService.getAllQuestionType().subscribe(data => {
        this.questionTypes = data;
        console.log(this.questionTypes);
      }
      , error => {
      });
    this.subscription = this.questionsService.getAll().subscribe(data => {
        this.questions = data;
        // console.log(this.questions[2].customer_type.name);
      }
      , error => {
        console.log(this.questions);
      });
    this.sForm = this.fb.group({
      title: [''],
      question_type: [''],
    });
  }

  openDialog(id: any) {
    console.log(id);
    // Trả về đối tượng customer
    this.questionsService.findById(id).subscribe(customerData => {
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

  onSearchSubmit() {
    const title = this.sForm.value.title;
    const questionId = this.sForm.value.question_type;
    console.log(questionId);
    console.log(title);
    if (title && !questionId) {
      console.log(questionId);
      console.log(title);
      this.subscription = this.questionsService.searchName(title).subscribe(data => {
          this.questions = data;
          this.showBack = 'True';
        }
        , error => {
        });
    } else if (title === '' && questionId.id) {
      this.subscription = this.questionsService.searchAddress(questionId.id).subscribe(data => {
          this.questions = data;
          this.showBack = 'True';
        }
        , error => {
        });
    } else if (title && questionId.id) {
      this.subscription = this.questionsService.searchNameAddress(title, questionId.id).subscribe(data => {
          this.questions = data;
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
