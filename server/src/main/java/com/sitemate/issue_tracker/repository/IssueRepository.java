package com.sitemate.issue_tracker.repository;

import com.sitemate.issue_tracker.entity.IssueEntity;
import com.sitemate.issue_tracker.exception.IssueTrackerException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class IssueRepository {
    private static final Map<String, IssueEntity> issueEntityMap = new HashMap<>();

    public IssueRepository() {
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
        } while(i < 501);
    }

    public Optional<IssueEntity> findByIssueIdentifier(String issueIdentifier) {
        final var item = issueEntityMap.get(issueIdentifier);
        if (item != null) {
            return Optional.of(item);
        } else {
            throw new IssueTrackerException("Entity not found!");
        }
    }

    public void save(IssueEntity issue) {
        issueEntityMap.put(issue.getIssueIdentifier(), issue);
    }

    public IssueEntity update(IssueEntity issue) {
        final var item = issueEntityMap.get(issue.getIssueIdentifier());
        if (item != null) {
            item
                    .setIssueDetail(issue.getIssueDetail())
                    .setAssignTo(issue.getAssignTo())
                    .setStatus(issue.getStatus());
            return item;
        } else {
            throw new IssueTrackerException("Entity not found!");
        }
    }

    public List<IssueEntity> findAll() {
        return new ArrayList<>(issueEntityMap.values());
    }

    public void delete(IssueEntity issue) {
        issueEntityMap.remove(issue.getIssueIdentifier());
    }
}
