import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpcijePlacanjaComponent } from './opcije-placanja.component';

describe('OpcijePlacanjaComponent', () => {
  let component: OpcijePlacanjaComponent;
  let fixture: ComponentFixture<OpcijePlacanjaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpcijePlacanjaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpcijePlacanjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
