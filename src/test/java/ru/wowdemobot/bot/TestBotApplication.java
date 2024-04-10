package ru.wowdemobot.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestBotApplication {

	public static void main(String[] args) {
		SpringApplication.from(BotApplication::main).with(TestBotApplication.class).run(args);
	}

}
