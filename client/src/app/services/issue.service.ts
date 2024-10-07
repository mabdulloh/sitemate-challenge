import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Issue } from '../models/Issue';
import { Observable } from 'rxjs';

const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': 'http://localhost:4200',
    })
}

@Injectable({
    providedIn: 'root'
})

export class IssueService {
    baseUrl = "http://localhost:8080";
    constructor(private http: HttpClient) { }

    getIssues(): Observable<Issue[]> {
        return this.http.get<Issue[]>(`${this.baseUrl}` + "/issues");
    }

    editIssue(issue: Issue): Observable<Issue> {
        const url = `${this.baseUrl}/issues/${issue.issueIdentifier}`;
        console.log(issue);
        return this.http.put<Issue>(url, issue, httpOptions);
    }

    deleteIssue(issue: Issue): Observable<void> {
        const url = `${this.baseUrl}/issues/${issue.issueIdentifier}`;
        console.log(issue);
        return this.http.delete<void>(url, httpOptions);
    }

    addIssue(issue: Issue): Observable<Issue> {
        return this.http.post<Issue>(`${this.baseUrl} + /issues`, issue);
    }
}