import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeinsformComponent } from './homeinsform.component';

describe('HomeinsformComponent', () => {
  let component: HomeinsformComponent;
  let fixture: ComponentFixture<HomeinsformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeinsformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeinsformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
