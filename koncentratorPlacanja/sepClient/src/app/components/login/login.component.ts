import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { NoviKorisnik } from 'src/app/entites/NoviKorisnik';
import { RegisterServiceService } from '../../service/register-service.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private form: FormGroup;
  private logKorisnik = new NoviKorisnik();
  private bottomTextHidden = true;

  constructor(@Inject(FormBuilder) formBuilder: FormBuilder, private registerService: RegisterServiceService, private router: Router) { 
    this.form = formBuilder.group({
      email: new FormControl('',[Validators.required]),
      password: new FormControl('',[Validators.required])
    });
  }

  ngOnInit() {
  }

  submit(event:any){
    this.logKorisnik.email = this.form.value.email;
    this.logKorisnik.password = this.form.value.password;

    this.registerService.logujKorisnika(this.logKorisnik).subscribe(data => {
      console.log(data);
      if(data == true){
        localStorage.setItem('profileId', this.logKorisnik.email);
        this.router.navigate(['/profile']);
      }
      else {
        this.bottomTextHidden = false;
      }
    });
  }

  cancel(){
    this.router.navigate(['']);
  }

}
