import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-provera',
  templateUrl: './provera.component.html',
  styleUrls: ['./provera.component.css']
})
export class ProveraComponent implements OnInit {

  constructor() { }

  ngOnInit() {
      console.log(localStorage.getItem('1'));
  }

}
