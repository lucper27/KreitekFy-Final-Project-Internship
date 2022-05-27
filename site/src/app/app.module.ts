import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { SongListComponent } from './entities/song/song-list/song-list.component';
import { AuthComponent } from './entities/auth/auth.component';

import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HttpRequestIntercept} from "./config/interceptors/http-request-interceptor.inteceptor";


@NgModule({
  declarations: [
    AppComponent,
    SongListComponent,
    AuthComponent
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
