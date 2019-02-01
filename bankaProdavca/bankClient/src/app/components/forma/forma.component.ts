import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, Validators, AbstractControl} from '@angular/forms';
import {ProveraSericeService} from '../../services/provera-serice.service';
import {ActivatedRoute, Router} from '@angular/router';
import {KupacUnos} from '../../model';

@Component({
  selector: 'app-forma',
  templateUrl: './forma.component.html',
  styleUrls: ['./forma.component.css']
})
export class FormaComponent implements OnInit {
  formGroup: FormGroup;
  kupacUnos: KupacUnos;
  private token: string;
  private odgovorUplate: any;

  form = new FormGroup({
    PAN: new FormControl('', Validators.compose ([Validators.required])),
    CSC: new FormControl('', Validators.compose ([Validators.required])),
    brojKartice: new FormControl('', Validators.compose ([Validators.required])),
    vlasnikKartice: new FormControl('', Validators.compose ([Validators.required])),
    datumIsteka: new FormControl(this.getTodaysDate(), Validators.compose ([Validators.maxLength(10), this.dateValidationStart]) ),

  });
  constructor(private router: Router, private proveraService: ProveraSericeService, private activatedRoute: ActivatedRoute) {
   
    this.form = new FormGroup({
      pan: new FormControl('', Validators.compose ([Validators.required])),
      csc: new FormControl('', Validators.compose ([Validators.required])),
      brojKartice: new FormControl('', Validators.compose ([Validators.required])),
      vlasnikKartice: new FormControl('', Validators.compose ([Validators.required])),
      datumIsteka: new FormControl(this.getTodaysDate(), Validators.compose ([Validators.maxLength(10), this.dateValidationStart]) ),

    });
    this.kupacUnos = new KupacUnos;
  }

  ngOnInit() {
    this.token = this.activatedRoute.snapshot.params['user'];
  }

  ponisti() {
    window.location.href = 'http://localhost:4200/';
  }

  getTodaysDate(): string {
    const today = new Date();
    const dd = today.getDate();
    const mm = today.getMonth() + 1; // January is 0!
    const yyyy = today.getFullYear();
    let pd = dd.toString();
    let pm = mm.toString();
    if ( dd < 10 ) {
      pd = '0' + dd;
    }
    if (mm < 10) {
      pm = '0' + mm ;
    }
    const todayStr = yyyy + '-' + pm + '-' + pd ;
    return todayStr;
  }

  dateValidationStart(control) {
    const today = new Date();
    const startD = new Date(control.value);
    if ((+control.value.slice(0, -6)) < (+today.getFullYear())) {// ako je  godina uneta < manja od danasnje - ne moze
      return {'searchSDT': false};
    }
    if ((+control.value.slice(0, -6)) === (+today.getFullYear())) {
      // console.log(control.value.slice(5, -3) + '  i  ' + (today.getMonth() + 1));
      if (+control.value.slice(5, -3) < (+(today.getMonth() + 1))) {// da li je u istoj godini mesec uneti manji od danasnjeg - ne moze
        console.log('mesec nije dobar');
        return {'searchSDT': false};
      }
      if (+control.value.slice(5, -3) === (+(today.getMonth() + 1))) {// ako je mesec isti proveri dan
        if (+control.value.slice(8, 10) < (+(today.getDate()))) {
          console.log('dan nije dobar');
          return {'searchSDT': false};
        }
      }
    }
  }

  onSubmit = function (unetiPodaci) {
    console.log(unetiPodaci);
    console.log('Saljem token :' + this.token);
      this.proveraService.posaljiPodatkeKupca(unetiPodaci, this.token).subscribe(data => {
        this.odgovorUplate = data;
        console.log(this.odgovorUplate);
        if(this.odgovorUplate.result == "success"){
          window.location.href = 'http://localhost:4200/rezultat/success/' + this.odgovorUplate.token;
        }
        else if(this.odgovorUplate.result =="failure"){
          window.location.href = 'http://localhost:4200/rezultat/failure/' + this.odgovorUplate.token;
        }
        else{
          
        }
        // setTimeout(() => {
        //   window.location.href = 'http://localhost:5000/paymentForm/' + this.token;
        // }, 3000); //5s
      });
  };

}
