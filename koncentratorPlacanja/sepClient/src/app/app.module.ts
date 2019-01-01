import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing } from './app.routing';
import { Router } from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OpcijePlacanjaComponent } from './components/opcije-placanja/opcije-placanja.component'
import { NgxPayPalModule } from 'ngx-paypal';
import { KriptovalutaComponent } from './components/kriptovaluta/kriptovaluta.component';
import { PorukaUspesnostiComponent } from './components/poruka-uspesnosti/poruka-uspesnosti.component';
import {PlacanjeService} from './service/placanje.service';
import { BankaComponent } from './components/banka/banka.component';
import { PaypalComponent } from './components/paypal/paypal.component';
import { RegisterComponent } from './components/register/register.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';


@NgModule({
  declarations: [
    AppComponent,
    OpcijePlacanjaComponent,

    KriptovalutaComponent,
    PorukaUspesnostiComponent,

    KriptovalutaComponent,
    PorukaUspesnostiComponent, BankaComponent, PaypalComponent, RegisterComponent, HomepageComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxPayPalModule,
    HttpClientModule,
    routing,
    AngularFontAwesomeModule
  ],
  providers: [PlacanjeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
