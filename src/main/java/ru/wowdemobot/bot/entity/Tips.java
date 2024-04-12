package ru.wowdemobot.bot.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors (chain = true)
public class Tips extends BaseEntity {

    private String category;
    private String subcategory;
    private String title;
    private String content;
    private String keywords;

   }
