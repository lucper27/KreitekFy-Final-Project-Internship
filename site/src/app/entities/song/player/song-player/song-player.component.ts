import {Component, OnInit} from '@angular/core';
import {SongService} from "../../service/song.service";
import {ISong} from "../../model/song.interface";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-song-player',
  templateUrl: './song-player.component.html',
  styleUrls: ['./song-player.component.scss']
})
export class SongPlayerComponent implements OnInit {
  song?: ISong;
  songId?: string | null;
  profileName?: string | null;

  constructor(
    private songService: SongService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.profileName = this.route.snapshot.paramMap.get('profileName');
    this.songId = this.route.snapshot.paramMap.get('songId');
    if(this.songId) {
      this.loadSongById();
    }
  }

  private loadSongById() {
    this.songService.getSongById(this.songId).subscribe({
      next: (singleSong: any) => {
        this.song = singleSong;
        },
      error: err => {
        console.log(err)
      }
    })

  }
}
