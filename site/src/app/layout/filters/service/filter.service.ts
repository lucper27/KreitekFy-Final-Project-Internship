import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FilterService {

  constructor() {  }

  public buildFilters(albumFilter?: string, artistFilter?: string, styleFilter?: string, nameFilter?: string):string|undefined {
    const filters: string[] = [];

    if (albumFilter) {
      filters.push("album.title:MATCH:" + albumFilter);
    }

    if(artistFilter) {
      filters.push("artist.name:MATCH:" + artistFilter);
    }

    if (styleFilter) {
      filters.push("style.name:MATCH:" + styleFilter);
    }

    if (nameFilter) {
      filters.push("name:MATCH:" + nameFilter);
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
