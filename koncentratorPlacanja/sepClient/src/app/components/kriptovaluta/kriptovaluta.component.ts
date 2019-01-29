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


<<<<<<< HEAD
  //   this.placanjeService.obradaKriptovalute(this.podaciKriptovaluta)
  //     .subscribe(
  //       (response: any) => {
  //
  //         window.location.href = response;
  //
  //       },
  //       (error) => console.log(error) );
  // }

this.placanjeService.obradaKriptovalute2().subscribe((response: any) => {

  window.location.href = response;

},
(error) => console.log(error) );
}
=======
    this.placanjeService.obradaKriptovalute(this.podaciKriptovaluta)

      .subscribe(
        (response: any) => {

          window.location.href = response;

        },
        (error) => console.log(error) );
  }

//   this.placanjeService.obradaKriptovalute2().subscribe((response:any) => {
//   console.log(response);
//   window.location.href = response;
//
// },
// (error) => console.log(error) );
// }
>>>>>>> 39da2840d065c9051f7a713ff80be6c44d21b431


}
