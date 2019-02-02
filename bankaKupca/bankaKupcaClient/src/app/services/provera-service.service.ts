import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProveraServiceService {

  constructor(private http: HttpClient) { }

  proveriPodatke(token: String) {
    return this.http.post('http://localhost:8184/api/bankController/proveriPodatke', token);
  }

  posaljiPodatkeKupca(unetiPodaci, id: String) {
    return this.http.post('http://localhost:8184/api/karticaController/proveraAzuriranjeStanja/' + id , unetiPodaci);
  }

//za sada se ne koristi
  setNazivBanke( token: String) {
    return this.http.get('http://localhost:8184/api/karticaController/getNazivBanke/' + token );
  }
}
