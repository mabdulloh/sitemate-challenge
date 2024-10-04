import { IssueService } from 'src/app/services/issue.service';
import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Issue } from 'src/app/models/Issue';


@Component({
  selector: 'app-todo-item',
  templateUrl: './issues-item.component.html',
  styleUrls: ['./issues-item.component.scss']
})
export class TodoItemComponent implements OnInit {

  modal: boolean = false;

  @Input() issue!: Issue;
  @Output() updateIssue: EventEmitter<Issue> = new EventEmitter();
  @Output() deleteIssue: EventEmitter<Issue> = new EventEmitter();

  constructor(
    private issueService: IssueService
  ) { }

  ngOnInit(): void {
  }

  onControlModal() {
    this.modal = !this.modal;
  }

  onDelete(issue: Issue) {
    this.deleteIssue.emit(issue);
  }

  saveChanges($event:Issue) {
    this.issueService.editIssue($event).subscribe(data => {
        this.issue = data;
        this.updateIssue.emit(this.issue);
        this.onControlModal();
    },
    error => {
      console.log("Error",error);
    });
    
  }

  closeModal($event: boolean) {
    this.modal = $event;
  }

}
