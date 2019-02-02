import { TestBed } from '@angular/core/testing';

import { ProveraServiceService } from './provera-service.service';

describe('ProveraServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProveraServiceService = TestBed.get(ProveraServiceService);
    expect(service).toBeTruthy();
  });
});
