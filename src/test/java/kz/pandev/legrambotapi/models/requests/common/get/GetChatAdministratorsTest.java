package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.ChatMemberTest;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.common.get.GetChatAdministratorsResponse;
import kz.pandev.legrambotapi.models.types.common.chat.member.ChatMember;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class GetChatAdministratorsTest {

    @Test
    void getChatAdministrators() throws InterruptedException {
        GetChatAdministratorsResponse response = Config.bot.execute(new GetChatAdministrators(Config.testGroupId));
        for (ChatMember chatMember : response.getAdministrators()) {
            ChatMemberTest.check(chatMember);
        }

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new GetChatAdministrators(Config.testImage)));

        Thread.sleep(1000);
    }

}