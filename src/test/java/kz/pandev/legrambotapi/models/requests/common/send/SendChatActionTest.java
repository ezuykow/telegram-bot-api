package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.addons.SimpleMessageSender;
import kz.pandev.legrambotapi.utils.enums.ChatAction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SendChatActionTest {

    @Test
    void sendChatAction() throws InterruptedException {
        assertTrue(SimpleMessageSender.sendChatAction(Config.bot, Config.personalChatId, ChatAction.TYPING).isOk());
        assertTrue(Config.bot.execute(new SendChatAction(Config.personalChatId, ChatAction.TYPING)).isOk());
        assertTrue(Config.bot.execute(new SendChatAction(Config.personalChatId, ChatAction.UPLOAD_PHOTO)).isOk());
        assertTrue(Config.bot.execute(new SendChatAction(Config.personalChatId, ChatAction.RECORD_VIDEO)).isOk());
        assertTrue(Config.bot.execute(new SendChatAction(Config.personalChatId, ChatAction.UPLOAD_VIDEO)).isOk());
        assertTrue(Config.bot.execute(new SendChatAction(Config.personalChatId, ChatAction.RECORD_VOICE)).isOk());
        assertTrue(Config.bot.execute(new SendChatAction(Config.personalChatId, ChatAction.UPLOAD_VOICE)).isOk());
        assertTrue(Config.bot.execute(new SendChatAction(Config.personalChatId, ChatAction.UPLOAD_DOCUMENT)).isOk());
        assertTrue(Config.bot.execute(new SendChatAction(Config.personalChatId, ChatAction.FIND_LOCATION)).isOk());
        assertTrue(Config.bot.execute(new SendChatAction(Config.personalChatId, ChatAction.RECORD_VIDEO_NOTE)).isOk());
        assertTrue(Config.bot.execute(new SendChatAction(Config.personalChatId, ChatAction.UPLOAD_VIDEO_NOTE)).isOk());
        assertTrue(Config.bot.execute(new SendChatAction(Config.personalChatId, ChatAction.CHOOSE_STICKER)).isOk());
        assertTrue(Config.bot.execute(new SendChatAction(Config.testChannelName, ChatAction.CHOOSE_STICKER).messageThreadId(0)).isOk());
        assertEquals("typing", ChatAction.TYPING.getTextVal());
        Thread.sleep(1000);
    }

}