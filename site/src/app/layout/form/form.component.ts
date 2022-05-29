import {Component, Inject, Input, OnInit} from '@angular/core';
import {IAlbum, IArtist, ISong, IStyle} from "../../entities/song/model/song.interface";
import {SongService} from "../../entities/song/service/song.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ImageconverterService} from "../../shared/utils/imageconverter.service";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {
  @Input() songId?: number;
  song!: ISong;

  album?: IAlbum;
  style?: IStyle;
  artist?: IArtist;



  constructor(
    private songService: SongService,
    public modalRef: MatDialogRef<FormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: number,
    private imageConverter: ImageconverterService
  ) { }

  ngOnInit(): void {
    if(this.data) {
      this.songId = this.data;
      this.loadSongById();
    }
  }

  saveSong() {
    if (!this.songId) {
      this.createSong();
    }
    if (this.songId) {
      this.editSong();
    }
  }

  selectImage($event: any): void {
    this.imageConverter.includeImageInItem($event).then(
      res => {
        this.song.image = res![1];
      });
  }

  getArtist(artist: IArtist) {
    this.song.artist.id = artist.id;
    console.log(artist);
  }

  getStyle(style: IStyle) {
    this.song.style.id = style.id
  }

  getAlbum(album: IAlbum) {
    this.song.album.id = album.id
  }

  private createSong() {
    const newSong: ISong = {
      name: this.song.name,
      duration: this.song.duration,
      image: this.song.image,
      album: {
        id: this.album!.id
      },
      style: {
        id: this.style!.id
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

  private editSong() {
    this.songService.updateSong(this.song).subscribe({
      next: (updatedSong => {}),
      error: (err => {console.log(err)})
    })

    this.modalRef.close()
  }

  private loadSongById() {
    this.songService.getSongById(this.songId).subscribe({
      next: (singleSong: any) => {
        this.song = singleSong;
        this.album = this.song.album;
        this.style = this.song.style;
        this.artist = this.song.artist},
      error: err => {console.log(err)}
    })
  }


}
