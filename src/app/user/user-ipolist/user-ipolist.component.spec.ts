import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserIPOListComponent } from './user-ipolist.component';

describe('UserIPOListComponent', () => {
  let component: UserIPOListComponent;
  let fixture: ComponentFixture<UserIPOListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserIPOListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserIPOListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
