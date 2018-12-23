import { Component, OnInit } from '@angular/core';
import {PlacanjeService} from '../../service/placanje.service';

@Component({
  selector: 'app-kriptovaluta',
  templateUrl: './kriptovaluta.component.html',
  styleUrls: ['./kriptovaluta.component.css']
})
export class KriptovalutaComponent implements OnInit {

  constructor(private placanjeService: PlacanjeService) { }

  ngOnInit() {


    this.placanjeService.obradaKriptovalute()
      .subscribe(
        (response: any) => {

          window.location.href = response;

        },
        (error) => console.log(error) );
  }
  

}
