import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Profile} from "../model/song.model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient) { }

  public getAllUsers(): Observable<Profile[]>{
    let urlEndpoint: string = "http://localhost:8080/stream/profiles/";
    return this.http.get<Profile[]>(urlEndpoint);
  }
}
