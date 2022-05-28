import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IStyle} from "../../entities/song/model/song.interface";


@Injectable({
  providedIn: 'root'
})
export class StyleService {

  constructor(private http: HttpClient) { }

  public getAllStyles(partialName?: string): Observable<IStyle[]>{
    let urlEndpoint: string = "http://localhost:8080/stream/styles";
    if (partialName) {
      urlEndpoint = urlEndpoint + "?partialName=" + partialName;
    }
    return this.http.get<IStyle[]>(urlEndpoint);
  }
}
