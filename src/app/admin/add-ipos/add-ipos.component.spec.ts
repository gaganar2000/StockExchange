import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddIposComponent } from './add-ipos.component';

describe('AddIposComponent', () => {
  let component: AddIposComponent;
  let fixture: ComponentFixture<AddIposComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddIposComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddIposComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
