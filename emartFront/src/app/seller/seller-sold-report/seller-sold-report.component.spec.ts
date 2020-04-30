import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerSoldReportComponent } from './seller-sold-report.component';

describe('SellerSoldReportComponent', () => {
  let component: SellerSoldReportComponent;
  let fixture: ComponentFixture<SellerSoldReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SellerSoldReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SellerSoldReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
