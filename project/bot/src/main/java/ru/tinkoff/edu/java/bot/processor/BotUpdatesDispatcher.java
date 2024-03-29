package ru.tinkoff.edu.java.bot.processor;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.List;

public class BotUpdatesDispatcher implements UpdatesListener {
    private static final String MESSAGE = "I don't have this command. Use /help to see all my commands";

    private final TelegramBot bot;

    private final CommandProcessor commandProcessor;

    private final Counter numberOfProcessedMessages;

    public BotUpdatesDispatcher(
        TelegramBot bot,
        CommandProcessor commandProcessor,
        MeterRegistry meterRegistry
    ) {
        this.bot = bot;
        this.commandProcessor = commandProcessor;
        this.numberOfProcessedMessages = meterRegistry.counter("number_of_processed_messages"); }

    @Override
    public int process(List<Update> updates) {
        int lastProcessedId = CONFIRMED_UPDATES_NONE;

        for (Update update : updates) {
            if (update.message() == null) {
                continue;
            }

            try {
                bot.execute(commandProcessor.process(update).orElse(unexpectedMessage(update)));

                numberOfProcessedMessages.increment();

                lastProcessedId = update.updateId();
            } catch (RuntimeException ex) {

                return lastProcessedId;
            }
        }

        return CONFIRMED_UPDATES_ALL;
    }

    private SendMessage unexpectedMessage(Update update) {
        return new SendMessage(update.message().chat().id(), MESSAGE);
    }

    public List<BotCommand> getCommands() {
        return commandProcessor.getCommands();
    }
}
