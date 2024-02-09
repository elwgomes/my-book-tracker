import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  private apiUrl = "http://localhost:8080/api/v1/user"

  registerUser(userData: any) {
    return this.http.post(this.apiUrl, userData);
  }

}
