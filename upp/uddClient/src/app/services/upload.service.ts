import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpHeaders, HttpRequest} from '@angular/common/http';
import { Observable } from 'rxjs';
import {RequestOptions} from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  constructor(private http: HttpClient) { }

  pushFileToStorage(file: File, formUpload): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();

    formdata.append('textPDF', file);
    formdata.append('name',formUpload.name);
    formdata.append('keywords',formUpload.keywords);
    formdata.append('abbstract',formUpload.abbstract);


    const formdataNewTry: FormData = new FormData(formUpload);

    let headers = new HttpHeaders();

    headers.append('Content-type', 'multipart/form-data');
    //headers.append('Accept', 'application/json');

/*
    const req = new HttpRequest('POST', 'http://localhost:8080/upload/post', formdata, {
      reportProgress: true,
      responseType: 'text',
      headers: headers
    });
*/
    const req = new HttpRequest('POST', 'http://localhost:8080/index/add/1', formdata, {
      reportProgress: true,
      responseType: 'text',
      headers: headers
    });
    console.log("saljem na index contr : " + formdataNewTry);
    return this.http.request(req);


  }
  uploadIndex(formdata) {
    return this.http.post('http://localhost:8080/index/add/1',formdata);
  }

  getFiles(): Observable<any> {
    return this.http.get('http://localhost:8080/upload/getallfiles');
  }
}
