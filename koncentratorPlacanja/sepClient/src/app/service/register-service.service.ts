import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterServiceService {

  constructor(private httpClient: HttpClient) { }

  registrujKorisnika(noviKorisnik){
    console.log(noviKorisnik);
  //  return this.httpClient.post("http://localhost:8181/api/klijent/registruj", noviKorisnik);
    return this.httpClient.post("http://43c043fc.ngrok.io/api/klijent/registruj", noviKorisnik);

  }

  logujKorisnika(korisnik){
    console.log(korisnik);
   // return this.httpClient.post("http://localhost:8181/api/klijent/ulogojKlijenta", korisnik);
    return this.httpClient.post("http://43c043fc.ngrok.io/api/klijent/ulogojKlijenta", korisnik);

  }

  nadjiKlijenta(email){
   // return this.httpClient.post("http://localhost:8181/api/klijent/nadjiKlijenta/", email);
    return this.httpClient.post("http://43c043fc.ngrok.io/api/klijent/nadjiKlijenta/", email);

  }

  sacuvajIzmene(klijent){
    //return this.httpClient.put("http://localhost:8181/api/klijent/izmeniKlijenta", klijent);
    return this.httpClient.put("http://43c043fc.ngrok.io/api/klijent/izmeniKlijenta", klijent);

  }
}
