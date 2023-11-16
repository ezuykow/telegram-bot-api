package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.ChatMemberTest;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.common.PromoteChatMember;
import kz.pandev.legrambotapi.models.requests.common.get.GetChatMember;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.chat.member.ChatMember;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SetChatAdministratorCustomTitleTest {

    @Test
    void setChatAdministratorCustomTitle() throws InterruptedException {
        Response response = Config.bot.execute(new PromoteChatMember(Config.testGroupId, Config.testAdminInGroupId)
                .canPromoteMembers(true));
        assertTrue(response.isOk());

        String customTitle = "df " + new Random().nextInt(999999);
        response = Config.bot.execute(new SetChatAdministratorCustomTitle(Config.testGroupId, Config.testAdminInGroupId,
                customTitle));
        assertTrue(response.isOk());

        ChatMember member = Config.bot.execute(new GetChatMember(Config.testGroupId, Config.testAdminInGroupId))
                .getChatMember();
        ChatMemberTest.check(member);
        assertEquals(customTitle, member.getCustomTitle());
        assertFalse(member.getIsAnonymous());

        assertThrows(WrongParameterTypeException.class, () -> Config.bot.execute(
                new SetChatAdministratorCustomTitle(Config.testImage, Config.testAdminInGroupId, customTitle)));

        Thread.sleep(1000);
    }

}