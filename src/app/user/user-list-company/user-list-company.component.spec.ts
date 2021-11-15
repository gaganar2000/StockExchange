import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserListCompanyComponent } from './user-list-company.component';

describe('UserListCompanyComponent', () => {
  let component: UserListCompanyComponent;
  let fixture: ComponentFixture<UserListCompanyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserListCompanyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserListCompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
