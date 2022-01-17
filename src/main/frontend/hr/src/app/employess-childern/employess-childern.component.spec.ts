import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployessChildernComponent } from './employess-childern.component';

describe('EmployessChildernComponent', () => {
  let component: EmployessChildernComponent;
  let fixture: ComponentFixture<EmployessChildernComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployessChildernComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployessChildernComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
