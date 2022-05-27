import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IAlbum} from "../interfaces/album.interface";

@Injectable({
  providedIn: 'root'
})
export class AlbumService {

  constructor(private http: HttpClient) { }

  public getAllAlbums(partialName?: string): Observable<IAlbum[]>{
    //let urlEndpoint: string = "http://localhost:8080/stream/artists";
    let urlEndpoint: string = "src/assets/dataTest/album.json";
    if (partialName) {
      urlEndpoint = urlEndpoint + "?partialName=" + partialName;
    }
    return this.http.get<IAlbum[]>(urlEndpoint);
  }
}
