import { UserService } from './user.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { QuizContainerComponent } from './quiz-container/quiz-container.component';
import { TableComponent } from './table/table.component';
import { ButtonComponent } from './button/button.component';
import { CircleComponent } from './circle/circle.component';
import { Table2Component } from './table2/table2.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    QuizContainerComponent,
    TableComponent,
    ButtonComponent,
    CircleComponent,
    Table2Component,
    LoginComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
