import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListWordComponent} from './list-word/list-word.component';
import {DetailWordComponent} from './detail-word/detail-word.component';


const routes: Routes = [
  {path: 'dictionary', component: ListWordComponent},
  {path: 'dictionary/:id', component: DetailWordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
