import { Component, OnInit } from '@angular/core';
import {PlacanjeService} from '../../service/placanje.service';
import {PodaciKriptovaluta} from '../../model';

@Component({
  selector: 'app-kriptovaluta',
  templateUrl: './kriptovaluta.component.html',
  styleUrls: ['./kriptovaluta.component.css']
})
export class KriptovalutaComponent implements OnInit {
  podaciKriptovaluta: PodaciKriptovaluta;
  data: any;
  constructor(private placanjeService: PlacanjeService) {
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

    this.placanjeService.obradaKriptovalute(this.podaciKriptovaluta).subscribe(data=>{
      console.log("Salje banci sledece::::");
      console.log(data);
      window.location.href = data.payment_url;

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
