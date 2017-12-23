import { TestBed, inject } from '@angular/core/testing';

import { TravelInsuranceService } from './travel-insurance.service';

describe('TravelInsuranceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TravelInsuranceService]
    });
  });

  it('should be created', inject([TravelInsuranceService], (service: TravelInsuranceService) => {
    expect(service).toBeTruthy();
  }));
});
