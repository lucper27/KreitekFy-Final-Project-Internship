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

  constructor(private songService: SongService,
              private modal: MatDialog,) { }

  ngOnInit(): void {
    this.getSongs();
  }

  private getSongs() {
    this.songService.getAllSongs().subscribe({
      next: ((allSongs: any) => {this.songList = allSongs.content}),
      error:(err => {console.log(err)})
    })
  }

  createNewSong() {
    const modalRef = this.modal.open(FormComponent);

    modalRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    })
    modalRef.afterClosed().subscribe(result => {
      this.getSongs();
    })
  }

  openModal(id: number) {
    const modalRef = this.modal.open(FormComponent, {
      data: id,
    });
    modalRef.afterClosed().subscribe(result => {
      this.getSongs();
    })

  }
}
