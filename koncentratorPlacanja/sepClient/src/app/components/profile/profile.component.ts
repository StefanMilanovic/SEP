import { Component, OnInit } from '@angular/core';
import { RegisterServiceService } from '../../service/register-service.service';
import { NoviKorisnik } from 'src/app/entites/NoviKorisnik';
import { Router } from '@angular/router';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  private ulogovanKlijentEmail: string;
  private ulogovaniKlijent: any;
  private sacuvaneVrednosti = new NoviKorisnik();
  private isTextHidden = true;

  private payPalChecked: boolean;
  private bitCoinChecked: boolean;
  private bankChecked: boolean;

  constructor(private registerService: RegisterServiceService, private router: Router) { }


  ngOnInit() {
    this.ulogovanKlijentEmail = localStorage.getItem('profileId');
    console.log(this.ulogovanKlijentEmail);
    this.registerService.nadjiKlijenta(this.ulogovanKlijentEmail).subscribe( data => {
      this.ulogovaniKlijent = data;
      console.log(this.ulogovaniKlijent);
      this.payPalChecked = this.ulogovaniKlijent.paypalEnabled;
      this.bitCoinChecked = this.ulogovaniKlijent.bitcoinEnabled;
      this.bankChecked = this.ulogovaniKlijent.bankEnabled;
    });
  }

  payPalChanged(event){
    this.payPalChecked = event.checked;
    console.log(this.payPalChecked)
  }

  bitCoinChanged(event){
    this.bitCoinChecked = event.checked;
    console.log(this.bitCoinChecked);
  }

  bankChanged(event){
    this.bankChecked = event.checked;
    console.log(this.bankChecked);
  }

  saveChanges(){
    this.sacuvaneVrednosti.paypalEnabled = this.payPalChecked;
    this.sacuvaneVrednosti.bitcoinEnabled = this.bitCoinChecked;
    this.sacuvaneVrednosti.bankEnabled = this.bankChecked;
    this.sacuvaneVrednosti.email = this.ulogovanKlijentEmail;

    this.registerService.sacuvajIzmene(this.sacuvaneVrednosti).subscribe( data=> {
      if(data != null){
        this.isTextHidden = false;
        setTimeout(() => {
          window.location.reload();
        },1000);
      }
    });
  }

  logout(){
    this.router.navigate(['/login'])
  }
}
