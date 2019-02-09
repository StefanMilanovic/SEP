import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { UploadService } from 'src/app/services/upload.service';
import { HttpResponse, HttpEventType } from '@angular/common/http';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {

  showFile = false;
  fileUploads: Observable<string[]>;
  @Input() fileUpload: string;

  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };

  title = '';
  description = '';


  formUpload = new FormGroup({
    name: new FormControl('', Validators.compose ([Validators.required])),
    keywords: new FormControl('', Validators.compose ([Validators.required])),
    abbstract: new FormControl('', Validators.compose ([Validators.required])),
  });

  constructor(private uploadService: UploadService) { }

  ngOnInit() {
  }

  showFiles(enable: boolean) {
    this.showFile = enable;

    if (enable) {
      this.fileUploads = this.uploadService.getFiles();
    }
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  upload(formUpload) {
    this.progress.percentage = 0;

    this.currentFileUpload = this.selectedFiles.item(0);
    this.uploadService.pushFileToStorage(this.currentFileUpload, formUpload).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
    });

    this.selectedFiles = undefined;
  }

}
