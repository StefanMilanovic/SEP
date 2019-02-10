import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-paper',
  templateUrl: './paper.component.html',
  styleUrls: ['./paper.component.css']
})
export class PaperComponent implements OnInit {

  private paper: any;

  constructor() { }

  ngOnInit() {
    this.paper = JSON.parse(localStorage.getItem('paper'));
    console.log(this.paper);
  }

}
