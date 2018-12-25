import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class PlacanjeService {

  constructor(private http: HttpClient) { }


  obradaKriptovalute(){
    console.log('Obrada Kriptovalute');
    return this.http.get("http://localhost:8181/api/transakcija/kriptovaluta");
  }

  pripremiPodatkeZaBanku(id){
    console.log("Pripremaju se podaci za banku.");
    return this.http.post("http://localhost:8181/api/banka/uzmiPodatke", id);
  }
}
