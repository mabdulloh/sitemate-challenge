package com.sitemate.issue_tracker.service;

import com.sitemate.issue_tracker.domain.Issue;
import com.sitemate.issue_tracker.exception.IssueTrackerException;
import com.sitemate.issue_tracker.repository.IssueRepository;
import com.sitemate.issue_tracker.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InMemoryIssueService implements IssueService{

    private final IssueRepository issueRepository;

    @Override
    public Issue add(Issue issue) {
        final var newIssue = Mapper.map(issue);
        issueRepository.save(newIssue);
        return Mapper.map(newIssue);
    }

    @Override
    public Issue edit(Issue issue) {
                    final var optional = issueRepository.findByIssueIdentifier(issue.getIssueIdentifier());
        if (optional.isPresent()) {
            final var entity = optional.get();
            entity.setAssignTo(issue.getAssignTo());
            entity.setIssueDetail(issue.getIssueDetail());
            issueRepository.save(entity);
            return Mapper.map(entity);
        } else {
            throw new IssueTrackerException("Issue not found!");
        }
    }

    @Override
    public List<Issue> findAll() {
        return issueRepository.findAll()
                .stream()
                .map(Mapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public Issue find(String id) {
        final var optional = issueRepository.findByIssueIdentifier(id);
        if (optional.isPresent()) {
            return Mapper.map(optional.get());
        } else {
            throw new IssueTrackerException("Issue not found!");
        }
    }

    @Override
    public void delete(String id) {
        final var optional = issueRepository.findByIssueIdentifier(id);
        if (optional.isPresent()) {
            issueRepository.delete(optional.get());
        } else {
            throw new IssueTrackerException("Issue not found!");
        }
    }
}
