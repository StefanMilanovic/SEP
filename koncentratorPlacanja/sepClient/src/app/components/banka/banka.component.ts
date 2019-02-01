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
  private bankCode: string;
  private urlBank: string;

  constructor(private placanjeService: PlacanjeService, private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.id = this.activatedRoute.snapshot.params['id'];
    console.log("Id transakcije je(pisem iz banke) ::::: " + this.id)

  }

  placanjeBankom(){
    this. placanjeService.pripremiPodatkeZaBanku(this.id)
    .subscribe( data => {
      this.bankData = data;
      this.redirectLinkA =this.redirectLinkA.concat( this.bankData.token);

      this.bankCode = this.bankData.bankRacunProdavac.substring(1,6);
      console.log("Salje banci : "  + this.bankCode);

      // U odnosu na kod banke posalji sa kog sajta da vraca
        this.placanjeService.getUrlBank(this.bankCode).subscribe((data:any)=>{
          console.log( 'url :'+ data.urlBanke);
          this.urlBank = data.urlBanke;

          this.placanjeService.posaljiBanciPodatke(this.bankData,this.urlBank).subscribe(data=>{
            console.log("Salje banci A sledece::::");
            console.log(this.bankData);
            //PROMENI LINK LINK B!!! DOLE
            window.location.href = this.redirectLinkA;

          });
        });


    });
  }

}
