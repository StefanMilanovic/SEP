import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-poruka-uspesnosti',
  templateUrl: './poruka-uspesnosti.component.html',
  styleUrls: ['./poruka-uspesnosti.component.css']
})
export class PorukaUspesnostiComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    setTimeout(() => {
      this.router.navigate(['']);
  }, 5000);
  }

}
