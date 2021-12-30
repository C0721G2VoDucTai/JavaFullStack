import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {QuestionType} from '../../model/question-type';
import {Questions} from '../../model/questions';
import {Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {QuestionsService} from '../../service/questions.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  form = new FormGroup({
    title: new FormControl('', [Validators.required, Validators.minLength(5)
        , Validators.maxLength(100)],
      []),
    question_type: new FormControl(''),
    ques: new FormControl('', [Validators.required, Validators.minLength(5),
      Validators.maxLength(500)]),
    answer: new FormControl(),
    date: new FormControl(),
    status: new FormControl(),
  });
  subscription: Subscription;
  questionTypes: QuestionType[];
  questions: Questions;

  constructor(private router: Router,
              private questionsService: QuestionsService,
  ) {
  }

  ngOnInit(): void {
    console.log('Alo');
    this.subscription = this.questionsService.getAllQuestionType().subscribe(data => {
        this.questionTypes = data;
        console.log(this.questionTypes);
      }
      , error => {
      });
  }

  onSubmit() {
    this.form.value.answer = '';
    this.form.value.status = 0;
    this.form.value.date = '2021-12-10';
    // if (this.form.valid) {
    this.subscription = this.questionsService.saveQ(this.form.value).subscribe(data => {
        console.log(this.questions);
        alert('Create questions successfully');
        this.router.navigate(['/questions']);
      }
      , error => {
        console.log('Not found');
      });
    // }
  }


  get title() {
    return this.form.get('title');
  }

  get question_type() {
    return this.form.get('question_type');
  }

  get ques() {
    return this.form.get('ques');
  }

  get answer() {
    return this.form.get('answer');
  }

  get date() {
    return this.form.get('date');
  }

  get status() {
    return this.form.get('status');
  }
}
