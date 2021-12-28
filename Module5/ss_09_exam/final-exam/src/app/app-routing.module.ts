import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {QuestionListComponent} from './question/question-list/question-list.component';
import {CreateComponent} from './question/create/create.component';


const routes: Routes = [
  {path: 'question', component: QuestionListComponent},
  {path: 'question/create', component: CreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
