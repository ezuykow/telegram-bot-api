package kz.pandev.legrambotapi.models.requests.chat.invite.link;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.StringResponse;
import kz.pandev.legrambotapi.models.responses.chat.invite.link.ChatInviteLinkResponse;
import kz.pandev.legrambotapi.models.types.common.chat.ChatInviteLink;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class ChatInviteLinkTest {

    @Test
    void inviteLinks() throws InterruptedException {
        int memberLimit = 2;
        int expireDate = (int) (System.currentTimeMillis() / 1000) + 500;
        String name = "TestName";

        assertThrows(WrongParameterTypeException.class, () -> Config.bot.execute(new CreateChatInviteLink(null)));

        ChatInviteLinkResponse response = Config.bot.execute(new CreateChatInviteLink(Config.testGroupId)
                .expireDate(expireDate)
                .memberLimit(memberLimit)
                .name(name));
        ChatInviteLink link = response.getChatInviteLink();
        assertEquals(expireDate, link.getExpireDate());
        assertEquals(memberLimit, link.getMemberLimit());
        assertFalse(link.getIsRevoked());
        assertTrue(link.getCreator().getIsBot());
        assertEquals(name, link.getName());

        int editMemberLimit = 3;
        int editExpireDate = (int) (System.currentTimeMillis() / 1000) + 1500;
        String editName = name + "edit";
        response = Config.bot.execute(new EditChatInviteLink(Config.testGroupId, link.getInviteLink())
                .expireDate(editExpireDate)
                .memberLimit(editMemberLimit)
                .name(editName));
        link = response.getChatInviteLink();
        assertEquals(editExpireDate, link.getExpireDate());
        assertEquals(editMemberLimit, link.getMemberLimit());
        assertEquals(editName, link.getName());
        assertFalse(link.getIsRevoked());

        response = Config.bot.execute(new RevokeChatInviteLink(Config.testGroupId, link.getInviteLink()));
        link = response.getChatInviteLink();
        assertTrue(link.getIsRevoked());
        assertFalse(link.getIsPrimary());

        response = Config.bot.execute(new CreateChatInviteLink(Config.testGroupId).createsJoinRequest(true));
        link = response.getChatInviteLink();
        assertTrue(link.isCreatesJoinRequest());
        assertNull(link.getPendingJoinRequestCount());

        response = Config.bot.execute(new EditChatInviteLink(Config.testGroupId, link.getInviteLink())
                .createsJoinRequest(false));
        assertFalse(response.getChatInviteLink().isCreatesJoinRequest());

        StringResponse resp = Config.bot.execute(new ExportChatInviteLink(Config.testGroupId));
        assertTrue(resp.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new EditChatInviteLink(Config.testImage, "")));
        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new ExportChatInviteLink(Config.testImage)));
        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new RevokeChatInviteLink(Config.testImage, "")));

        Thread.sleep(1000);
    }

    @Test
    void exportChatInviteLink() throws InterruptedException {
        StringResponse response = Config.bot.execute(new ExportChatInviteLink(Config.testGroupId));
        assertTrue(response.isOk());
        assertNotNull(response.getResult());
        Thread.sleep(1000);
    }
}