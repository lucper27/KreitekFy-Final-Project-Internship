import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SongPlayerListComponent } from './entities/song/player/song-player-list/song-player-list.component';
import { AuthComponent } from './entities/auth/auth.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HttpRequestIntercept} from "./config/interceptors/http-request-interceptor.inteceptor";
import { NavbarComponent } from './layout/navbar/navbar.component';
import { FooterComponent } from './layout/footer/footer.component';
import { SongAdminListComponent } from './entities/song/admin/song-admin-list/song-admin-list.component';
import { SongCardComponent } from './entities/song/song-card/song-card.component';


@NgModule({
  declarations: [
    AppComponent,
    SongPlayerListComponent,
    AuthComponent,
    NavbarComponent,
    FooterComponent,
    SongAdminListComponent,
    SongCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpRequestIntercept,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
