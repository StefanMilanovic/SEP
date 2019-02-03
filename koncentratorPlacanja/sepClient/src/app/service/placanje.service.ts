import { Injectable } from '@angular/core';
import {HttpClient, HttpXsrfTokenExtractor} from '@angular/common/http';
import {Router} from '@angular/router';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PlacanjeService {

  constructor(private http: HttpClient) { }


  obradaKriptovalute(id){
    console.log('Obrada Kriptovalute');
    return this.http.get("http://localhost:8181/api/transakcija/kriptovaluta/" + id);

  }

  pripremiPodatkeZaBanku(id){
    console.log("Pripremaju se podaci za banku.");
    return this.http.post("http://localhost:8181/api/banka/pripremiPodatke", id);
  }

  posaljiBanciPodatke(data, urlBank){
    return this.http.post(urlBank + "/api/primiPodatke/primi", data)
  }


  uzmiPodatkeZaPayPal(id){
    return this.http.get("http://localhost:8181/api/payPal/uzmiPayPalPodatke/" + id);
  }
  getUrlBank(bankCode){
    return this.http.get("http://localhost:8181/api/banka/getUrlBank/" + bankCode);
  }
}
