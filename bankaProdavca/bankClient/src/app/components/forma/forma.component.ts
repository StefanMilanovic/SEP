import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-forma',
  templateUrl: './forma.component.html',
  styleUrls: ['./forma.component.css']
})
export class FormaComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  ponisti(){
    console.log("aaaa")
    window.location.href = 'http://localhost:4200/';
  }
}