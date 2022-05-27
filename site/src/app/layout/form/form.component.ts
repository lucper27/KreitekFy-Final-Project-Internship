import {Component, Input, OnInit} from '@angular/core';
import {ISong} from "../../entities/song/model/song.interface";
import {IArtist} from "../../shared/interfaces/artist.interface";
import {IAlbum} from "../../shared/interfaces/album.interface";
import {IStyle} from "../../shared/interfaces/style.interface";
import {ArtistService} from "../../shared/services/artist.service";
import {AlbumService} from "../../shared/services/album.service";
import {StyleService} from "../../shared/services/style.service";
import {SongService} from "../../entities/song/service/song.service";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {
  @Input() songId?: string;
  @Input() isEditable = false;
  song: ISong = {
    name: '',
    duration: 0,
    artistName: '',
    albumName: '',
    styleName: '',
  }

  selectedArtist?: IArtist;
  artists: IArtist[] = [];
  selectedAlbum?: IAlbum;
  albums: IAlbum[] = [];
  selectedStyle?: IStyle;
  styles: IStyle[] = [];

  constructor(private artistService: ArtistService,
              private albumService: AlbumService,
              private styleService: StyleService,
              private songService: SongService) { }

  ngOnInit(): void {
   if (this.isEditable) {
    this.songService.getSongById(this.songId).subscribe({
      next: singleSong => {this.song = singleSong},
      error: err => {console.log(err)}
    })
   }
  }

  getAllArtist($event: any) {
    let artistSearch: string | undefined;
    if ($event?.query) {
      artistSearch = $event.query;
    }
    this.artistService.getAllArtists(artistSearch).subscribe({
      next: artistsFiltered => {
        this.artists = artistsFiltered;
      },
      error: err => {console.log(err)}
    })
  }

  artistSelected() {
    this.song!.artistId = this.selectedArtist!.artistId;
    this.song!.artistName = this.selectedArtist!.artistName;
  }

  getAllAlbums($event: any) {
   let albumSearch: string | undefined;
    if ($event?.query) {
      albumSearch = $event.query;
    }
    this.albumService.getAllAlbums(albumSearch).subscribe({
      next: albumFiltered => {
        this.albums = albumFiltered;
      },
      error: err => {console.log(err)}
    })
  }

  albumSelected() {
    this.song!.albumId = this.selectedAlbum!.albumId;
    this.song!.albumName = this.selectedAlbum!.albumName;
  }

  syleSelected() {
    this.song!.styleId = this.selectedStyle!.styleId;
    this.song!.styleName = this.selectedStyle!.styleName;
  }

  getAllStyles($event: any) {
    let styleSearch: string | undefined;
    if ($event?.query) {
      styleSearch = $event.query;
    }
    this.styleService.getAllStyles(styleSearch).subscribe({
      next: stylesFiltered => {
        this.styles = stylesFiltered;
      },
      error: err => {console.log(err)}
    })
  }

  saveSong() {
    if (!this.isEditable) {
      this.saveNewSong();
    }
    if (this.isEditable) {
      this.editCurrentSong();
    }
  }

  private saveNewSong() {
    this.songService.insertSong(this.song).subscribe({
      next: (newSong => {console.log('Insertado correctamente', newSong)}),
      error: (err => {console.log(err)})
    })
  }

  private editCurrentSong() {
    this.songService.updateSong(this.song).subscribe({
      next: (updatedSong => {console.log('Insertado correctamente', updatedSong)}),
      error: (err => {console.log(err)})
    })
  }
}
