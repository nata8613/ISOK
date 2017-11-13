import { TestBed, inject } from '@angular/core/testing';

import { HomeInsuranceService } from './home-insurance.service';

describe('HomeInsuranceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HomeInsuranceService]
    });
  });

  it('should be created', inject([HomeInsuranceService], (service: HomeInsuranceService) => {
    expect(service).toBeTruthy();
  }));
});
