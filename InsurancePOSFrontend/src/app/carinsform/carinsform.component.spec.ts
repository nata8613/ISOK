import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarinsformComponent } from './carinsform.component';

describe('CarinsformComponent', () => {
  let component: CarinsformComponent;
  let fixture: ComponentFixture<CarinsformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarinsformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarinsformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
