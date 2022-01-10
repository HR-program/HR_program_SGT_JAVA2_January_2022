import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchEmloyeeComponent } from './search-emloyee.component';

describe('SearchEmloyeeComponent', () => {
  let component: SearchEmloyeeComponent;
  let fixture: ComponentFixture<SearchEmloyeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchEmloyeeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchEmloyeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
