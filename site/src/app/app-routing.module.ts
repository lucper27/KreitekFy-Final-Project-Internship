import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthComponent} from "./entities/auth/auth.component";
import {SongListComponent} from "./entities/song/song-list/song-list.component";

const routes: Routes = [
  { path: '', component: AuthComponent, pathMatch: 'full' },
  { path: 'profile/:profileName', component: SongListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
