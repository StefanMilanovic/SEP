import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { NoviKorisnik } from 'src/app/entites/NoviKorisnik';
import { RegisterServiceService } from '../../service/register-service.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  private payPalHidden = true;
  private bitcoinHidden = true;
  private bankHidden = true;
  
  private form: FormGroup;
  private noviKorisnik = new NoviKorisnik();

  constructor(@Inject(FormBuilder) formBuilder: FormBuilder, private registerService: RegisterServiceService, private router: Router) {
    this.form = formBuilder.group({
      companyName: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
      password2: new FormControl(''),
      success_url: new FormControl('',[Validators.required]),
      failed_url: new FormControl('',[Validators.required]),
      error_url: new FormControl('',[Validators.required]),
      paypalSecret: new FormControl(''),
      bitcoinSecret: new FormControl(''),
      bank_id: new FormControl(''),
      bank_pass: new FormControl('')
    }, {validators: this.checkPasswords });
   }

  checkPasswords(group: FormGroup) {
    let pass = group.controls.password.value;
    let confirmPass = group.controls.password2.value;

    return pass === confirmPass ? null : { notSame: true }     
  }

  ngOnInit() {
  }

  cancelClicked(){
    window.location.href = "http://localhost:4200/";
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

  submit(event: any){
    // this.noviKorisnik = this.form.value;
    this.noviKorisnik.imeKompanije = this.form.value.companyName;
    this.noviKorisnik.email = this.form.value.email;
    this.noviKorisnik.password = this.form.value.password;
    this.noviKorisnik.successUrl = this.form.value.success_url;
    this.noviKorisnik.failedUrl = this.form.value.failed_url;
    this.noviKorisnik.errorUrl = this.form.value.error_url;
    this.noviKorisnik.paypalSecret = this.form.value.paypalSecret;
    this.noviKorisnik.bitcoinSecret = this.form.value.bitcoinSecret;
    this.noviKorisnik.bankId = this.form.value.bank_id;
    this.noviKorisnik.bankPass = this.form.value.bank_pass;
    // console.log(this.noviKorisnik);

    this.registerService.registrujKorisnika(this.noviKorisnik).subscribe(data => {  
      console.log("Korisnik uspesno registrovan");
      this.router.navigate(['']);
    });


  }

}
