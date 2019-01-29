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
  constructor(private placanjeService: PlacanjeService) {
    this.podaciKriptovaluta = new PodaciKriptovaluta();
    this.podaciKriptovaluta.kolicina = '12';
    this.podaciKriptovaluta.naziv = "test";

  }

  ngOnInit() {


  //   this.placanjeService.obradaKriptovalute(this.podaciKriptovaluta)
  //     .subscribe(
  //       (response: any) => {
  //
  //         window.location.href = response;
  //
  //       },
  //       (error) => console.log(error) );
  // }

  this.placanjeService.obradaKriptovalute()
.subscribe(
(response: any) => {

  window.location.href = response;

},
(error) => console.log(error) );
}


}
