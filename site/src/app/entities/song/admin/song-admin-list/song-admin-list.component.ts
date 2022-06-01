import {Component, OnInit} from '@angular/core';
import {ISong} from "../../model/song.interface";
import {SongService} from "../../service/song.service";
import {MatDialog} from "@angular/material/dialog";
import {FormComponent} from "../../../../layout/form/form.component";
import {FilterService} from "../../../../layout/filters/service/filter.service";

@Component({
  selector: 'app-song-admin-list',
  templateUrl: './song-admin-list.component.html',
  styleUrls: ['./song-admin-list.component.scss']
})
export class SongAdminListComponent implements OnInit {
  songList: ISong[] = [];

  page: number = 0;
  size: number = 25;
  sort: string = "name,asc";

  first: boolean = false;
  last: boolean = false;
  totalPages: number = 0;
  totalElements: number = 0;

  albumFilter?: string;
  styleFilter?: string;
  artistFilter?: string;
  songFilter?: string;

  constructor(
    private songService: SongService,
    private modal: MatDialog,
    private filterService: FilterService

  ) { }

  ngOnInit(): void {
    this.getSongs();
  }

  private getSongs() {
    let filters: string | undefined = '';
    filters = this.filterService.buildFilters(this.albumFilter, this.artistFilter, this.styleFilter, this.songFilter)

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

  public createSongModal() {
    const modalRef = this.modal.open(FormComponent);
    modalRef.afterClosed().subscribe(result => {
      this.getSongs();
    })
  }

  public editSongModal(songId: number) {
    const modalRef = this.modal.open(FormComponent, {
      data: songId});
    modalRef.afterClosed().subscribe(result => {
      this.getSongs();
    })
  }

  public deleteSong(songId: number) {
    this.songService.deleteSong(songId).subscribe(res => {
      this.getSongs();
    });
  }

  searchByFilters() {
    this.getSongs();
  }
}
