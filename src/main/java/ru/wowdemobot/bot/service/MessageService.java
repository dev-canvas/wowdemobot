package ru.wowdemobot.bot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageService {

    public SendMessage messageReceiver(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            String name = update.getMessage().getChat().getFirstName();

            String responseText;
            switch (text) {
                case "/start" -> responseText = String.format("Добро пожаловать, %s! Вы великолепны!", name);
                case "/stop" ->
                        responseText = String.format("Всего доброго, %s! Возвращайтесь, такие спецы нам нужны!", name);
                default ->
                        responseText = "К сожалению, я еще маленький и не знаю такую команду! Введите /start или /stop";
            }

            var message = new SendMessage();
            message.setChatId(chatId);
            message.setText(responseText);
            return message;
        }

        return null;

    }
}
