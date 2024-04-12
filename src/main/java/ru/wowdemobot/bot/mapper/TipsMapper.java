package ru.wowdemobot.bot.mapper;

import org.mapstruct.Mapper;
import ru.wowdemobot.bot.entity.Tips;
import ru.wowdemobot.bot.model.TipsResponse;

@Mapper
public interface TipsMapper {

    TipsResponse tipsToTipsResponse (Tips tips);
}
