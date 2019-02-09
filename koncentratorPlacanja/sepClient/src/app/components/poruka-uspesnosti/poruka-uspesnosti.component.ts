import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { ResultService } from '../../service/result.service'

@Component({
  selector: 'app-poruka-uspesnosti',
  templateUrl: './poruka-uspesnosti.component.html',
  styleUrls: ['./poruka-uspesnosti.component.css']
})
export class PorukaUspesnostiComponent implements OnInit {

  private result: string;
  private token: string;


  constructor(private router: Router, private activatedRoute:ActivatedRoute, private resultService: ResultService) { }

  ngOnInit() {
    this.result = this.activatedRoute.snapshot.params['result'];
    this.token = this.activatedRoute.snapshot.params['token'];
    this.resultService.resultTransakcija(this.token, this.result).subscribe((data: any)=> {
      console.log(data);

      if(this.result == 'success'){
        setTimeout(() => {
          top.location.href = data.successUrl;
        }, 2500);
      }
      else if(this.result == 'failure'){
        setTimeout(() => {
          top.location.href = data.failedUrl;
        }, 2500);
      }
      else{
        setTimeout(() => {
          top.location.href = data.errorUrl;
        }, 2500);
      }

    })
    console.log(this.result);
    console.log(this.token);
  }

}
