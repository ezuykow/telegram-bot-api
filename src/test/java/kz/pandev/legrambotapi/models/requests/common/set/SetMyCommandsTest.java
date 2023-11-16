package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.bot.command.BotCommand;
import kz.pandev.legrambotapi.models.types.common.bot.command.scope.BotCommandScopeAllChatAdministrators;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.bot;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author ezuykow
 */
class SetMyCommandsTest {

    @Test
    void setMyCommands() throws InterruptedException {
        BotCommand[] commands = new BotCommand[]{
                new BotCommand("c1", "desc1"),
                new BotCommand("c2", "desc2"),
                new BotCommand("c3", "desc3"),
        };

        SetMyCommands cmds = new SetMyCommands(commands)
                .languageCode("en")
                .scope(new BotCommandScopeAllChatAdministrators());

        Response response = bot.execute(cmds);
        assertTrue(response.isOk());
    }

}