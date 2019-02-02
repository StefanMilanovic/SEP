import { Component, OnInit } from '@angular/core';
import { PlacanjeService } from 'src/app/service/placanje.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-banka',
  templateUrl: './banka.component.html',
  styleUrls: ['./banka.component.css']
})
export class BankaComponent implements OnInit {

  private id: string;
  private bankData: any;
  private redirectLinkA = 'http://localhost:5000/provera/';
  private redirectLinkB = 'http://localhost:5001/provera/'
  private bankCode: string;
  private urlBank: string;
  private token: string;

  constructor(private placanjeService: PlacanjeService, private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.id = this.activatedRoute.snapshot.params['id'];
    console.log("Id transakcije je(pisem iz banke) ::::: " + this.id)

  }

  placanjeBankom(){
    this. placanjeService.pripremiPodatkeZaBanku(this.id)
    .subscribe( data => {
      this.bankData = data;
      this.token = this.bankData.token;

      this.redirectLinkA = this.redirectLinkA.concat( this.bankData.token);
      this.redirectLinkB = this.redirectLinkB.concat(this.bankData.token);

      this.bankCode = this.bankData.bankRacunProdavac.substring(1,6);
      console.log("Salje banci : "  + this.bankCode);

      // U odnosu na kod banke posalji sa kog sajta da vraca
        this.placanjeService.getUrlBank(this.bankCode).subscribe((data:any)=>{
          console.log( 'url :'+ data.urlBanke);
          this.urlBank = data.urlBanke;

          this.placanjeService.posaljiBanciPodatke(this.bankData,this.urlBank).subscribe(data=>{
            console.log("Salje banci sledece::::");
            console.log(this.bankData);
            
            if(this.urlBank.includes('8182')) {
              window.location.href = this.redirectLinkA;
            }
            else{
              window.location.href = this.redirectLinkB;
            }

          });
        });


    });
  }

}
