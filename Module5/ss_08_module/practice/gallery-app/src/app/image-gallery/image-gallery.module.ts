import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImageGalleryComponent } from './image-gallery.component';
import { ImageCardComponent } from './image-card/image-card.component';
import {AppRoutingModule} from '../app-routing.module';



@NgModule({
  declarations: [ImageGalleryComponent, ImageCardComponent],
  imports: [
    CommonModule,
  ]
})
export class ImageGalleryModule { }
