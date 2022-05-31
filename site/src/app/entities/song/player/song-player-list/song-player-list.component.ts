import { Component, OnInit } from '@angular/core';
import {ISong, IStyle} from "../../model/song.interface";
import {SongPlayerService} from '../../service/song-player.service';
import {ActivatedRoute} from "@angular/router";
import {StyleService} from "../../../../shared/services/style.service";

@Component({
  selector: 'app-song-player-list',
  templateUrl: './song-player-list.component.html',
  styleUrls: ['./song-player-list.component.scss']
})
export class SongPlayerListComponent implements OnInit {
  profileName?: string | null;
  songList: ISong[] = [];
  songListRated: ISong[] = [];

  selectedStyle?: IStyle;
  styles: IStyle[] = [];

  constructor(
    private songPlayerService: SongPlayerService,
    private route: ActivatedRoute,
    private styleService: StyleService
  ) { }

  ngOnInit(): void {
    this.profileName = this.route.snapshot.paramMap.get('profileName');
    this.getAllNewSongs();
    this.getAllRatedSongs();
  }

  private getAllNewSongs(styleId?: number) {
    this.songPlayerService.getAllNewSongs(styleId).subscribe({
      next: ((allNewSongs: any) => {this.songList = allNewSongs
        console.log(allNewSongs)
      }),
      error:((err: any) => {console.log()})
    })
  }

  private getAllRatedSongs(styleId?: number){
    this.songPlayerService.getAllRatedSongs(styleId).subscribe({
      next: ((allRatedSongs: any) => {this.songListRated = allRatedSongs
        console.log(allRatedSongs)
      }),
      error:((err: any) => {console.log()})
    })
  }


  getAllStyles($event: any) {
    let styleSearch: string | undefined;
    if ($event?.query) {
      styleSearch = $event.query;
    }
    this.styleService.getAllStyles(styleSearch).subscribe({
      next: (stylesFiltered: any) => {
        this.styles = stylesFiltered;
      },
      error: err => {
        console.log(err)
      }
    })
  }

  styleSelected() {
    this.getAllNewSongs(this.selectedStyle?.id);
    this.getAllRatedSongs(this.selectedStyle?.id)
  }

  onClear() {
    this.getAllNewSongs();
    this.getAllRatedSongs();
  }
}
