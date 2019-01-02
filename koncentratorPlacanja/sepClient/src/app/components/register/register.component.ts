import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  private payPalHidden = true;
  private bitcoinHidden = true;
  private bankHidden = true;

  constructor() { }

  ngOnInit() {
  }

  onSubmit(event){
    console.log("awdawdawdawdawdw");
  }

  cancelClicked(){
    window.location.href = "http://localhost:4200/";
  }

  payPalRadioChange(event){
    if(event.target.id == "paypalEnable"){
      this.payPalHidden = false;
      console.log("Enable");
    }
    else {
      this.payPalHidden = true;
      console.log("Disable");
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
