import {Component, OnInit} from '@angular/core';
import {SongService} from "../../service/song.service";
import {IRate, ISong} from "../../model/song.interface";
import {ActivatedRoute} from "@angular/router";
import {SongPlayerService} from "../../service/song-player.service";

@Component({
  selector: 'app-song-player',
  templateUrl: './song-player.component.html',
  styleUrls: ['./song-player.component.scss']
})
export class SongPlayerComponent implements OnInit {
  song?: ISong;
  songId?: number;
  profileId?: number;
  rating?: number;

  constructor(
    private songService: SongService,
    private route: ActivatedRoute,
    private songPlayerService: SongPlayerService
  ) { }

  ngOnInit(): void {
    this.profileId = +this.route.snapshot.paramMap.get('profileId')!;
    this.songId = +this.route.snapshot.paramMap.get('songId')!;
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

  rateSong() {
    const rate: IRate = {
      profileId: this.profileId!,
      songId: this.songId!,
      rating: this.rating!

    }
    this.songPlayerService.addRateSong(rate).subscribe({
      next: (data: any) => console.log(data),
      error: err => console.log(err)
    });
  }
}
