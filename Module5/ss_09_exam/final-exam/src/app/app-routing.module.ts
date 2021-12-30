import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {QuestionListComponent} from './questions/question-list/question-list.component';
import {CreateComponent} from './questions/create/create.component';


const routes: Routes = [
  {path: 'question', component: QuestionListComponent},
  {path: 'questions/create', component: CreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
