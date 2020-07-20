import { TestBed } from '@angular/core/testing';

import { RecentTacosService } from './recent-tacos.service';

describe('RecentTacosService', () => {
  let service: RecentTacosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecentTacosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
