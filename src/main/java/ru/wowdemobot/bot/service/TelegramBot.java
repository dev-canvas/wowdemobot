package ru.wowdemobot.bot.service;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScope;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.wowdemobot.bot.config.properties.BotProperties;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {



    private final BotProperties botProperties;
    private final MessageService messageService;

    public TelegramBot(BotProperties botProperties, MessageService messageService) {
        this.botProperties = botProperties;
        this.messageService = messageService;

        List<BotCommand> listOfCommands = new ArrayList<>();
        listOfCommands.add(new BotCommand("/start", "Начни"));
        listOfCommands.add(new BotCommand("/stop", "Пока!"));
        listOfCommands.add(new BotCommand("/random", "Дай совет по Java!"));
        try {
            this.execute(new SetMyCommands(listOfCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }
    @Override
    public String getBotUsername() {
        return botProperties.name();
    }

    @Override
    public String getBotToken() {
        return botProperties.token();
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            SendMessage sendMessage = messageService.messageReceiver(update);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("При ответе пользователю возникла проблема");
        }
    }
}
