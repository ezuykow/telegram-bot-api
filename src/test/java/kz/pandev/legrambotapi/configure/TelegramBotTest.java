package kz.pandev.legrambotapi.configure;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.models.requests.common.get.GetUpdates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class TelegramBotTest {

    @Test
    void creationTests() {

        TelegramBot bot = new TelegramBot(Config.token, "https://CustomAPIServerURL");
        assertNotNull(bot);
        assertNotNull(Config.token, bot.getBotToken());
        assertEquals("https://CustomAPIServerURL/bot" + Config.token + "/", bot.getBotApiUrl());


        bot = new TelegramBot(Config.token);
        bot.setUpdatesListener(updates -> 0);
        bot.setUpdatesListener(updates -> 0, new GetUpdates());
        bot.setUpdatesListener(updates -> 0, e -> {});
        bot.removeUpdatesListener();
        bot.shutdown();
        assertNotNull(bot);
    }

    @Test
    void builderTest() {
        TelegramBot bot = new TelegramBot.Builder(Config.token)
                .apiServerUrl("https://CustomAPIServerURL")
                .updatesHandlerSleepTime(100)
                .httpClientBasicDebugMode()
                .httpClientBodyDebugMode()
                .httpClientHeadersDebugMode()
                .httpClientDisableDebugMode()
                .okHttpClient(null)
                .build();
        assertNotNull(bot);
    }

}