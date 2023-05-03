package ru.tinkoff.edu.java.scrapper.service.jdbc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.tinkoff.edu.java.parser.Parser;
import ru.tinkoff.edu.java.parser.parseresult.ParseResult;
import ru.tinkoff.edu.java.scrapper.client.api.GitHubClient;
import ru.tinkoff.edu.java.scrapper.client.api.StackOverflowClient;
import ru.tinkoff.edu.java.scrapper.client.dto.GitHubApiResponse;
import ru.tinkoff.edu.java.scrapper.client.dto.StackOverflowApiResponse;
import ru.tinkoff.edu.java.scrapper.entity.Link;
import ru.tinkoff.edu.java.scrapper.repository.jdbc.JdbcLinkRepository;
import ru.tinkoff.edu.java.scrapper.repository.jdbc.JdbcSubscriptionRepository;
import ru.tinkoff.edu.java.scrapper.service.LinksUpdater;
import ru.tinkoff.edu.java.scrapper.service.notifier.BotNotifier;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class JdbcLinksUpdaterImpl implements LinksUpdater {

    private final GitHubClient gitHubClient;
    private final StackOverflowClient stackOverflowClient;
    private final JdbcLinkRepository linkRepository;
    private final JdbcSubscriptionRepository subscriptionRepository;
    private final Parser linkParser;
    private final BotNotifier botNotifier;


    @Override
    public void updateLinks(int limit) {
        List<Link> links = linkRepository.findCheckedLongTimeAgoLinks(limit);

        for (Link link : links) {
            link.setLastCheckTime(OffsetDateTime.now());

            ParseResult parseResult = linkParser.parse(link.getUrl());
            if (parseResult == null) {
                throw new RuntimeException("Can't parse this link");
            }
            if (parseResult instanceof ParseResult.GitHubUserRepository gitHubUserRepository) {
                checkGitHub(gitHubUserRepository, link);
            } else if (parseResult instanceof ParseResult.StackOverflowQuestionId stackOverflowQuestionId) {
                checkStackOverflow(stackOverflowQuestionId, link);
            } else {
                throw new RuntimeException("Link" + link.getUrl() + "can't be parsed");
            }

            linkRepository.update(link);

        }
    }


    private void checkGitHub(ParseResult.GitHubUserRepository gitHubUserRepository, Link link) {
        GitHubApiResponse gitHubResponse = gitHubClient
                .fetchRepository(gitHubUserRepository.userName(), gitHubUserRepository.repository());

        checkGitHubUpdates(gitHubResponse, link);
    }

    private void checkStackOverflow(ParseResult.StackOverflowQuestionId stackOverflowQuestionId, Link link) {
        StackOverflowApiResponse stackOverflowApiResponse = stackOverflowClient
                .fetchQuestion(stackOverflowQuestionId.questionId());

        checkStackOverflowUpdates(stackOverflowApiResponse, link);
    }


    private void checkGitHubUpdates(GitHubApiResponse response, Link link) {
        OffsetDateTime updatedAt = response.updatedAt();
        Integer issuesCount = response.openIssuesCount();

        boolean sameUpdatesCount = Objects.equals(link.getUpdatesCount(), issuesCount);

        if (link.getUpdatedAt() == null) {
            link.setUpdatedAt(updatedAt);
            link.setUpdatesCount(issuesCount);
        } else if (!Objects.equals(link.getUpdatedAt(), updatedAt) || !sameUpdatesCount) {
            link.setUpdatedAt(updatedAt);
            String description;
            if (!sameUpdatesCount) {
                description = "There's a new open issue!";
                link.setUpdatesCount(issuesCount);
            } else {
                description = "Something new!";
            }

            botNotifier.notifyBot(
                    link,
                    description,
                    subscriptionRepository.findChatsByLinkId(link.getId())
            );
        }
    }


    private void checkStackOverflowUpdates(StackOverflowApiResponse response, Link link) {
        OffsetDateTime updatedAt = response.items().get(0).lastActivityDate();
        Integer answerCount = response.items().get(0).answerCount();

        boolean sameUpdatesCount = Objects.equals(link.getUpdatesCount(), answerCount);

        if (!Objects.equals(link.getUpdatedAt(), updatedAt) || !sameUpdatesCount) {
            link.setUpdatedAt(updatedAt);

            String description;

            if (!sameUpdatesCount) {
                description = "There's new answer!";
                link.setUpdatesCount(answerCount);
            } else {
                description = "Something new!";
            }

            botNotifier.notifyBot(
                    link,
                    description,
                    subscriptionRepository.findChatsByLinkId(link.getId())
            );

        }
    }

}
