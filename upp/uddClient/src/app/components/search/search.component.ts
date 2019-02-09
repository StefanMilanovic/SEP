import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {SearchService} from '../../services/search.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {


  formTitleMagazine = new FormGroup({
    field: new FormControl('magazineTitle', Validators.compose ([Validators.required])),
    value: new FormControl('', Validators.compose ([Validators.required])),
  });


  constructor( @Inject(FormBuilder) formBuilder: FormBuilder,private router: Router, private searchService: SearchService) {

  }

  ngOnInit() {
  }


  serachMagazineTitle(formTitleMagazine){
    console.log( " pocni pretragu formTitleMagazine za : " + formTitleMagazine.field + " : " + formTitleMagazine.value );

    this.searchService.serachMagazineTitle(formTitleMagazine).subscribe( (retVal: any) => {
      console.log('Povratna vrenost searc Magazin title' + retVal);

       // window.location.href = 'http://localhost:4300/search';

    });
  }

}
