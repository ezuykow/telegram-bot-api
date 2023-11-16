package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.common.get.GetChat;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.chat.Chat;
import kz.pandev.legrambotapi.models.types.common.chat.ChatPermissions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SetChatPermissionsTest {

    @Test
    void setChatPermissions() throws InterruptedException {
        for (boolean bool : new boolean[]{false, true}) {
            ChatPermissions setPerms = new ChatPermissions();
            setPerms.canSendMessages(bool);
            setPerms.canSendAudios(bool);
            setPerms.canSendDocuments(bool);
            setPerms.canSendPhotos(bool);
            setPerms.canSendVideos(bool);
            setPerms.canSendVideoNotes(bool);
            setPerms.canSendVoiceNotes(bool);
            setPerms.canSendPolls(bool);
            setPerms.canSendOtherMessages(bool);
            setPerms.canAddWebPagePreviews(bool);
            setPerms.canChangeInfo(bool);
            setPerms.canInviteUsers(bool);
            setPerms.canPinMessages(bool);
            setPerms.canManageTopics(bool);
            Response response = Config.bot.execute(new SetChatPermissions(Config.testGroupId, setPerms)
                    .useIndependentChatPermissions(false));
            assertTrue(response.isOk());

            Chat chat = Config.bot.execute(new GetChat(Config.testGroupId)).getChat();
            ChatPermissions permissions = chat.getPermissions();
            if (bool) {
                assertTrue(permissions.getCanSendMessages());
                assertTrue(permissions.getCanSendAudios());
                assertTrue(permissions.getCanSendDocuments());
                assertTrue(permissions.getCanSendPhotos());
                assertTrue(permissions.getCanSendVideos());
                assertTrue(permissions.getCanSendVideoNotes());
                assertTrue(permissions.getCanSendVoiceNotes());
                assertTrue(permissions.getCanSendPolls());
                assertTrue(permissions.getCanSendOtherMessages());
                assertTrue(permissions.getCanAddWebPagePreviews());
                assertTrue(permissions.getCanChangeInfo());
                assertTrue(permissions.getCanInviteUsers());
                assertTrue(permissions.getCanPinMessages());
                assertTrue(permissions.getCanManageTopics());
            } else {
                assertFalse(permissions.getCanSendMessages());
                assertFalse(permissions.getCanSendAudios());
                assertFalse(permissions.getCanSendDocuments());
                assertFalse(permissions.getCanSendPhotos());
                assertFalse(permissions.getCanSendVideos());
                assertFalse(permissions.getCanSendVideoNotes());
                assertFalse(permissions.getCanSendVoiceNotes());
                assertFalse(permissions.getCanSendPolls());
                assertFalse(permissions.getCanSendOtherMessages());
                assertFalse(permissions.getCanAddWebPagePreviews());
                assertFalse(permissions.getCanChangeInfo());
                assertFalse(permissions.getCanInviteUsers());
                assertFalse(permissions.getCanPinMessages());
                assertFalse(permissions.getCanManageTopics());
            }
        }

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new SetChatPermissions(Config.testImage, new ChatPermissions())));

        Thread.sleep(1000);
    }

}