package com.sitemate.issue_tracker.service;

import com.sitemate.issue_tracker.domain.Issue;

import java.util.List;

public interface IssueService {
    Issue add(Issue issue);
    Issue edit(Issue issue);
    List<Issue> findAll();
    Issue find(String id);
    void delete(String id);
}
