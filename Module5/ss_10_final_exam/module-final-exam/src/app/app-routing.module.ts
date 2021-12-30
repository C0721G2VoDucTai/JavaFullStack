import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CreateComponent} from './Box/create/create.component';
import {ListComponent} from './Box/list/list.component';
import {EditComponent} from './Box/edit/edit.component';


const routes: Routes = [
  {path: 'medical', component: ListComponent},
  {path: 'medical/edit/:id', component: EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
