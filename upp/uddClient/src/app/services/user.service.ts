import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  logUser(logUser){
    return this.httpClient.get('http://localhost:8080/user/login/' + logUser.email + '/' + logUser.password);
  }

  registerUser(newUser){
    return this.httpClient.post('http://localhost:8080/user/register', newUser);
  }
}
