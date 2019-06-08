import { Component, OnInit } from '@angular/core';
import { SciencePaperService } from '../../services/science-paper.service';
import { MagazineService } from 'src/app/services/magazine.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor(private paperService: SciencePaperService, private magazineService:MagazineService) { }

  sciencePapers: any[];
  selectedPaper: any;
  showPopUpComment = false;
  commentValue = '';

  ngOnInit() {
    this.paperService.getAllPapers("AAA").subscribe((data:any[]) => {
      console.log(data);
      this.sciencePapers = data;
    });
  }

  download(paper){
    this.magazineService.downloadPaper(paper.locationOnDrive)
  }

  deletePaper(paper){
    this.paperService.deletePaper(paper).subscribe(data => {
    });
  }

  openReworkCommentPopUp(paper){
    this.selectedPaper = paper;
    this.togglePopUpVisibility();
  }

  togglePopUpVisibility(){
    this.showPopUpComment = !this.showPopUpComment;
    this.commentValue = '';
  }

  sendComment(){
    console.log(this.commentValue);
    this.paperService.addComment(this.commentValue, this.selectedPaper.id).subscribe(data => {
      this.togglePopUpVisibility();
    });
  }

}
