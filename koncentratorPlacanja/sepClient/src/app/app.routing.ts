import { NgModule } from '@angular/core';
import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { OpcijePlacanjaComponent } from './components/opcije-placanja/opcije-placanja.component';
import { PorukaUspesnostiComponent } from './components/poruka-uspesnosti/poruka-uspesnosti.component';
import { KriptovalutaComponent } from './components/kriptovaluta/kriptovaluta.component';
import { RegisterComponent } from './components/register/register.component';
import { HomepageComponent } from './components/homepage/homepage.component';

const appRoutes: Routes =
    [
        { path: '', component: HomepageComponent},

        { path: 'opcije/:id', component: OpcijePlacanjaComponent },
        { path: 'uspesno', component: PorukaUspesnostiComponent },
        { path: 'kriptovaluta', component: KriptovalutaComponent },
        { path: 'register', component: RegisterComponent }
    ];
    export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);

