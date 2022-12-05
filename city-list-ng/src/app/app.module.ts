import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CityModule } from './modules/city/city.module';
import { BrowserModule } from '@angular/platform-browser';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CityModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
