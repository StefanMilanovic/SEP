import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KriptovalutaComponent } from './kriptovaluta.component';

describe('KriptovalutaComponent', () => {
  let component: KriptovalutaComponent;
  let fixture: ComponentFixture<KriptovalutaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KriptovalutaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KriptovalutaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
