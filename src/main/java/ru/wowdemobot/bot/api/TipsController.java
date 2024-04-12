package ru.wowdemobot.bot.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.wowdemobot.bot.model.TipsRequest;
import ru.wowdemobot.bot.model.TipsResponse;
import ru.wowdemobot.bot.service.TipsService;

@RestController
@RequiredArgsConstructor
public class TipsController {

    private final TipsService tipsService;

    @PostMapping
    public void createNewTip(@RequestBody TipsRequest tipsRequest) {
        tipsService.createNewTip(tipsRequest);}

    @GetMapping ("random")
    public TipsResponse getRandomTip (@RequestParam ("category") String category) {
        return tipsService.getRandomTip (category);
    }

    @GetMapping
    public String healthCheck () {
        return "OK";}
}
