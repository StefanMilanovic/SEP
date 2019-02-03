import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PccService {

  constructor(private http: HttpClient) { }

  posaljiKaPcc(pccData){
    return this.http.post("http://localhost:8183/api/usmeravanje/prihvatiPodatke", pccData);
  }

  posaljiKaDrugojBanci(bankUrl, bankData){
    return this.http.post(bankUrl, bankData);
  }

  zavrsiPccTransakciju(bankData){
    return this.http.post('http://localhost:8182/api/bankPccController/zavrsiPccTransakciju', bankData);
  }
}
