import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PorukaUspesnostiComponent } from './poruka-uspesnosti.component';

describe('PorukaUspesnostiComponent', () => {
  let component: PorukaUspesnostiComponent;
  let fixture: ComponentFixture<PorukaUspesnostiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PorukaUspesnostiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PorukaUspesnostiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
