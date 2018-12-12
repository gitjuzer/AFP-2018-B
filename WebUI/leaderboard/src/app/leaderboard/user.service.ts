import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  //lbUrl = 'http://afpquiz.herokuapp.com/rest/service';
  lbUrl = "../assets/users.json";
  constructor(private http: HttpClient) { }

  getLb() {
    return this
            .http
            .get(`${this.lbUrl}`);
        }
}
