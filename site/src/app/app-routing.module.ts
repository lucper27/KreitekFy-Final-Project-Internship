import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthComponent} from "./entities/auth/auth.component";
import {SongPlayerListComponent} from "./entities/song/player/song-player-list/song-player-list.component";
import {SongAdminListComponent} from "./entities/song/admin/song-admin-list/song-admin-list.component";
import {SongPlayerComponent} from "./entities/song/player/song-player/song-player.component";

const routes: Routes = [
  { path: '', component: AuthComponent, pathMatch: 'full' },
  { path: 'admin', component: SongAdminListComponent },
  { path: 'profile/:profileId', component: SongPlayerListComponent },
  { path: 'profile/:profileId/songs/:songId', component: SongPlayerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
