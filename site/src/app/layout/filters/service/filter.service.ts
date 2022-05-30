import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FilterService {

  constructor() {  }

  public buildFilters(albumFilter?: string, artistFilter?: string, styleFilter?: string,):string|undefined {
    const filters: string[] = [];

    if (albumFilter) {
      filters.push("album.title:EQUAL:" + albumFilter);
    }

    if(artistFilter) {
      filters.push("artist.name:EQUAL:" + artistFilter);
    }

    if (styleFilter) {
      filters.push("style.name:EQUAL:" + styleFilter);
    }

    if (filters.length >0) {

      let globalFilters: string = "";
      for (let filter of filters) {
        globalFilters = globalFilters + filter + ",";
      }
      globalFilters = globalFilters.substring(0, globalFilters.length-1);
      return globalFilters;

    } else {
      return undefined;
    }
  }



}