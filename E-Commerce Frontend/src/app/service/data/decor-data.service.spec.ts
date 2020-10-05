import { TestBed } from '@angular/core/testing';

import { DecorDataService } from './decor-data.service';

describe('DecorDataService', () => {
  let service: DecorDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DecorDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
