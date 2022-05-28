import {Component, Input, OnInit} from '@angular/core';
import {ISong} from "../model/song.interface";

@Component({
  selector: 'app-song-card',
  templateUrl: './song-card.component.html',
  styleUrls: ['./song-card.component.scss']
})
export class SongCardComponent implements OnInit {
  @Input() song?: ISong;
  @Input() admin: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

}
