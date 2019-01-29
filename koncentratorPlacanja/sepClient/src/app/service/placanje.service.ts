import { Injectable } from '@angular/core';
import {HttpClient, HttpXsrfTokenExtractor} from '@angular/common/http';
import {Router} from '@angular/router';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PlacanjeService {

  constructor(private http: HttpClient) { }


  obradaKriptovalute(podaciKriptovaluta){
    console.log('Obrada Kriptovalute');
    return this.http.post("http://localhost:8181/api/transakcija/kriptovaluta", podaciKriptovaluta);
    
  }

  pripremiPodatkeZaBanku(id){
    console.log("Pripremaju se podaci za banku.");
    return this.http.post("http://localhost:8181/api/banka/uzmiPodatke", id);
  }

  posaljiBanciPodatke(data){
    return this.http.post("http://localhost:8182/api/primiPodatke/primi", data)
  }
  
  obradaKriptovalute2() {
    return this.http.get("http://localhost:8181/api/transakcija/kriptovaluta2").pipe(map((response : Response) => {
      const data = response.text();
      return data;
    }));
  }
}
