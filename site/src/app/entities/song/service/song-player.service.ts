import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {IRate, IReproduction, ISong} from "../model/song.interface";

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

  public addRateSong(rating: IRate) {
    const urlEndpoint = `http://localhost:8080/stream/profiles/${rating.profileId}/ratings`
    return this.http.put<IRate[]>(urlEndpoint, rating);
  }

  public addReproduction(reproduction: IReproduction) {
    const urlEndpoint = `http://localhost:8080/stream/songs/${reproduction.songId}/reproductions`
    return this.http.post<IReproduction[]>(urlEndpoint, reproduction);
  }

  getRecommendedSongs(profileId?: number): Observable<ISong[]> {
    let urlEndpoint: string;
    urlEndpoint = "http://localhost:8080/stream/songs/recommended?profileId="+profileId;
    return this.http.get<ISong[]>(urlEndpoint)
  }
}
