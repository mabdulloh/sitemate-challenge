package com.sitemate.issue_tracker.controller;

import com.sitemate.issue_tracker.domain.Issue;
import com.sitemate.issue_tracker.exception.IssueTrackerException;
import com.sitemate.issue_tracker.model.ResponseMessage;
import com.sitemate.issue_tracker.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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
    public Issue add(@RequestBody Issue issue) {
        try {
            return issueService.add(issue);
        } catch (IssueTrackerException e) {
            throw new IssueTrackerException("Cannot add");
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(issueService.findAll());
        } catch (IssueTrackerException e) {
            throw new IssueTrackerException("Cannot find");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable String id) {
        try {
            return ResponseEntity.ok(issueService.find(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            issueService.delete(id);
            return ResponseEntity.accepted().build();
        } catch (IssueTrackerException e) {
            throw new IssueTrackerException("Cannot delete");
        }
    }

    @PutMapping("/{id}")
    public Issue edit(@PathVariable String id, @RequestBody Issue issue) {
        try {
            issue.setIssueIdentifier(id);
            return issueService.edit(issue);
        } catch (IssueTrackerException e) {
            throw new IssueTrackerException("Cannot edit");
        }
    }
}
