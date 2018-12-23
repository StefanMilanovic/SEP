import { TestBed } from '@angular/core/testing';

import { PlacanjeService } from './placanje.service';

describe('PlacanjeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PlacanjeService = TestBed.get(PlacanjeService);
    expect(service).toBeTruthy();
  });
});
