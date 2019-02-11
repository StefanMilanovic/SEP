import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {SearchService} from '../../services/search.service';
import {Router} from '@angular/router';
import {AdvancedQuery} from '../../entities/AdvancedQuery';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {


  private allSciPaper: any[];
  private advancedQuery = new AdvancedQuery();
  private queryType = "AND";

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

  formKeywords  = new FormGroup({
    field: new FormControl('keywords', Validators.compose ([Validators.required])),
    value: new FormControl('', Validators.compose ([Validators.required])),
  });

  formScientificField = new FormGroup({
    field: new FormControl('scientificField', Validators.compose ([Validators.required])),
    value: new FormControl('', Validators.compose ([Validators.required])),
  });

  formContent  = new FormGroup({
    field: new FormControl('text', Validators.compose ([Validators.required])),
    value: new FormControl('', Validators.compose ([Validators.required])),
  });

  constructor(private router: Router, private searchService: SearchService) {

  }

  ngOnInit() {
  }


  serachMagazineTitle(formTitleMagazine){
    console.log( " pocni pretragu formTitleMagazine za : " + formTitleMagazine.field + " : " + formTitleMagazine.value );

    this.searchService.serachAutor(formTitleMagazine).subscribe( (retVal: any) => {
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
  serachAuthor(formAuthor){
    console.log( " pocni pretragu formAuthor za : " + formAuthor.field + " : " + formAuthor.value );

    this.searchService.serachAutor(formAuthor).subscribe( (retVal: any) => {
      if(retVal == null){
        console.log("Nema rezultata pretrage");
        this.allSciPaper = null;
      }else {
        console.log('Povratna vrenost ' + retVal[0].title);
        this.allSciPaper = retVal;
        // window.location.href = 'http://localhost:4300/search';
      }

    });
  }
  serachKeywords(formKeywords){
    console.log( " pocni pretragu formKeywords za : " + formKeywords.field + " : " + formKeywords.value );

    this.searchService.serachKeywords(formKeywords).subscribe( (retVal: any) => {
      if(retVal == null){
        console.log("Nema rezultata pretrage");
        this.allSciPaper = null;
      }else {
        console.log('Povratna vrenost ' + retVal[0].title);
        this.allSciPaper = retVal;
        // window.location.href = 'http://localhost:4300/search';
      }

    });
  }

  serachScientificField(formScientificField){
    console.log( " pocni pretragu formScientificField za : " + formScientificField.field + " : " + formScientificField.value );

    this.searchService.serachScientificField(formScientificField).subscribe( (retVal: any) => {
      if(retVal == null){
        console.log("Nema rezultata pretrage");
        this.allSciPaper = null;
      }else {
        console.log('Povratna vrenost ' + retVal[0].title);
        this.allSciPaper = retVal;
        // window.location.href = 'http://localhost:4300/search';
      }

    });
  }
  serachContent(formContent){
    console.log( " pocni pretragu formContent za : " + formContent.field + " : " + formContent.value );

    this.searchService.serachContent(formContent).subscribe( (retVal: any) => {
      if(retVal == null){
        console.log("Nema rezultata pretrage");
        this.allSciPaper = null;
      }else {
        console.log('Povratna vrenost ' + retVal[0].title);
        this.allSciPaper = retVal;
        // window.location.href = 'http://localhost:4300/search';
      }

    });
  }

  advancedSearchRadioChange(event){
    if(event.target.id == "andQuery"){
      this.queryType = "AND";
      console.log(this.queryType);
    }
    else {
      this.queryType = "OR";      
      console.log(this.queryType);
    }    
  }

  advacnedSearch(){
    this.advancedQuery.field1 = this.formTitleMagazine.get('field').value;
    this.advancedQuery.value1 = this.formTitleMagazine.get('value').value;

    this.advancedQuery.field2 = this.formTitle.get('field').value;
    this.advancedQuery.value2 = this.formTitle.get('value').value;

    this.advancedQuery.field3 = this.formAuthor.get('field').value;
    this.advancedQuery.value3 = this.formAuthor.get('value').value;

    this.advancedQuery.field4 = this.formKeywords.get('field').value;
    this.advancedQuery.value4 = this.formKeywords.get('value').value;

    this.advancedQuery.field5 = this.formScientificField.get('field').value;
    this.advancedQuery.value5 = this.formScientificField.get('value').value;

    this.advancedQuery.field6 = this.formContent.get('field').value;
    this.advancedQuery.value6 = this.formContent.get('value').value;

    this.advancedQuery.operation = this.queryType;
    // console.log(this.advancedQuery.field1);
    // console.log(this.advancedQuery.value1); /search/combination

    this.searchService.searchCombination(this.advancedQuery).subscribe((retVal: any) =>{
      if(retVal == null){
        console.log("Nema rezultata pretrage");
        this.allSciPaper = null;
      }else {
        console.log(retVal);
        this.allSciPaper = retVal;       
      }
    });
  }
}
