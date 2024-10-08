package com.sitemate.issue_tracker.util;

import com.sitemate.issue_tracker.domain.Issue;
import com.sitemate.issue_tracker.entity.IssueEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Mapper {

    public static Issue map(IssueEntity entity) {
        return new Issue()
                .setCreatedOn(entity.getCreatedOn())
                .setAssignedTo(entity.getAssignedTo())
                .setIssueDetail(entity.getIssueDetail())
                .setIssueIdentifier(entity.getIssueIdentifier())
                .setStatus(entity.getStatus());
    }

    public static IssueEntity map(Issue issue) {
        return new IssueEntity()
                .setCreatedOn(issue.getCreatedOn())
                .setAssignedTo(issue.getAssignedTo())
                .setIssueDetail(issue.getIssueDetail())
                .setIssueIdentifier(issue.getIssueIdentifier())
                .setStatus(issue.getStatus());
    }
}
