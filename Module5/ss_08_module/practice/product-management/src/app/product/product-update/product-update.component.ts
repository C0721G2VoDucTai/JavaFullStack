import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../../model/product";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  productForm: FormGroup
  id: number;
  product: Product;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router
  ) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
    console.log(this.id);
    const product = this.getProduct(this.id);
    this.productForm = new FormGroup({
      id: new FormControl(product.id),
      name: new FormControl(product.name),
      price: new FormControl(product.price),
      description: new FormControl(product.description),
    });
    });
  }
  getProduct(id: number) {
    return this.productService.getProductById(id);
  }
  updateProduct(id: number) {
    const product = this.productForm.value;
    this.productService.updateProduct(id, product)
    this.router.navigate(['/product/list']);
    alert("Update successfully")
  }
}
