package com.sitemate.issue_tracker.utils;

import com.sitemate.issue_tracker.entity.IssueEntity;
import com.sitemate.issue_tracker.util.Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;

public class MapperTest {

    @Test
    public void entityToDtoMapperTest() {
        final var entity = new IssueEntity()
                .setStatus("NEW")
                .setCreatedOn(LocalDateTime.now())
                .setAssignTo(RandomStringUtils.randomAlphabetic(10))
                .setIssueDetail(RandomStringUtils.randomAlphabetic(100))
                .setIssueIdentifier(RandomStringUtils.randomAlphabetic(10));
        final var issue = Mapper.map(entity);
        Assertions.assertEquals(entity.getAssignTo(), issue.getAssignTo());
        Assertions.assertEquals(entity.getIssueDetail(), issue.getIssueDetail());
        Assertions.assertEquals(entity.getIssueIdentifier(), issue.getIssueIdentifier());
        Assertions.assertEquals(entity.getCreatedOn(), issue.getCreatedOn());
    }
}
