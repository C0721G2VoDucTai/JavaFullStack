import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoryRoutingModule } from './category-routing.module';
import { CategoryListComponent } from './category-list/category-list.component';
import { CategoryCreateComponent } from './category-create/category-create.component';
import {ReactiveFormsModule} from "@angular/forms";
import { CategoryUpdateComponent } from './category-update/category-update.component';
import { CategoryDeleteComponent } from './category-delete/category-delete.component';


@NgModule({
  declarations: [CategoryListComponent,CategoryCreateComponent,CategoryUpdateComponent, CategoryDeleteComponent],
  imports: [
    CommonModule,
    CategoryRoutingModule,
    ReactiveFormsModule
  ]
})
export class CategoryModule { }
