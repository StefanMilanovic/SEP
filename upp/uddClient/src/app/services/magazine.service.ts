import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class MagazineService {

  constructor(private httpClient: HttpClient) { }

  getAllMagazines(){
    return this.httpClient.get('http://localhost:8080/magazine/getAllMagazines');
  }

  createTransaction(price){
    console.log(price);
    return this.httpClient.post('http://localhost:8080/magazine/createKoncentratorData', price);
  }

  sendTransaction(transaction){
    return this.httpClient.post('http://localhost:8181/api/transakcija/kreirajTransakciju', transaction);
  }

  allowUser(magazineId){
    return this.httpClient.post('http://localhost:8080/magazine/allowUser', magazineId);
  }

  downloadPaper(paper){
    return this.httpClient.post('http://localhost:8080/paper/download', paper.name);
  }
}