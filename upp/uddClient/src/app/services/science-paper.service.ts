import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpHeaders, HttpRequest} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Stringer } from '../entities/Stringer'

@Injectable({
  providedIn: 'root'
})
export class SciencePaperService {

  constructor(private httpClient: HttpClient) { }

  getAllPapers(param: String) {    
    return this.httpClient.get('http://localhost:8080/paper/getUnapproved');
  }

  deletePaper(paper){
    console.log(paper.id);
    return this.httpClient.delete('http://localhost:8080/paper/delete/' + paper.id);
  }

  addComment(commentValue, selectedPaperId: String){
    // let headers = new HttpHeaders();
    // headers.append('Content-Type', 'application/json',)
    // const req = new HttpRequest('POST', 'http://localhost:8080/paper/addComment' + selectedPaperId, commentValue, {      
    //   headers: headers
    // });
    //return this.httpClient.request(req);
    let stringer = new Stringer();
    stringer.commentValue = commentValue;
    return this.httpClient.post('http://localhost:8080/paper/addComment/' + selectedPaperId, stringer);
  }
}
