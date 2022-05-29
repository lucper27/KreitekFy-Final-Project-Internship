import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ISong} from "../model/song.interface";

@Injectable({
  providedIn: 'root'
})
export class SongService {

  constructor(private http: HttpClient) { }

  public getAllSongs(page: number, size: number, sort: string, filters?: string ): Observable<ISong[]>{
    let urlEndpoint: string = "http://localhost:8080/stream/songs?page="+ page + "&size=" + size + "&sort=" + sort;
    if (filters) {
      urlEndpoint = urlEndpoint + "&filter=" + filters;
    }
    return this.http.get<ISong[]>(urlEndpoint);
  }

  public getSongById(songId: any): Observable<ISong> {
    const urlEndpoint: string = "http://localhost:8080/stream/songs/" + songId;
    return this.http.get<ISong>(urlEndpoint);
  }

  public insertSong(song: ISong): Observable<ISong> {
    const urlEndpoint: string = "http://localhost:8080/stream/songs";
    return this.http.post<ISong>(urlEndpoint, song);
  }

  public updateSong(song: ISong): Observable<ISong> {
    const urlEndpoint: string = "http://localhost:8080/stream/songs";
    return this.http.put<ISong>(urlEndpoint, song);
  }

  public deleteSong(songId: number): Observable<any> {
    const urlEndpoint: string = "http://localhost:8080/stream/songs/" + songId;
    return this.http.delete<any>(urlEndpoint);
  }

}

