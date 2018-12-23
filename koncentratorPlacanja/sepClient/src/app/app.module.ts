import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OpcijePlacanjaComponent } from './components/opcije-placanja/opcije-placanja.component'
import { NgxPayPalModule } from 'ngx-paypal';
import { KriptovalutaComponent } from './components/kriptovaluta/kriptovaluta.component'

@NgModule({
  declarations: [
    AppComponent,
    OpcijePlacanjaComponent,
    KriptovalutaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxPayPalModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
