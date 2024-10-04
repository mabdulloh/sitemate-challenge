package com.sitemate.issue_tracker.repository;

import com.sitemate.issue_tracker.entity.IssueEntity;

import java.util.List;
import java.util.Optional;

public interface IssueRepository {
    void save(IssueEntity issue);
    IssueEntity update(IssueEntity issue);
    List<IssueEntity> findAll();
    void delete(IssueEntity issue);
    Optional<IssueEntity> findByIssueIdentifier (String issueIdentifier);
}
