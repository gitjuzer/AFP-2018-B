import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-quiz-container',
  templateUrl: './quiz-container.component.html',
  styleUrls: ['./quiz-container.component.scss']
})
export class QuizContainerComponent implements OnInit {

  @ViewChild('nameField')
  private nameField: ElementRef<HTMLInputElement>;

  visible: boolean;

  answers: any;

  constructor() { }

  ngOnInit() {
    this.answers = [
                   [/*'1. válasz', '2. válasz', '3. válasz', '4. válasz'*/],
                   [/*'1. válasz', '2. válasz', '3. válasz', '4. válasz'*/]
                   ];
    this.visible = false;
  }
}
