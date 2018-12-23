import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing } from './app.routing';
import { Router } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OpcijePlacanjaComponent } from './components/opcije-placanja/opcije-placanja.component'
import { NgxPayPalModule } from 'ngx-paypal';
import { KriptovalutaComponent } from './components/kriptovaluta/kriptovaluta.component';
import { PorukaUspesnostiComponent } from './components/poruka-uspesnosti/poruka-uspesnosti.component';

@NgModule({
  declarations: [
    AppComponent,
    OpcijePlacanjaComponent,
    KriptovalutaComponent,    
    PorukaUspesnostiComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxPayPalModule,
    routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
