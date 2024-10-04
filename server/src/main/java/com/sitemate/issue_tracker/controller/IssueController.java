package com.sitemate.issue_tracker.controller;

import com.sitemate.issue_tracker.domain.Issue;
import com.sitemate.issue_tracker.exception.IssueTrackerException;
import com.sitemate.issue_tracker.model.ResponseMessage;
import com.sitemate.issue_tracker.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    private static final String ISSUE_ADDED_SUCCESSFULLY="Issue Added Successfully";
    private static final String ISSUE_EDITED_SUCCESSFULLY="Issue Edited Successfully";
    private static final String ISSUE_DELETED_SUCCESSFULLY="Issue Deleted Successfully";
    private static final String ISSUE_FOUND = "Issue Found Successfully";

    @PostMapping
    public ResponseMessage add(@RequestBody Issue issue) {
        try {
            return ResponseMessage.builder()
                    .isSuccess(true)
                    .response(issueService.add(issue))
                    .successMsg(ISSUE_ADDED_SUCCESSFULLY)
                    .build();
        } catch (IssueTrackerException e) {
            return ResponseMessage.builder().isSuccess(false).errMsg(e.getMessage()).build();
        }
    }

    @GetMapping
    public ResponseMessage findAll() {
        try {
            return ResponseMessage.builder()
                    .isSuccess(true)
                    .response(issueService.findAll())
                    .successMsg(ISSUE_FOUND)
                    .build();
        } catch (IssueTrackerException e) {
            return ResponseMessage.builder().isSuccess(false).errMsg(e.getMessage()).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseMessage find(@PathVariable String id) {
        try {
            return ResponseMessage.builder()
                    .isSuccess(true)
                    .response(issueService.find(id))
                    .successMsg(ISSUE_FOUND)
                    .build();
        } catch (IssueTrackerException e) {
            return ResponseMessage.builder().isSuccess(false).errMsg(e.getMessage()).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseMessage delete(@PathVariable String id) {
        try {
            issueService.delete(id);
            return ResponseMessage.builder()
                    .isSuccess(true)
                    .successMsg(ISSUE_DELETED_SUCCESSFULLY)
                    .build();
        } catch (IssueTrackerException e) {
            return ResponseMessage.builder().isSuccess(false).errMsg(e.getMessage()).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseMessage edit(@PathVariable String id, @RequestBody Issue issue) {
        try {
            issue.setIssueIdentifier(id);
            return ResponseMessage.builder()
                    .isSuccess(true)
                    .response(issueService.edit(issue))
                    .successMsg(ISSUE_EDITED_SUCCESSFULLY)
                    .build();
        } catch (IssueTrackerException e) {
            return ResponseMessage.builder().isSuccess(false).errMsg(e.getMessage()).build();
        }
    }
}
