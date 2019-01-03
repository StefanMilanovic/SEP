import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterServiceService {

  constructor(private httpClient: HttpClient) { }

  registrujKorisnika(noviKorisnik){
    console.log(noviKorisnik);
    return this.httpClient.post("http://localhost:8181/api/klijent/registruj", noviKorisnik)
  }
}
