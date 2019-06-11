import { Component, OnInit } from '@angular/core';
import { SciencePaperService } from '../../services/science-paper.service';
import { MagazineService } from 'src/app/services/magazine.service';
import { HttpResponse, HttpEventType } from '@angular/common/http';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ReviewData } from 'src/app/entities/ReviewData';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor(private paperService: SciencePaperService, private magazineService:MagazineService, private authService: AuthenticationService) { }

  sciencePapers: any[];
  sciencePapersMainEditor = [];
  sciencePapersUser = [];

  selectedPaper: any;
  secondEditorSiencePapers = []
  showPopUpComment = false;
  commentValue = '';
  loggedUser: any;
  reviewers = [];
  optionReviewer: string;
  selectedReviewers = [];
  reviewerSciencePapers = [];
  reviewOption ='Accept';

  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };

  ngOnInit() {
    this.loggedUser = this.authService.getUserFromService();
    console.log(this.loggedUser);

    this.paperService.getAllPapers("AAA").subscribe((data:any[]) => {
      this.sciencePapers = data;
      console.log("PAPER DATA JE");
      console.log(this.sciencePapers);
      for(let paper of this.sciencePapers){
        if(paper.status=='editor' && paper.editor == this.loggedUser.id){
          this.sciencePapersMainEditor.push(paper);
          console.log("Pozz iz for-a");
        }
        if(paper.status=='small_mistake' || paper.status=='wrong_formatting'){
          this.sciencePapersUser.push(paper);
        }

        if(paper.status=='small_mistake_resolve' || paper.status=='sec_editor_rev' || paper.status == 'sec_editor_decide' && paper.editor == this.loggedUser.id){
          this.secondEditorSiencePapers.push(paper);

        }
        if(paper.status=='reviewers_looking'){
          for(let comment of paper.comments){
            if(comment.user == this.loggedUser.id && !comment.finished){
              this.reviewerSciencePapers.push(paper);
            }
          }
        }
      }
    });
  }

  download(paper){
    this.magazineService.downloadPaper(paper.locationOnDrive);
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

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  uploadPaper(paper){
    this.progress.percentage = 0;
    this.currentFileUpload = this.selectedFiles.item(0);

    this.paperService.updateSciencePaper(this.currentFileUpload, paper).subscribe((event:any) => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
    });
    this.selectedFiles = undefined;
  }

  sendComment(){
    this.paperService.addComment(this.commentValue, this.selectedPaper.id).subscribe(data => {
      this.togglePopUpVisibility();
    });
  }

  approve(paper){
    this.paperService.approveByMainEditor(paper).subscribe(data => {});
  }

  openChoseReviewersPopUp(paper){
    this.selectedPaper = paper;
    this.paperService.findReviewers(paper.scienceMagazine).subscribe( (data: any) => {
      this.reviewers = data;
      this.optionReviewer = this.reviewers[0].username;
    });
    this.togglePopUpVisibility();
  }

  addReviewer(){
    for(let reviewer of this.selectedReviewers){
      if(reviewer.username == this.optionReviewer) return;
    }
    for(let reviewer of this.reviewers){
       if(reviewer.username == this.optionReviewer){
         this.selectedReviewers.push(reviewer);
       }
    }
  }

  removeReviewer(reviewer){
    this.selectedReviewers = this.selectedReviewers.filter(function(rev, index, arr){
      return rev.username!=reviewer.username;
    });
  }

  confirmReviewers(){
    this.paperService.setReviewers(this.selectedReviewers, this.selectedPaper.id).subscribe(data =>{

    });
  }

  openAddReviewersPopUp(paper){
    this.selectedPaper = paper;
    this.togglePopUpVisibility();
  }

  sendReview(){
    let reviewData = new ReviewData();
    reviewData.textContent = this.commentValue;
    reviewData.recommendation = this.reviewOption;

    this.paperService.addReview(reviewData, this.selectedPaper.id).subscribe(data =>{
      console.log("Review added");
    });
  }

  editorDecision(sciencePaper1, decision){

    this.paperService.editorDecision( sciencePaper1, decision).subscribe(data =>{
      console.log("Decision");
    });
  }

  editorDecisionSmallMistake(sciencePaper1, decision){

    this.paperService.editorDecisionSmallMistake( sciencePaper1, decision).subscribe(data =>{
      console.log("Small Miastke Decision");
    });
  }
}
