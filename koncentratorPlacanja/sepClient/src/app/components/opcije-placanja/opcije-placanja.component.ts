import { Component, OnInit } from '@angular/core';
import { PayPalConfig, PayPalEnvironment, PayPalIntegrationType } from 'ngx-paypal';
import { Router } from '@angular/router';

@Component({
  selector: 'app-opcije-placanja',
  templateUrl: './opcije-placanja.component.html',
  styleUrls: ['./opcije-placanja.component.css']
})
export class OpcijePlacanjaComponent implements OnInit {
  
 
  constructor(private router: Router) { }

  ngOnInit() {
   
  }

  
}
