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


  private allSciPaper: any[];

  formTitleMagazine = new FormGroup({
    field: new FormControl('nameMagazine', Validators.compose ([Validators.required])),
    value: new FormControl('', Validators.compose ([Validators.required])),
  });

  formTitle = new FormGroup({
    field: new FormControl('title', Validators.compose ([Validators.required])),
    value: new FormControl('', Validators.compose ([Validators.required])),
  });
  formAuthor = new FormGroup({
    field: new FormControl('author', Validators.compose ([Validators.required])),
    value: new FormControl('', Validators.compose ([Validators.required])),
  });

  constructor(private router: Router, private searchService: SearchService) {

  }

  ngOnInit() {
  }


  serachMagazineTitle(formAuthor){
    console.log( " pocni pretragu formAuthor za : " + formAuthor.field + " : " + formAuthor.value );

    this.searchService.serachAutor(formAuthor).subscribe( (retVal: any) => {
      if(retVal == null){
        console.log("Nema rezultata pretrage");
        this.allSciPaper = null;
      }else {
      console.log('Povratna vrenost searc Magazin title' + retVal[0].title);
      this.allSciPaper = retVal;
       // window.location.href = 'http://localhost:4300/search';
      }

    });
  }

  serachTitle(formTitle){
    console.log( " pocni pretragu serachTitle za : " + formTitle.field + " : " + formTitle.value );

    this.searchService.serachTitle(formTitle).subscribe( (retVal: any) => {
      if(retVal == null){
        console.log("Nema rezultata pretrage");
        this.allSciPaper = null;
      }else {
        console.log('Povratna vrenost search  title' + retVal[0].title);
        this.allSciPaper = retVal;
        // window.location.href = 'http://localhost:4300/search';
      }

    });
  }
  serachAuthor(formTitle){
    console.log( " pocni pretragu serachTitle za : " + formTitle.field + " : " + formTitle.value );

    this.searchService.serachTitle(formTitle).subscribe( (retVal: any) => {
      if(retVal == null){
        console.log("Nema rezultata pretrage");
        this.allSciPaper = null;
      }else {
        console.log('Povratna vrenost search  title' + retVal[0].title);
        this.allSciPaper = retVal;
        // window.location.href = 'http://localhost:4300/search';
      }

    });
  }
}
