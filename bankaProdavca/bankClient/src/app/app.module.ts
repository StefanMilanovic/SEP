import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing } from './app.routing'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormaComponent } from './components/forma/forma.component';
import { ProveraComponent } from './components/provera/provera.component';

@NgModule({
  declarations: [
    AppComponent,
    FormaComponent,
    ProveraComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
