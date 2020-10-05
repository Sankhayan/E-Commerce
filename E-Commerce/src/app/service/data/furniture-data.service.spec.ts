import { TestBed } from '@angular/core/testing';

import { FurnitureDataService } from './furniture-data.service';

describe('FurnitureDataService', () => {
  let service: FurnitureDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FurnitureDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
