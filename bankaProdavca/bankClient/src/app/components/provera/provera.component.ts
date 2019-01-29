import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProveraSericeService } from 'src/app/services/provera-serice.service';

@Component({
  selector: 'app-provera',
  templateUrl: './provera.component.html',
  styleUrls: ['./provera.component.css']
})
export class ProveraComponent implements OnInit {
  private token: string;
  private data: any;
  constructor(private activatedRoute: ActivatedRoute, private proveraService: ProveraSericeService) { }

  ngOnInit() {
      this.token = this.activatedRoute.snapshot.params['id'];
      console.log(' token transakcije je ::::: ' + this.token);
      this.proveraService.proveriPodatke(this.token).subscribe(data => {
        this.data = data;
        console.log('klijen ID: ' + this.data.id);

        setTimeout(() => {
          window.location.href = 'http://localhost:5000/paymentForm/' + this.token;
        }, 3000); //5s
      });
  }


}
