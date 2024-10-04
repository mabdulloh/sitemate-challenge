package com.sitemate.issue_tracker.service;

import com.sitemate.issue_tracker.stub.IssueRepositoryStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class IssueTrackerServiceTest {
    private InMemoryIssueService issueService;
    private final IssueRepositoryStub issueRepositoryStub = new IssueRepositoryStub();

    @BeforeEach
    public void setUp() {
        issueService = new InMemoryIssueService(issueRepositoryStub);
    }

    @Test
    public void findAllTest() {
        final var result = issueService.findAll();

        Assertions.assertEquals(50, result.size());
    }

    @Test
    public void deleteTest() {
        final var identifier = "CONTOSO-40";
        issueService.delete(identifier);
        final var result = issueService.findAll();
        Assertions.assertEquals(49, result.size());
    }

    @Test
    public void findByIdentifierTest() {
        final var identifier = "CONTOSO-40";
        final var result = issueService.find(identifier);
        Assertions.assertEquals(identifier, result.getIssueIdentifier());
    }
}
