import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { LogUser } from '../../entities/logUser';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css', './utils.css']
})
export class LoginComponent implements OnInit {
  
  private logUser: LogUser = new LogUser();
  private form: FormGroup;

  constructor(private userService: UserService, @Inject(FormBuilder) formBuilder: FormBuilder) {

    this.form = formBuilder.group({
      email: new FormControl('',[Validators.required]),
      password: new FormControl('',[Validators.required])
    });

   }

  ngOnInit() {
  }

  login(){
    this.logUser.email = this.form.value.email;
    this.logUser.password = this.form.value.password;
    console.log(this.logUser);
    this.userService.logUser(this.logUser).subscribe(data =>{
      console.log(data);
    })
  }
}

