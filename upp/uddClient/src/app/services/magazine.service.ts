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
}
