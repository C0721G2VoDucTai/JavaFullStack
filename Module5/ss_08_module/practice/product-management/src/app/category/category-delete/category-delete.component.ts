import { Component, OnInit } from '@angular/core';
import {CategoryService} from "../../service/category.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../../model/product";
import {Category} from "../../model/category";

@Component({
  selector: 'app-category-delete',
  templateUrl: './category-delete.component.html',
  styleUrls: ['./category-delete.component.css']
})
export class CategoryDeleteComponent implements OnInit {

  id: number;
  category: Category;

  constructor(private categoryService: CategoryService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.category = this.getCategory(this.id);

    });
  }

  private getCategory(id: number) {
    return this.categoryService.findById(id);
  }
  deleteCategory(id: number) {
    this.categoryService.deleteCategory(id);
    this.router.navigate(['/category/list']);
  }

  ngOnInit(): void {
  }
}
