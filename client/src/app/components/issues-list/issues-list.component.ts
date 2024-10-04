import { Issue } from 'src/app/models/Issue';
import { Component, OnInit } from '@angular/core';
import { IssueService } from 'src/app/services/issue.service';


@Component({
  selector: 'app-todo-list',
  templateUrl: './issues-list.component.html',
  styleUrls: ['./issues-list.component.scss']
})
export class TodoListComponent implements OnInit {
  p: number = 1;
  order: boolean | undefined = undefined; // Initialize status as undefined
  issues!: Issue[];
  

  constructor(
    private issueService: IssueService
  ) { }

  ngOnInit(): void {

      this.issueService.getIssues().subscribe(res => {
        this.issues = res;
      })
  }

  sortAscending(issues: Issue[]) {
      issues.sort((a,b) => (a.issueIdentifier === b.issueIdentifier) ? 0 : a.issueIdentifier? 1 : -1)
  }

  sortDescending(issues: Issue[]) {
    issues.sort((a,b) => (a.issueIdentifier === b.issueIdentifier) ? 0 : a.issueIdentifier? -1 : 1)
  }

  // control order status and sort todos array according to its value
  setStatus () {
    if(this.order === false || undefined){
      this.order = true;
      this.sortAscending(this.issues)
    } else {
      this.order = false;
      this.sortDescending(this.issues);
    }  
  }

  updateIssue(issue: Issue) {
    const index = this.issues.findIndex((i) => i.issueIdentifier === issue.issueIdentifier);
    this.issues[index] = {
      ...issue
    };

    // Sort updated todos if necessary (order !== undefined)
    this.order === true ? this.sortAscending(this.issues) : this.order === false ? this.sortDescending(this.issues) : '';
  }

  deleteIssue(issue: Issue) {
    this.issues = this.issues.filter(item => item.issueIdentifier !== issue.issueIdentifier);
    this.issueService
  }

}
