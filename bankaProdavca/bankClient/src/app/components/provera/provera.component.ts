import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProveraSericeService } from 'src/app/services/provera-serice.service';

@Component({
  selector: 'app-provera',
  templateUrl: './provera.component.html',
  styleUrls: ['./provera.component.css']
})
export class ProveraComponent implements OnInit {
  private id:string;
  private data:any;
  constructor(private activatedRoute:ActivatedRoute, private proveraService:ProveraSericeService) { }

  ngOnInit() {
      this.id = this.activatedRoute.snapshot.params['id'];
      console.log("Id transakcije je ::::: " + this.id)
      this.proveraService.proveriPodatke(this.id).subscribe(data =>{
        this.data=data;
        console.log("PODACI O UPLATI:::::" + this.data.id);

        setTimeout(() => {
          window.location.href = "http://localhost:5000/paymentForm/" + this.data.id;
        }, 3000);  //5s        
      });
  }

}
