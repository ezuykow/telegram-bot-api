package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.ChatMemberTest;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.types.common.chat.member.ChatMember;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class GetChatMemberTest {

    @Test
    void getChatMember() throws InterruptedException {
        ChatMember chatMember = Config.bot.execute(new GetChatMember(Config.testGroupId, Config.testBotId))
                .getChatMember();
        ChatMemberTest.check(chatMember);
        assertEquals(ChatMember.MemberStatus.ADMINISTRATOR, chatMember.getStatus());
        assertNull(chatMember.getUntilDate());
        assertNull(chatMember.getCanPostMessages());
        assertNull(chatMember.getCanEditMessages());
        assertNull(chatMember.getIsMember());
        assertTrue(chatMember.getCanChangeInfo());
        assertTrue(chatMember.getCanInviteUsers());
        assertTrue(chatMember.getCanPinMessages());
        assertNull(chatMember.getCanSendPolls());
        assertNull(chatMember.getCanSendMessages());
        assertNull(chatMember.getCanSendAudios());
        assertNull(chatMember.getCanSendDocuments());
        assertNull(chatMember.getCanSendPhotos());
        assertNull(chatMember.getCanSendVideos());
        assertNull(chatMember.getCanSendVideoNotes());
        assertNull(chatMember.getCanSendVoiceNotes());
        assertNull(chatMember.getCanSendOtherMessages());
        assertNull(chatMember.getCanAddWebPagePreviews());
        assertTrue(chatMember.getCanManageTopics());

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new GetChatMember(Config.testImage, Config.testBotId)));
        Thread.sleep(1000);
    }

}