import { TestBed } from '@angular/core/testing';

import { MenDataService } from './men-data.service';

describe('MenDataService', () => {
  let service: MenDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MenDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
