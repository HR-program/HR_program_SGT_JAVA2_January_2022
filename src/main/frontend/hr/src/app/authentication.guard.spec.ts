import { TestBed } from '@angular/core/testing';

import { AutenthicationGuard } from './autenthication.guard';

describe('AutenthicationGuard', () => {
  let guard: AutenthicationGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AutenthicationGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
