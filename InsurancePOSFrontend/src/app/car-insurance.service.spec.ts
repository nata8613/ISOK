import { TestBed, inject } from '@angular/core/testing';

import { CarInsuranceService } from './car-insurance.service';

describe('CarInsuranceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CarInsuranceService]
    });
  });

  it('should be created', inject([CarInsuranceService], (service: CarInsuranceService) => {
    expect(service).toBeTruthy();
  }));
});
