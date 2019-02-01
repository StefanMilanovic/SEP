import { NgModule } from '@angular/core';
import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { OpcijePlacanjaComponent } from './components/opcije-placanja/opcije-placanja.component';
import { PorukaUspesnostiComponent } from './components/poruka-uspesnosti/poruka-uspesnosti.component';
import { KriptovalutaComponent } from './components/kriptovaluta/kriptovaluta.component';
import { RegisterComponent } from './components/register/register.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { LoginComponent } from './components/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';

const appRoutes: Routes =
    [
        { path: '', component: HomepageComponent},

        { path: 'opcije/:id', component: OpcijePlacanjaComponent },
        { path: 'rezultat/:result/:token', component: PorukaUspesnostiComponent },
        { path: 'kriptovaluta', component: KriptovalutaComponent },
        { path: 'register', component: RegisterComponent },
        { path: 'login', component: LoginComponent },
        { path: 'profile', component: ProfileComponent },        
    ];
    export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);

