import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { FormaComponent } from './components/forma/forma.component';
import { ProveraComponent } from './components/provera/provera.component';


const appRoutes: Routes =
[
    {path: '', component: FormaComponent},
    {path: 'provera/:id', component: ProveraComponent}
];
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes)
