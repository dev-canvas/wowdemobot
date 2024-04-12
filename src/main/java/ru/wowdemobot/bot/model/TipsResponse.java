package ru.wowdemobot.bot.model;

import lombok.Data;

@Data
public class TipsResponse {

    private String category;
    private String subcategory;
    private String title;
    private String content;
    private String keywords;
}
