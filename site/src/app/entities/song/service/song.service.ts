import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Profile} from "../model/song.model";

@Injectable({
  providedIn: 'root'
})
export class SongService {

  constructor(private http: HttpClient) { }

  public getAllUsers(): Observable<Profile[]>{
    let urlEndpoint: string = "http://localhost:8080/stream/profiles/";
    return this.http.get<Profile[]>(urlEndpoint);
}
}
