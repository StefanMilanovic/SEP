import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ResultService {

  constructor(private httpClient: HttpClient) { }

  resultTransakcija(token, result){
  //  return this.httpClient.post('http://localhost:8181/api/transakcija/resultTransakcija/' + token, result);
    return this.httpClient.post('http://43c043fc.ngrok.io/api/transakcija/resultTransakcija/' + token, result);

  }
}
