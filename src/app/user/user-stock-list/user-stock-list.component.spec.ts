import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserStockListComponent } from './user-stock-list.component';

describe('UserStockListComponent', () => {
  let component: UserStockListComponent;
  let fixture: ComponentFixture<UserStockListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserStockListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserStockListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
