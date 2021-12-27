import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListWordComponent } from './list-word/list-word.component';
import { DetailWordComponent } from './detail-word/detail-word.component';

@NgModule({
  declarations: [
    AppComponent,
    ListWordComponent,
    DetailWordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
