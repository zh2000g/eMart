import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerMainComponent } from './seller-main.component';

describe('SellerMainComponent', () => {
  let component: SellerMainComponent;
  let fixture: ComponentFixture<SellerMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SellerMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SellerMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
