import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { QuizContainerComponent } from './quiz-container/quiz-container.component';
import { TableComponent } from './table/table.component';
import { ButtonComponent } from './button/button.component';
import { CircleComponent } from './circle/circle.component';
import { Table2Component } from './table2/table2.component';
import { SvgComponent } from './svg/svg.component';

@NgModule({
  declarations: [
    AppComponent,
    QuizContainerComponent,
    TableComponent,
    ButtonComponent,
    CircleComponent,
    Table2Component,
    SvgComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
