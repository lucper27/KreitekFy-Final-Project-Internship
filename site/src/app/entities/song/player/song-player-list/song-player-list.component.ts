import { Component, OnInit } from '@angular/core';
import {ISong} from "../../model/song.interface";
import {SongPlayerService} from '../../service/song-player.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-song-player-list',
  templateUrl: './song-player-list.component.html',
  styleUrls: ['./song-player-list.component.scss']
})
export class SongPlayerListComponent implements OnInit {

  // song: any = {
  //   "img": "https://dice-i-scdn-co.imgix.net/image/ab6761610000e5eb12a2ef08d00dd7451a6dbed6",
  //   "artistName": "Ed Sheran",
  //   "name": "Bad Habits",
  //   "description": "Lorem ipsu vitao asd macniantial when du sremake te table guen win t game"
  // };

  songList: ISong[] = [];

  constructor(private songPlayerService: SongPlayerService, private router: Router) { }

  ngOnInit(): void {
    this.getAllNewSongs();
    console.log(this.songList);
  }

  private getAllNewSongs() {
    this.songPlayerService.getAllNewSongs().subscribe({
      next: ((allNewSongs: any) => {this.songList = allNewSongs
        console.log(allNewSongs)
      }),
      error:((err: any) => {console.log()})
    })
  }

  openSongDetail(songId: number) {
    this.router.navigate(['/']);
  }
}
