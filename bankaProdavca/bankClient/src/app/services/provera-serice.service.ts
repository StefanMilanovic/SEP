import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProveraSericeService {

  constructor(private http: HttpClient) { }

  uzmiPodatke(){
    return this.http.get("http://localhost:8181/api/transakcija/kriptovaluta");
  }
}
