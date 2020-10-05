import { TestBed } from '@angular/core/testing';

import { MobileDataService } from './mobile-data.service';

describe('MobileDataService', () => {
  let service: MobileDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MobileDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
