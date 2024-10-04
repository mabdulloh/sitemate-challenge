package com.sitemate.issue_tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class IssueEntity {
    private String id;

    private String issueIdentifier;

    private String issueDetail;

    private String assignTo;

    private LocalDateTime createdOn;

    private String status;
}
