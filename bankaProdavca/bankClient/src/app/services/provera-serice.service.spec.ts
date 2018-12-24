import { TestBed } from '@angular/core/testing';

import { ProveraSericeService } from './provera-serice.service';

describe('ProveraSericeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProveraSericeService = TestBed.get(ProveraSericeService);
    expect(service).toBeTruthy();
  });
});
