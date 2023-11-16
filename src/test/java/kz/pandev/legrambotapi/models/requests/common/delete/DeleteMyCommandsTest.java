package kz.pandev.legrambotapi.models.requests.common.delete;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.models.requests.common.get.GetMyCommands;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.common.get.GetMyCommandsResponse;
import kz.pandev.legrambotapi.models.types.common.bot.command.scope.BotCommandScopeAllChatAdministrators;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class DeleteMyCommandsTest {

    @Test
    void deleteMyCommands() throws InterruptedException {
        DeleteMyCommands cmds = new DeleteMyCommands();
        cmds.languageCode("en");
        cmds.scope(new BotCommandScopeAllChatAdministrators());

        Response response = Config.bot.execute(cmds);
        assertTrue(response.isOk());

        Thread.sleep(1000);
    }

}