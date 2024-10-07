import { Issue } from 'src/app/models/Issue';
import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-add-modal',
  templateUrl: './add-modal.component.html',
  styleUrls: ['./add-modal.component.scss']
})
export class AddModalComponent implements OnInit {
  @Output() saveChangesEvent: EventEmitter<Issue> = new EventEmitter();
  @Output() closeModalEvent: EventEmitter<boolean> = new EventEmitter();
  newIssue?: Issue;
  isChecked?: boolean;
  status?: string[];
  user?: string[];


  constructor() { }

  ngOnInit(): void {
    this.newIssue = new Issue();
    this.status = [
      "NEW",
      "IN_PROGRESS",
      "DONE",
    ];
    this.user = [
      "Delores Duncan",
      "Darrick Bullock",
      "Millicent Dickerson",
      "Fausto Kemp",
      "Kathie Avery",
      "Lucinda Huynh",
      "Nita Jacobson",
      "Petra Orozco"
    ];
  }

  closeModal(close: boolean) {
    close = false;
    this.closeModalEvent.emit(close);
  }

  saveChanges() {
    console.log(this.newIssue);
    this.saveChangesEvent.emit(this.newIssue);
  }

  checkValue(event: any) {
    if (event === true) {
      this.newIssue?.status === 'DONE';
    }
  }

}
