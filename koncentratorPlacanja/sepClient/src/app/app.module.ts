//MODULES
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { routing } from './app.routing';
import { Router } from '@angular/router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import { NgxPayPalModule } from 'ngx-paypal';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import {NgxPageScrollModule} from 'ngx-page-scroll';

//COMPONENTS
import { AppComponent } from './app.component';
import { OpcijePlacanjaComponent } from './components/opcije-placanja/opcije-placanja.component'
import { KriptovalutaComponent } from './components/kriptovaluta/kriptovaluta.component';
import { PorukaUspesnostiComponent } from './components/poruka-uspesnosti/poruka-uspesnosti.component';
import { BankaComponent } from './components/banka/banka.component';
import { PaypalComponent } from './components/paypal/paypal.component';
import { RegisterComponent } from './components/register/register.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { LoginComponent } from './components/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';

//SERVICES
import { PlacanjeService } from './service/placanje.service';



@NgModule({
  declarations: [
    AppComponent,
    OpcijePlacanjaComponent,

    KriptovalutaComponent,
    PorukaUspesnostiComponent,

    KriptovalutaComponent,
    PorukaUspesnostiComponent, BankaComponent, PaypalComponent, RegisterComponent, HomepageComponent, LoginComponent, ProfileComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxPayPalModule,
    HttpClientModule,
    routing,
    AngularFontAwesomeModule,
    NgxPageScrollModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatSlideToggleModule
  ],
  providers: [PlacanjeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
