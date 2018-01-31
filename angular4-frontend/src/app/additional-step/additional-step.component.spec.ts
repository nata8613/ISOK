import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdditionalStepComponent } from './additional-step.component';

describe('AdditionalStepComponent', () => {
  let component: AdditionalStepComponent;
  let fixture: ComponentFixture<AdditionalStepComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdditionalStepComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdditionalStepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
