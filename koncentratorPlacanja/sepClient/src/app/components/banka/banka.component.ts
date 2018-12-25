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
  private redirectLink = 'http://localhost:5000/provera/1';

  constructor(private placanjeService: PlacanjeService, private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.id = this.activatedRoute.snapshot.params['id'];  
    //console.log("Id transakcije je(pisem iz banke) ::::: " + this.id)  
    
  }

  placanjeBankom(){
    this. placanjeService.pripremiPodatkeZaBanku(this.id)
    .subscribe( data => {
      this.bankData = data;
      console.log("ISPISUJEM PODATKE")
      console.log(this.bankData);
    });
  }

}
