import { Component, OnInit } from '@angular/core';
import {ISong} from "../../model/song.interface";
import {SongService} from "../../service/song.service";
import {MatDialog} from "@angular/material/dialog";
import {FormComponent} from "../../../../layout/form/form.component";

@Component({
  selector: 'app-song-admin-list',
  templateUrl: './song-admin-list.component.html',
  styleUrls: ['./song-admin-list.component.scss']
})
export class SongAdminListComponent implements OnInit {
  songList: ISong[] = [];

  page: number = 0;
  size: number = 1;
  sort: string = "name,asc";

  first: boolean = false;
  last: boolean = false;
  totalPages: number = 0;
  totalElements: number = 0;

  albumFilter?: string;
  artistFilter?: string;
  styleFilter?: string;

  constructor(
    private songService: SongService,
    private modal: MatDialog
    ) { }

  ngOnInit(): void {
    this.getSongs();
  }

  private getSongs() {
    const filters:string | undefined = this.buildFilters();

    this.songService.getAllSongs(this.page, this.size, this.sort, filters).subscribe({
      next: ((allSongs: any) => {
        this.songList = allSongs.content;
        this.first = allSongs.first;
        this.last = allSongs.last;
        this.totalPages = allSongs.totalPages;
        this.totalElements = allSongs.totalElements;
      }),
      error:(err => {console.log(err)})
    })
  }
  public nextPage():void {
    this.page = this.page + 1;
    this.getSongs();
  }

  public previousPage():void {
    this.page = this.page - 1;
    this.getSongs();
  }

  public searchByFilters():void {
    this.getSongs();
  }

  private buildFilters():string|undefined {
    const filters: string[] = [];

    if (this.albumFilter) {
      filters.push("album.title:MATCH:" + this.albumFilter);
    }

    if(this.artistFilter) {
      filters.push("artist.name:MATCH:" + this.artistFilter);
    }

    if (this.styleFilter) {
      filters.push("style.name:MATCH:" + this.styleFilter);
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

  public createSongModal() {
    const modalRef = this.modal.open(FormComponent);

    modalRef.afterClosed().subscribe(result => {
      this.getSongs();
    })
  }

  public editSongModal(songId: number) {
    const modalRef = this.modal.open(FormComponent, {
      data: songId,
    });
    modalRef.afterClosed().subscribe(result => {
      this.getSongs();
    })

  }

  public deleteSong(songId: number) {
    this.songService.deleteSong(songId).subscribe(res => {
      this.getSongs();
    });

  }
}
