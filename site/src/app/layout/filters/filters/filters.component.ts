import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ArtistService} from "../../../shared/services/artist.service";
import {AlbumService} from "../../../shared/services/album.service";
import {StyleService} from "../../../shared/services/style.service";
import {IAlbum, IArtist, ISong, IStyle} from "../../../entities/song/model/song.interface";

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.scss']
})
export class FiltersComponent implements OnInit {
  @Input() song?: ISong;

  @Output() artist: EventEmitter<IArtist> = new EventEmitter();
  @Output() album: EventEmitter<IAlbum> = new EventEmitter();
  @Output() style: EventEmitter<IStyle> = new EventEmitter();

  artists: IArtist[] = [];
  albums: IAlbum[] = [];
  styles: IStyle[] = [];

  selectedArtist?: IArtist;
  selectedAlbum?: IAlbum;
  selectedStyle?: IStyle;

  constructor(
    private artistService: ArtistService,
    private albumService: AlbumService,
    private styleService: StyleService,
  ) {
  }

  ngOnInit(): void {
    this.selectedArtist = this.song?.artist
    this.selectedAlbum = this.song?.album
    this.selectedStyle = this.song?.style
  }

  getAllArtists($event: any) {
    let artistSearch: string | undefined;
    if ($event?.query) {
      artistSearch = $event.query;
    }
    this.artistService.getAllArtists(artistSearch).subscribe({
      next: (artistsFiltered: any) => {
        this.artists = artistsFiltered;
      },
      error: err => {
        console.log(err)
      }
    })
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
      error: err => {
        console.log(err)
      }
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

  artistSelected() {
    if (this.selectedArtist) {
      this.artist.emit(this.selectedArtist);
    } else {
      this.artist.emit(undefined);
    }
  }

  albumSelected() {
    this.album.emit(this.selectedAlbum);
  }

  styleSelected() {
    this.style.emit(this.selectedStyle);
  }

}
