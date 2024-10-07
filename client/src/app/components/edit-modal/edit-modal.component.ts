import { Issue } from 'src/app/models/Issue';
import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-edit-modal',
  templateUrl: './edit-modal.component.html',
  styleUrls: ['./edit-modal.component.scss']
})
export class EditModalComponent implements OnInit {

  @Input() issue?: Issue;
  @Output() saveChangesEvent: EventEmitter<Issue> = new EventEmitter();
  @Output() closeModalEvent: EventEmitter<boolean> = new EventEmitter();
  newIssue?: Issue;
  isChecked?: boolean;
  status?: string[];
  user?: string[];


  constructor() { }

  ngOnInit(): void {
    this.newIssue = {
      ...this.issue
    }
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
    this.newIssue = {
      ...this.newIssue,
      issueIdentifier: this.issue!.issueIdentifier
    }
    this.saveChangesEvent.emit(this.newIssue);
  }

  checkValue(event: any) {
    if (event === true) {
      this.newIssue?.status === 'DONE';
    }
  }

}
