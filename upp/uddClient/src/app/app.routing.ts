import {ModuleWithProviders} from '@angular/core';
import { RouterModule, Routes } from "@angular/router";
import {HomepageComponent} from './components/homepage/homepage.component'
import {RegisterComponent} from './components/register/register.component';
import {LoginComponent} from './components/login/login.component';
import { UploadComponent } from './components/upload/upload.component';
const appRoutes: Routes =
    [
        { path: '', component: HomepageComponent},
        { path: 'register', component: RegisterComponent },
        { path: 'login', component: LoginComponent },   
        { path: 'upload', component: UploadComponent},
    ];
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);