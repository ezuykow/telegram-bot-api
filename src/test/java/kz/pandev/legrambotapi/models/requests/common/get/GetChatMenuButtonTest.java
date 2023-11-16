package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.models.requests.common.set.SetChatMenuButton;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.common.get.GetChatMenuButtonResponse;
import kz.pandev.legrambotapi.models.types.common.menu.MenuButton;
import kz.pandev.legrambotapi.models.types.common.menu.MenuButtonCommands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class GetChatMenuButtonTest {

    @Test
    void getChatMenuButton() throws InterruptedException {
        MenuButton menu = new MenuButtonCommands();
        Response set = Config.bot.execute(new SetChatMenuButton().chatId(Config.personalChatId)
                .menuButton(menu));
        assertTrue(set.isOk());

        GetChatMenuButtonResponse response = Config.bot.execute(new GetChatMenuButton().chatId(Config.personalChatId));
        assertTrue(response.isOk());
        assertEquals(menu.getType(), response.getMenuButton().getType());
        Thread.sleep(1000);
    }

}