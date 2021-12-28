import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {MatDialogModule} from '@angular/material/dialog';
import { QuestionListComponent } from './question/question-list/question-list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CreateComponent } from './question/create/create.component';
import {HttpClientModule} from '@angular/common/http';
import { DeleteComponent } from './question/delete/delete.component';

@NgModule({
  declarations: [
    AppComponent,
    QuestionListComponent,
    CreateComponent,
    DeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    Ng2SearchPipeModule,
    MatDialogModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
