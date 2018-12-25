import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-provera',
  templateUrl: './provera.component.html',
  styleUrls: ['./provera.component.css']
})
export class ProveraComponent implements OnInit {
  private id:string
  constructor(private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
      this.id = this.activatedRoute.snapshot.params['id'];
      console.log("Id transakcije je ::::: " + this.id)
  }

}
