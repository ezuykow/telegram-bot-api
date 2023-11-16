package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.models.requests.common.set.SetMyDefaultAdministratorRights;
import kz.pandev.legrambotapi.models.types.common.chat.ChatAdministratorRights;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class GetMyDefaultAdministratorRightsTest {

    @Test
    void getMyDefaultAdministratorRights() throws InterruptedException {
        Config.bot.execute(new SetMyDefaultAdministratorRights()
                .forChannels(false)
                .rights(new ChatAdministratorRights()
                        .canManageChat(false)
                        .canDeleteMessages(false)
                        .canManageVideoChats(false)
                        .canRestrictMembers(false)
                        .canPromoteMembers(false)
                        .canChangeInfo(false)
                        .canInviteUsers(false)
                        .canPostMessages(false)
                        .canEditMessages(false)
                        .canPinMessages(false)
                        .canManageTopics(false)
                        .canPostStories(false)
                        .canEditStories(false)
                        .canDeleteStories(false)
                ));
        ChatAdministratorRights rights = Config.bot.execute(new GetMyDefaultAdministratorRights().forChannels(false))
                .getChatAdministratorRights();
        assertFalse(rights.isAnonymous());
        assertFalse(rights.isCanManageChat());
        assertFalse(rights.isCanDeleteMessages());
        assertFalse(rights.isCanManageVideoChats());
        assertFalse(rights.isCanRestrictMembers());
        assertFalse(rights.isCanPromoteMembers());
        assertFalse(rights.isCanChangeInfo());
        assertFalse(rights.isCanInviteUsers());
        assertFalse(rights.isCanPostMessages()); // channels only
        assertFalse(rights.isCanEditMessages()); // channels only
        assertFalse(rights.isCanPinMessages());
        assertFalse(rights.isCanManageTopics());
        assertFalse(rights.isCanPostStories());
        assertFalse(rights.isCanEditStories());
        assertFalse(rights.isCanDeleteStories());
        Thread.sleep(1000);
    }

}