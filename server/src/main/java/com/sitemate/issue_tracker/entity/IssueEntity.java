package com.sitemate.issue_tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class IssueEntity {
    private int id;

    private String issueIdentifier;

    private String issueDetail;

    private String assignedTo;

    private LocalDateTime createdOn;

    private String status;
}
