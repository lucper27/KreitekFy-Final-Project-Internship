import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ISong} from "../model/song.interface";
import {Router} from "@angular/router";

@Component({
  selector: 'app-song-card',
  templateUrl: './song-card.component.html',
  styleUrls: ['./song-card.component.scss']
})
export class SongCardComponent implements OnInit {
  @Input() song?: ISong;
  @Input() admin: boolean = false;
  @Output() delete: EventEmitter<number> = new EventEmitter();
  @Output() editSongModal: EventEmitter<number> = new EventEmitter();
  @Output() openSongDetail: EventEmitter<number> = new EventEmitter();


  constructor(
    private router: Router
  ) { }

  ngOnInit(): void { }

  deleteMe () {
    this.delete.emit(this.song?.id);
  }

  openMe() {
    if (this.admin) {
      this.editSongModal.emit(this.song?.id);
    } else {
      this.openSongDetail.emit(this.song?.id)
    }
  }
}
