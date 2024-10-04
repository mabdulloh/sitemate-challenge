package com.sitemate.issue_tracker.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {
    private boolean isSuccess;
    private Object response;
    private String errMsg;
    private String errDetail;
    private String successMsg;
}
