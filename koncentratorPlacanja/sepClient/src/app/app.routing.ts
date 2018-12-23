import { NgModule } from '@angular/core';
import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { OpcijePlacanjaComponent } from './components/opcije-placanja/opcije-placanja.component';
import { PorukaUspesnostiComponent } from './components/poruka-uspesnosti/poruka-uspesnosti.component';
import {KriptovalutaComponent} from './components/kriptovaluta/kriptovaluta.component';

const appRoutes: Routes =
    [
        {
            path: '', component: OpcijePlacanjaComponent,
        },
        { path: 'uspesno', component: PorukaUspesnostiComponent },
        {
          path: 'kriptovaluta', component: KriptovalutaComponent
        }
    ];
    export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);

