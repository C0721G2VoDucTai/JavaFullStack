import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {EmployeeListComponent} from './employee/employee-list/employee-list.component';
import {EmployeeCreateComponent} from './employee/employee-create/employee-create.component';
import {EmployeeEditComponent} from './employee/employee-edit/employee-edit.component';
import {EmployeeDeleteComponent} from './employee/employee-delete/employee-delete.component';
import {EmployeeDetailComponent} from './employee/employee-detail/employee-detail.component';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {CustomerModule} from './customer/customer.module';
import {SharedModule} from './shared/shared.module';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeCreateComponent,
    EmployeeEditComponent,
    EmployeeDeleteComponent,
    EmployeeDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CustomerModule,
    SharedModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {

}
