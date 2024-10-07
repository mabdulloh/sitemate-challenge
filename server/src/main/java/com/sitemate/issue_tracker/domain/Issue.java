package com.sitemate.issue_tracker.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class Issue {

    private String issueIdentifier;

    private String issueDetail;

    private String assignedTo;

    private LocalDateTime createdOn;

    private String status;
}
