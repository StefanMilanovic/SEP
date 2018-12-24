import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-banka',
  templateUrl: './banka.component.html',
  styleUrls: ['./banka.component.css']
})
export class BankaComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  setuj(){
    console.log("Setujem");
    localStorage.setItem('1','Ovo je setovana vrednost');
  }

}
