import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateIposComponent } from './update-ipos.component';

describe('UpdateIposComponent', () => {
  let component: UpdateIposComponent;
  let fixture: ComponentFixture<UpdateIposComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateIposComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateIposComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
