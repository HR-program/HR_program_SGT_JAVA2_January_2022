import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActiveEmployeesListComponent } from './active-employees-list.component';

describe('ActiveEmployeesListComponent', () => {
  let component: ActiveEmployeesListComponent;
  let fixture: ComponentFixture<ActiveEmployeesListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActiveEmployeesListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActiveEmployeesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
