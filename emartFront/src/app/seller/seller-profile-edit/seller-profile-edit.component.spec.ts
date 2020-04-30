import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerProfileEditComponent } from './seller-profile-edit.component';

describe('SellerProfileEditComponent', () => {
  let component: SellerProfileEditComponent;
  let fixture: ComponentFixture<SellerProfileEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SellerProfileEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SellerProfileEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
