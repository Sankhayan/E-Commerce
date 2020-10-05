import { TestBed } from '@angular/core/testing';

import { WomenDataService } from './women-data.service';

describe('WomenDataService', () => {
  let service: WomenDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WomenDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
