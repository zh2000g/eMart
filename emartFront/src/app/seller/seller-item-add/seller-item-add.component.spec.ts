import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerItemAddComponent } from './seller-item-add.component';

describe('SellerItemAddComponent', () => {
  let component: SellerItemAddComponent;
  let fixture: ComponentFixture<SellerItemAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SellerItemAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SellerItemAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
