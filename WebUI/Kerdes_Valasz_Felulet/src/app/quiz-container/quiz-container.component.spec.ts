import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizContainerComponent } from './quiz-container.component';

describe('QuizContainerComponent', () => {
  let component: QuizContainerComponent;
  let fixture: ComponentFixture<QuizContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuizContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuizContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
