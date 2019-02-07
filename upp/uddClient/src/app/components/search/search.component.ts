import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  private form: FormGroup;

  constructor( @Inject(FormBuilder) formBuilder: FormBuilder) {

    this.form = formBuilder.group({
      magazineTitle: new FormControl('',[Validators.required]),

    });
  }

  ngOnInit() {
  }

}
