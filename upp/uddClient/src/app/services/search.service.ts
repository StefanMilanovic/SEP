import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private httpClient: HttpClient) { }

  serachMagazineTitle(formTitleMagazine){
    return this.httpClient.post('http://localhost:8080/search/nameMagazine', formTitleMagazine);
  }

  serachTitle(formTitle){
    return this.httpClient.post('http://localhost:8080/search/title', formTitle);
  }
}
