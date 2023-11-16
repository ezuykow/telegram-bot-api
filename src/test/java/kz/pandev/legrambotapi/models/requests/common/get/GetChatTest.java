package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.ChatTest;
import kz.pandev.legrambotapi.additional.test.classes.MessageTest;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.types.common.chat.Chat;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class GetChatTest {

    @Test
    void getChat() throws MalformedURLException, URISyntaxException, InterruptedException {
        Chat chat = Config.bot.execute(new GetChat(Config.testGroupId)).getChat();
        ChatTest.checkChat(chat, true);
        assertEquals(Chat.Type.SUPERGROUP, chat.getType());
        assertTrue(chat.getTitle().contains("LegramBotApiTest"));
        assertTrue(chat.getDescription().contains("desc"));
        assertEquals(10, chat.getSlowModeDelay());
        assertNotNull(new URL(chat.getInviteLink()).toURI());
        if (chat.getPinnedMessage() != null) MessageTest.checkMessage(chat.getPinnedMessage());
        assertNull(chat.getStickerSetName());
        assertNull(chat.getCanSetStickerSet());
        assertNull(chat.getLinkedChatId());
        assertNull(chat.getJoinByRequest());
        assertNull(chat.getHasProtectedContent());
        assertNull(chat.getMessageAutoDeleteTime());
        assertTrue(chat.getIsForum());
        assertNull(chat.getHasRestrictedVoiceAndVideoMessages());
        assertNull(chat.getHasHiddenMembers());
        assertNull(chat.getHasAggressiveAntiSpamEnabled());
        assertNull(chat.getActiveUsernames());
        assertNull(chat.getEmojiStatusCustomEmojiId());
        assertNull(chat.getEmojiStatusExpirationDate());

        chat = Config.bot.execute(new GetChat(Config.personalChatId)).getChat();
        assertNotNull(chat.getFirstName());
        assertNull(chat.getLastName());
        assertNull(chat.getBio());
        assertTrue(chat.getHasPrivateForwards());

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new GetChat(Config.testImage)));

        Thread.sleep(1000);
    }

}