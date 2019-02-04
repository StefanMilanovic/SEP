import { Component, OnInit } from '@angular/core';
import {PlacanjeService} from '../../service/placanje.service';
import {PodaciKriptovaluta} from '../../model';
<<<<<<< HEAD
import { ActivatedRoute } from '@angular/router';
=======
import {ActivatedRoute} from "@angular/router";
>>>>>>> 74c44a91f07912384687d39376a958e7ef255baf

@Component({
  selector: 'app-kriptovaluta',
  templateUrl: './kriptovaluta.component.html',
  styleUrls: ['./kriptovaluta.component.css']
})
export class KriptovalutaComponent implements OnInit {
  podaciKriptovaluta: PodaciKriptovaluta;
  data: any;
  
  constructor(private placanjeService: PlacanjeService, private activatedRoute: ActivatedRoute) {
    this.podaciKriptovaluta = new PodaciKriptovaluta();
    this.podaciKriptovaluta.kolicina = '12';
    this.podaciKriptovaluta.naziv = "test";

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
