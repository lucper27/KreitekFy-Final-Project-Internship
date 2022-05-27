import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SongListComponent} from "./entities/song/song-list/song-list.component";

const routes: Routes = [
  { path: '', component: SongListComponent, pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
