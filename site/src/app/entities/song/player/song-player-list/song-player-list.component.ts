import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-song-player-list',
  templateUrl: './song-player-list.component.html',
  styleUrls: ['./song-player-list.component.scss']
})
export class SongPlayerListComponent implements OnInit {

  song: any = {
    "img": "https://dice-i-scdn-co.imgix.net/image/ab6761610000e5eb12a2ef08d00dd7451a6dbed6",
    "artistName": "Ed Sheran",
    "name": "Bad Habits",
    "description": "Lorem ipsu vitao asd macniantial when du sremake te table guen win t game"
  };

  constructor() { }

  ngOnInit(): void {

  }

}
