import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IArtist} from "../../entities/song/model/song.interface";


@Injectable({
  providedIn: 'root'
})
export class ArtistService {

  constructor(private http: HttpClient) { }

  public getAllArtists(partialName?: string): Observable<IArtist[]>{
    let urlEndpoint: string = "http://localhost:8080/stream/artists";
    if (partialName) {
      urlEndpoint = urlEndpoint + "?partialName=" + partialName;
    }
    return this.http.get<IArtist[]>(urlEndpoint);
  }
}
