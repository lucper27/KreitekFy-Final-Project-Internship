import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ISong} from "../model/song.interface";

@Injectable({
  providedIn: 'root'
})
export class SongPlayerService {

  constructor(private http: HttpClient) { }

  public getAllNewSongs(): Observable<ISong[]>{
    let urlEndpoint: string = "http://localhost:8080/stream/songs/news";
    return this.http.get<ISong[]>(urlEndpoint);
  }
}
