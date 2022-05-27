import { Component, OnInit } from '@angular/core';
import {Profile} from "./model/song.model";
import {SongService} from "../song/service/song.service";
import {ProfileService} from "./service/profile.service";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {

  profiles: Profile[] = [];

  constructor(
    private profileService: ProfileService
  ) { }

  ngOnInit(): void {
    this.getProfiles();
  }


  private getProfiles() {
    this.profileService.getAllUsers().subscribe({
      next: res => {
        this.profiles = res;
        console.log(this.profiles)
      },
      error: err => { console.log(err) }
    });
  }
}
