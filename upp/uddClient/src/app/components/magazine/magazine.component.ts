import { Component, OnInit } from '@angular/core';
import { MagazineService } from 'src/app/services/magazine.service';

@Component({
  selector: 'app-magazine',
  templateUrl: './magazine.component.html',
  styleUrls: ['./magazine.component.css']
})
export class MagazineComponent implements OnInit {

  private magazines: any[];

  constructor(private magazineService: MagazineService) { }

  ngOnInit() {
    this.magazineService.getAllMagazines().subscribe((data: any) => {
      this.magazines = data;
      console.log(data);
    })
  }

}
