import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelinsformComponent } from './travelinsform.component';

describe('TravelinsformComponent', () => {
  let component: TravelinsformComponent;
  let fixture: ComponentFixture<TravelinsformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TravelinsformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TravelinsformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
