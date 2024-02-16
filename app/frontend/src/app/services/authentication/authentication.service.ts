import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  private createUserApiUrl = "http://localhost:8080/api/v1/user/create";
  private authUserApiUrl = "http://localhost:8080/api/v1/auth/login";
  registerUser(userData: any) {
    return this.http.post(this.createUserApiUrl, userData);
  }

  authLogin (userData: any) {
    return this.http.post(this.authUserApiUrl, userData);
  }

}
