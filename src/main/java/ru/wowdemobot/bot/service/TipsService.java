package ru.wowdemobot.bot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.wowdemobot.bot.entity.Tips;
import ru.wowdemobot.bot.mapper.TipsMapper;
import ru.wowdemobot.bot.model.TipsRequest;
import ru.wowdemobot.bot.model.TipsResponse;
import ru.wowdemobot.bot.repository.TipsRepository;

@Service
@RequiredArgsConstructor
public class TipsService {
    private final TipsRepository tipsRepository;
    private final TipsMapper tipsMapper;

    public void createNewTip(TipsRequest tipsRequest) {
        var newTip = new Tips()
                .setCategory(tipsRequest.getCategory())
                .setContent(tipsRequest.getContent())
                .setKeywords(tipsRequest.getKeywords())
                .setTitle(tipsRequest.getTitle());

        tipsRepository.save(newTip);
    }

    public TipsResponse getRandomTip (String category) {
        var randomByCategory = tipsRepository.findRandomByCategory(category)
                .orElseThrow(() -> new RuntimeException("No tip"));
        return tipsMapper.tipsToTipsResponse(randomByCategory);
    }
}
