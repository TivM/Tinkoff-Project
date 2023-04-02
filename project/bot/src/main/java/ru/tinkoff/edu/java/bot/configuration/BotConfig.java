package ru.tinkoff.edu.java.bot.configuration;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.request.SetMyCommands;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.java.bot.botprocessor.BotUpdatesDispatcher;
import ru.tinkoff.edu.java.bot.botprocessor.CommandProcessor;

@Configuration
@RequiredArgsConstructor
public class BotConfig {
    private final ApplicationConfig applicationConfig;

    @Bean
    TelegramBot telegramBot(CommandProcessor commandFacade) {
        TelegramBot bot = new TelegramBot(applicationConfig.bot().apiKey());

        var botUpdatesDispatcher = new BotUpdatesDispatcher(bot, commandFacade);
        bot.setUpdatesListener(botUpdatesDispatcher);

        bot.execute(new SetMyCommands(botUpdatesDispatcher.getCommands().toArray(new BotCommand[0])));

        return bot;
    }
}