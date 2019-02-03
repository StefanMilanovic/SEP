import { Component, OnInit } from '@angular/core';
import {PlacanjeService} from '../../service/placanje.service';
import {PodaciKriptovaluta} from '../../model';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-kriptovaluta',
  templateUrl: './kriptovaluta.component.html',
  styleUrls: ['./kriptovaluta.component.css']
})
export class KriptovalutaComponent implements OnInit {
  podaciKriptovaluta: PodaciKriptovaluta;
  data: any;
  id: any;
  constructor(private placanjeService: PlacanjeService, private activatedRoute:ActivatedRoute) {
    this.id = this.activatedRoute.snapshot.params['id'];
    console.log('Saljem transakciju sa id : ' + this.id);
  }

  ngOnInit() {

/*
    this.placanjeService.obradaKriptovalute(this.podaciKriptovaluta)

      .subscribe(
        (response: any) => {

          window.location.href = response.payment_url;

        },
        (error) =>
          console.log(error) );
*/

    this.placanjeService.obradaKriptovalute(this.id).subscribe((response:any)=>{


      console.log("Salje banci sledece::::");
      console.log(response);
      window.location.href = response.payment_url;

    });

  }


//   this.placanjeService.obradaKriptovalute2().subscribe((response:any) => {
//   console.log(response);
//   window.location.href = response;
//
// },
// (error) => console.log(error) );
// }


}
