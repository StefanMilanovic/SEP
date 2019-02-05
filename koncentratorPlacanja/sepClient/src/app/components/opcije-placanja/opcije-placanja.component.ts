import { Component, OnInit } from '@angular/core';
import { PayPalConfig, PayPalEnvironment, PayPalIntegrationType } from 'ngx-paypal';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { PlacanjeService } from 'src/app/service/placanje.service';

@Component({
  selector: 'app-opcije-placanja',
  templateUrl: './opcije-placanja.component.html',
  styleUrls: ['./opcije-placanja.component.css']
})
export class OpcijePlacanjaComponent implements OnInit {
  private id:string
  private payPalEnabled: boolean;
  private bitcoinEnabled: boolean;
  private bankEnabled: boolean;

  constructor(private router: Router, private activatedRoute:ActivatedRoute, private placanjeService: PlacanjeService) { }

  ngOnInit() {
    this.id = this.activatedRoute.snapshot.params['id'];  

    this.placanjeService.getOpcijePlacanja(this.id).subscribe((data:any) => {
      this.payPalEnabled = data.paypalEnabled;
      this.bitcoinEnabled = data.bitcoinEnabled;
      this.bankEnabled = data.bankEnabled;      
    });
  }

}
