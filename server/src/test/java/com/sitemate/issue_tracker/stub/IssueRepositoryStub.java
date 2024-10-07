package com.sitemate.issue_tracker.stub;

import com.sitemate.issue_tracker.entity.IssueEntity;
import com.sitemate.issue_tracker.exception.IssueTrackerException;
import com.sitemate.issue_tracker.repository.IssueRepository;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.util.*;

public class IssueRepositoryStub implements IssueRepository {
    private static final Map<String, IssueEntity> issueEntityMap = new HashMap<>();

    public IssueRepositoryStub() {
        int i = 1;
        do {
            var identifier = "CONTOSO-" + i;
            IssueEntity issue = new IssueEntity()
                    .setIssueIdentifier(identifier)
                    .setIssueDetail(RandomStringUtils.randomAlphabetic(30))
                    .setStatus("NEW")
                    .setCreatedOn(LocalDateTime.now());
            issueEntityMap.put(identifier, issue);
            i++;
        } while (i < 51);
    }

    @Override
    public void save(IssueEntity issue) {
        issueEntityMap.put(issue.getIssueIdentifier(), issue);
    }

    @Override
    public IssueEntity update(IssueEntity issue) {
        final var item = issueEntityMap.get(issue.getIssueIdentifier());
        if (item != null) {
            item
                    .setIssueDetail(issue.getIssueDetail())
                    .setAssignedTo(issue.getAssignedTo())
                    .setStatus(issue.getStatus());
            return item;
        } else {
            throw new IssueTrackerException("Entity not found!");
        }
    }

    @Override
    public List<IssueEntity> findAll() {
        return new ArrayList<>(issueEntityMap.values());
    }

    @Override
    public void delete(IssueEntity issue) {
        issueEntityMap.remove(issue.getIssueIdentifier());
    }

    @Override
    public Optional<IssueEntity> findByIssueIdentifier(String issueIdentifier) {
        final var item = issueEntityMap.get(issueIdentifier);
        if (item != null) {
            return Optional.of(item);
        } else {
            throw new IssueTrackerException("Entity not found!");
        }
    }
}
