import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TodoListComponent } from './components/issues-list/issues-list.component';
import { TodoItemComponent } from './components/issues/issues-item.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { EditModalComponent } from './components/edit-modal/edit-modal.component';
import { FormsModule } from '@angular/forms';
import { LoadingLottieComponent } from './components/loading-lottie/loading-lottie.component';
import { LottieModule } from 'ngx-lottie';
import player from 'lottie-web';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { AddModalComponent } from './components/add-modal/add-modal.component';

export function playerFactory() {
  return import(/* webpackChunkName: 'lottie-web' */ 'lottie-web');
}

@NgModule({
  declarations: [
    AppComponent,
    TodoListComponent,
    TodoItemComponent,
    EditModalComponent,
    LoadingLottieComponent,
    AddModalComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxPaginationModule,
    FormsModule,
    LottieModule.forRoot({ player: playerFactory }),
    BrowserAnimationsModule,
    MatButtonModule,
  ],
  exports: [
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
