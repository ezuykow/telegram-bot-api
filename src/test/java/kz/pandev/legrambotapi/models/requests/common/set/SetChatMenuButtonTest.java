package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.menu.MenuButtonCommands;
import kz.pandev.legrambotapi.models.types.common.menu.MenuButtonDefault;
import kz.pandev.legrambotapi.models.types.common.menu.MenuButtonWebApp;
import kz.pandev.legrambotapi.models.types.common.web.app.WebAppInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SetChatMenuButtonTest {

    @Test
    void setChatMenuButton() throws InterruptedException {
        Response response = Config.bot.execute(new SetChatMenuButton().chatId(Config.personalChatId)
                .menuButton(new MenuButtonDefault()));
        assertTrue(response.isOk());

        response = Config.bot.execute(new SetChatMenuButton().chatId(Config.personalChatId)
                .menuButton(new MenuButtonCommands()));
        assertTrue(response.isOk());

        response = Config.bot.execute(new SetChatMenuButton().chatId(Config.personalChatId)
                .menuButton(new MenuButtonWebApp("webapp", new WebAppInfo("https://core.telegram.org"))));
        assertTrue(response.isOk());
        Thread.sleep(1000);
    }

}