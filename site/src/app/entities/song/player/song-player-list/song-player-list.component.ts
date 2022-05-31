import { Component, OnInit } from '@angular/core';
import {ISong} from "../../model/song.interface";
import {SongPlayerService} from '../../service/song-player.service';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-song-player-list',
  templateUrl: './song-player-list.component.html',
  styleUrls: ['./song-player-list.component.scss']
})
export class SongPlayerListComponent implements OnInit {
  profileName?: string | null;
  songList: ISong[] = [];

  constructor(
    private songPlayerService: SongPlayerService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.profileName = this.route.snapshot.paramMap.get('profileName');
    this.getAllNewSongs();
  }

  private getAllNewSongs() {
    this.songPlayerService.getAllNewSongs().subscribe({
      next: ((allNewSongs: any) => {this.songList = allNewSongs
        console.log(allNewSongs)
      }),
      error:((err: any) => {console.log()})
    })
  }


}
