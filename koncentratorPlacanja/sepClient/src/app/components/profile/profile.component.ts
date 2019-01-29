import { Component, OnInit, Inject } from '@angular/core';
import { RegisterServiceService } from '../../service/register-service.service';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
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
  private payPalHidden = true;
  private bitcoinHidden = true;
  private bankHidden = true;

  private form: FormGroup;

  private bitCoinValue: string;
  

  constructor(private formBuilder: FormBuilder, private registerService: RegisterServiceService, private router: Router) { 
    this.form = this.formBuilder.group({
      success_url: new FormControl('',[Validators.required]),
      failed_url: new FormControl('',[Validators.required]),
      error_url: new FormControl('',[Validators.required]),
      paypalSecret: new FormControl(''),
      bitcoinSecret: new FormControl(''),
      bank_id: new FormControl(''),
      bank_pass: new FormControl(''),
      bitcoin: new FormControl(''),
      paypal: new FormControl(''),
      bank: new FormControl('')

    });
  }


  ngOnInit() {
    this.ulogovanKlijentEmail = localStorage.getItem('profileId');
    console.log(this.ulogovanKlijentEmail);
    this.registerService.nadjiKlijenta(this.ulogovanKlijentEmail).subscribe( data => {
      this.ulogovaniKlijent = data;
      console.log(this.ulogovaniKlijent);

      this.form = this.formBuilder.group({
        success_url: new FormControl(this.ulogovaniKlijent.successUrl ,[Validators.required]),
        failed_url: new FormControl(this.ulogovaniKlijent.failedUrl ,[Validators.required]),
        error_url: new FormControl(this.ulogovaniKlijent.errorUrl ,[Validators.required]),
        paypalSecret: new FormControl(this.ulogovaniKlijent.paypalSecret),
        bitcoinSecret: new FormControl(this.ulogovaniKlijent.bitcoinSecret),
        bank_id: new FormControl(this.ulogovaniKlijent.bankId),
        bank_pass: new FormControl(this.ulogovaniKlijent.bankPass),        
        bitcoin: new FormControl(this.ulogovaniKlijent.bitcoinEnabled),
        paypal: new FormControl(this.ulogovaniKlijent.paypalEnabled == true),
        bank: new FormControl(this.ulogovaniKlijent.bankEnabled)
      });

      if(this.ulogovaniKlijent.bitcoinEnabled == true){
        this.bitcoinHidden = false;        
      }
      else {
        this.bitcoinHidden = true;
      }

      if(this.ulogovaniKlijent.bankEnabled == true){
        this.bankHidden = false;
      }

      if(this.ulogovaniKlijent.paypalEnabled == true){
        this.payPalHidden = false;
      }

    });
  }

  saveChanges(){    
    this.sacuvaneVrednosti.email = this.ulogovanKlijentEmail;
    this.sacuvaneVrednosti.successUrl = this.form.value.success_url;
    this.sacuvaneVrednosti.failedUrl = this.form.value.failed_url;
    this.sacuvaneVrednosti.errorUrl = this.form.value.error_url;    
    this.sacuvaneVrednosti.paypalSecret = this.form.value.paypalSecret;
    this.sacuvaneVrednosti.bitcoinSecret = this.form.value.bitcoinSecret;
    this.sacuvaneVrednosti.bankId = this.form.value.bank_id;
    this.sacuvaneVrednosti.bankPass = this.form.value.bank_pass;
    this.sacuvaneVrednosti.paypalEnabled = !this.payPalHidden;
    this.sacuvaneVrednosti.bitcoinEnabled = !this.bitcoinHidden;
    this.sacuvaneVrednosti.bankEnabled = !this.bankHidden;

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

  payPalRadioChange(event){
    if(event.target.id == "paypalEnable"){
      this.payPalHidden = false;
    }
    else {
      this.payPalHidden = true;      
    }    
  }
  
  bitcoinRadioChange(event){
    if(event.target.id == 'bitcoinEnable'){
      this.bitcoinHidden = false;
    }
    else {
      this.bitcoinHidden = true;
    }
  }

  bankRadioChange(event){
    if(event.target.id == 'bankEnable'){
      this.bankHidden = false;
    }
    else {
      this.bankHidden = true;
    }
  }
}
