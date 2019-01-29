import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProveraSericeService {

  constructor(private http: HttpClient) { }

  proveriPodatke(token: String) {
    return this.http.post('http://localhost:8182/api/bankController/proveriPodatke', token);
  }

  posaljiPodatkeKupca(unetiPodaci, id: String) {
    return this.http.post('http://localhost:8182/api/karticaController/proveraAzuriranjeStanja/' + id , unetiPodaci);
  }


}
