import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProveraComponent } from './provera.component';

describe('ProveraComponent', () => {
  let component: ProveraComponent;
  let fixture: ComponentFixture<ProveraComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProveraComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProveraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
