import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthComponent } from './entities/auth/auth.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HttpRequestIntercept} from "./config/interceptors/http-request-interceptor.inteceptor";
import { NavbarComponent } from './layout/navbar/navbar.component';
import { FooterComponent } from './layout/footer/footer.component';
import {FormComponent} from "./layout/form/form.component";
import {SongAdminListComponent} from "./entities/song/admin/song-admin-list/song-admin-list.component";
import {FormsModule} from "@angular/forms";
import {AutoCompleteModule} from "primeng/autocomplete";
import {InputTextModule} from "primeng/inputtext";
import {SongCardComponent} from "./entities/song/song-card/song-card.component";
import {SongPlayerListComponent} from "./entities/song/player/song-player-list/song-player-list.component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatDialogModule} from "@angular/material/dialog";
import { FiltersComponent } from './layout/filters/filters/filters.component';
import { SongPlayerComponent } from './entities/song/player/song-player/song-player.component';
import {RatingModule} from "primeng/rating";


@NgModule({
  declarations: [
    AppComponent,
    SongAdminListComponent,
    AuthComponent,
    NavbarComponent,
    FooterComponent,
    FormComponent,
    SongCardComponent,
    SongPlayerListComponent,
    FiltersComponent,
    SongPlayerComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        AutoCompleteModule,
        FormsModule,
        InputTextModule,
        BrowserAnimationsModule,
        MatDialogModule,
        RatingModule
    ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpRequestIntercept,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
