package ru.tinkoff.edu.java.bot.botprocessor.messagesender;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;
import ru.tinkoff.edu.java.bot.dto.LinkResponse;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class MessageSenderTest {
    static Configuration templateResolver;
    MessageSender messageSender = new MessageSender(templateResolver);


    @BeforeAll
    @SneakyThrows
    static void setUp() {
        templateResolver = new Configuration(Configuration.VERSION_2_3_31);

        File templatesDir = new File(MessageSender.class
                .getClassLoader()
                .getResource("templates")
                .getFile()
        );
        log.info(MessageSender.class
                .getClassLoader()
                .getResource("templates")
                .getFile());


        templateResolver.setDefaultEncoding("UTF-8");
        templateResolver.setDirectoryForTemplateLoading(templatesDir);
        //templateResolver.setDefaultEncoding("UTF-8");
    }


    @Test
    void sendTemplate__sendLinksTemplate_returnValidTemplate(){
        //given
        Update update = getUpdate();

        List<LinkResponse> links = List.of(
                new LinkResponse(1L, URI.create("https://github.com/")),
                new LinkResponse(2L, URI.create("https://stackoverflow.com/"))
        );

        //when
        SendMessage message = messageSender.sendTemplate(update, "links.ftl", Map.of("links", links));

        //then
        Object text = message.getParameters().get("text");

//        assertThat(text).isEqualTo("""
//                <b>Your links:</b>
//                %s
//
//
//                """
//                .formatted(links
//                        .stream()
//                        .map(link -> "<a href=\"%s\">%s</a>".formatted(link.url(), link.url()))
//                        .collect(Collectors.joining("\n"))
//                )
//        );
        assertThat(text).isEqualTo("""
              <b>Your links:</b>
                  <a href="https://github.com/">https://github.com/</a>
                  <a href="https://stackoverflow.com/">https://stackoverflow.com/</a>
              """);


    }

    Update getUpdate(){
        //Update -> Message -> Chat -> Id
        Update update = new Update();
        Message message = new Message();
        Chat chat = new Chat();

        ReflectionTestUtils.setField(chat, "id", 123L);
        ReflectionTestUtils.setField(message, "chat", chat);
        ReflectionTestUtils.setField(update, "message", message);
        return update;
    }
}
