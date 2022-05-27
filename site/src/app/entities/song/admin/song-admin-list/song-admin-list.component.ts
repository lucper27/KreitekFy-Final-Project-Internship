import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-song-admin-list',
  templateUrl: './song-admin-list.component.html',
  styleUrls: ['./song-admin-list.component.scss']
})
export class SongAdminListComponent implements OnInit {
  songList: any = [];

  constructor() { }

  ngOnInit(): void {
    this.getSongs();
  }

  private getSongs() {
    const song = {
      "img": "https://dice-i-scdn-co.imgix.net/image/ab6761610000e5eb12a2ef08d00dd7451a6dbed6",
      "artistName": "Ed Sheran",
      "name": "Bad Habits",
      "description": "Lorem ipsu vitao asd macniantial when du sremake te table guen win t game"
    };

    for (let i = 0; i < 50; i++) {
      this.songList.push(song)
    }
    console.log(this.songList);
  }
}
