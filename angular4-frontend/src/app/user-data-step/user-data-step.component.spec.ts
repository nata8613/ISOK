import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserDataStepComponent } from './user-data-step.component';

describe('UserDataStepComponent', () => {
  let component: UserDataStepComponent;
  let fixture: ComponentFixture<UserDataStepComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserDataStepComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserDataStepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
