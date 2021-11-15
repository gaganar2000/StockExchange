import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSignoutComponent } from './admin-signout.component';

describe('AdminSignoutComponent', () => {
  let component: AdminSignoutComponent;
  let fixture: ComponentFixture<AdminSignoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminSignoutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminSignoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
