import {Component, Inject, Input, OnInit} from '@angular/core';
import {IAlbum, IArtist, ISong, IStyle} from "../../entities/song/model/song.interface";
import {ArtistService} from "../../shared/services/artist.service";
import {AlbumService} from "../../shared/services/album.service";
import {StyleService} from "../../shared/services/style.service";
import {SongService} from "../../entities/song/service/song.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {
  @Input() songId?: number;

  song: ISong = {
    name: '',
    duration: 0,
    artist: {
      name: '',
      id: 0
    },
    album: {
      title: '',
      id: 0
    },
    style: {
      name: '',
      id: 0
    },
  }
  selectedArtist: IArtist = {
  name: '',
    id: 0
};

  artists: IArtist[] = [];
  selectedAlbum?: IAlbum;
  albums: IAlbum[] = [];
  selectedStyle: IStyle = {
    name: '',
    id: 0
  };

  styles: IStyle[] = [];

  constructor(
    private artistService: ArtistService,
    private albumService: AlbumService,
    private styleService: StyleService,
    private songService: SongService,
    public modalRef: MatDialogRef<FormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: number
  ) { }

  ngOnInit(): void {
    if(this.data) {
      this.songId = this.data;
      this.loadSongById();
    }
  }

  getAllArtist($event: any) {
    let artistSearch: string | undefined;
    if ($event?.query) {
      artistSearch = $event.query;
    }
    this.artistService.getAllArtists(artistSearch).subscribe({
      next: (artistsFiltered: any) => {
        this.artists = artistsFiltered;
      },
      error: err => {console.log(err)}
    })
  }

  artistSelected() {
    this.song!.artist.id = this.selectedArtist!.id;
    console.log(this.song.artist.id);
    this.song!.artist.name = this.selectedArtist!.name;
  }

  getAllAlbums($event: any) {
   let albumSearch: string | undefined;
    if ($event?.query) {
      albumSearch = $event.query;
    }
    this.albumService.getAllAlbums(albumSearch).subscribe({
      next: (albumFiltered: any) => {
        this.albums = albumFiltered;
      },
      error: err => {console.log(err)}
    })
  }

  albumSelected() {
    this.song!.album.id = this.selectedAlbum!.id;
    this.song!.album.title = this.selectedAlbum!.title;
  }

  styleSelected() {
    this.song!.style.id = this.selectedStyle!.id;
    this.song!.style.name = this.selectedStyle!.name;
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
      error: err => {console.log(err)}
    })
  }

  saveSong() {
    if (!this.songId) {
      this.saveNewSong();
    }
    if (this.songId) {
      this.editCurrentSong();
    }
    console.log(this.song);
  }

  private saveNewSong() {
    const newSong: ISong = {
      name: this.song.name,
      duration: this.song.duration,
      album: {
        id: this.song.album.id
      },
      style: {
        id: this.song.style.id
      },
      artist: {
        id: this.song.artist.id
      },
      inclusionDate: new Date()
    }

    this.songService.insertSong(newSong).subscribe({
      next: (newSong => {}),
      error: (err => {console.log(err)})
    })
    this.modalRef.close()
  }

  private editCurrentSong() {
    this.songService.updateSong(this.song).subscribe({
      next: (updatedSong => {}),
      error: (err => {console.log(err)})
    })

    this.modalRef.close()
  }

  private loadSongById() {
    this.songService.getSongById(this.songId).subscribe({
      next: (singleSong: any) => {this.song = singleSong;
        console.log(singleSong);
        this.selectedAlbum = this.song.album;
        this.selectedStyle = this.song.style;
        this.selectedArtist = this.song.artist},
      error: err => {console.log(err)}
    })

  }
}
