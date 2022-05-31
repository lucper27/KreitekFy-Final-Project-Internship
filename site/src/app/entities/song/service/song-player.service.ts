import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {ISong} from "../model/song.interface";

@Injectable({
  providedIn: 'root'
})
export class SongPlayerService {

  constructor(private http: HttpClient) { }

  public getAllNewSongs(styleId?: number): Observable<ISong[]>{
    let urlEndpoint: string;
    let header = new HttpHeaders();

    if (styleId) {
      urlEndpoint = "http://localhost:8080/stream/songs/news?styleId=" + styleId
      header = header.set('Accept', 'application/songStyleId+json');
    }else {
      urlEndpoint = "http://localhost:8080/stream/songs/news"
    }

    return this.http.get<ISong[]>(urlEndpoint, {'headers': header});
  }

  public getAllRatedSongs(styleId?: number): Observable<ISong[]>{
    let urlEndpoint: string;
    let header = new HttpHeaders();

    if (styleId) {
      urlEndpoint = "http://localhost:8080/stream/songs/ratings?styleId=" + styleId
      header = header.set('Accept', 'application/songStyleId+json');
    }else {
      urlEndpoint = "http://localhost:8080/stream/songs/ratings"
    }

    return this.http.get<ISong[]>(urlEndpoint, {'headers': header});
  }

  public getMostReproducedSongs(styleId?: number): Observable<ISong[]>{
    let urlEndpoint: string;
    let header = new HttpHeaders();

    if (styleId) {
      urlEndpoint = "http://localhost:8080/stream/songs/reproduced?styleId=" + styleId
      header = header.set('Accept', 'application/songStyleRepId+json');
    }else {
      urlEndpoint = "http://localhost:8080/stream/songs/reproduced"
    }

    return this.http.get<ISong[]>(urlEndpoint, {'headers': header});
  }
}
