import { Component, OnInit } from '@angular/core';
import { PayPalConfig, PayPalEnvironment, PayPalIntegrationType } from 'ngx-paypal';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-opcije-placanja',
  templateUrl: './opcije-placanja.component.html',
  styleUrls: ['./opcije-placanja.component.css']
})
export class OpcijePlacanjaComponent implements OnInit {
  private id:string
  constructor(private router: Router, private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.id = this.activatedRoute.snapshot.params['id'];
    console.log('Saljem transakciju sa id : ' + this.id);

  }
}
