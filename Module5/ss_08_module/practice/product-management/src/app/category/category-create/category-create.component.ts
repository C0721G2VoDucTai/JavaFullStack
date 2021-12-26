import { Component, OnInit } from '@angular/core';
import {CategoryService} from "../../service/category.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent implements OnInit {
  categoryForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
  });

  constructor(private _categoryService: CategoryService,
              private _router: Router
  ) {
  }

  ngOnInit(): void {
  }

  submit() {
    const category = this.categoryForm.value;
    this._categoryService.saveCategory(category);
    this.categoryForm.reset();
    this._router.navigate(['/category/list']);

  }
}
