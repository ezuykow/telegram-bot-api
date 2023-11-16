package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.MessageTest;
import kz.pandev.legrambotapi.additional.test.classes.VoiceTest;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SendVoiceTest {

    @Test
    void sendVoice() throws InterruptedException {
        Message message = Config.bot.execute(new SendVoice(Config.personalChatId, Config.testAudio)
                .caption("caption")
                .captionEntities(List.of(new MessageEntity(MessageEntity.Type.BOLD, 0, 3)))
        ).getMessage();
        MessageTest.checkMessage(message);
        VoiceTest.check(message.getVoice(), false);

        String voiceFileId = message.getVoice().getFileId();
        message = Config.bot.execute(new SendVoice(Config.personalChatId, voiceFileId)).getMessage();
        MessageTest.checkMessage(message);
        VoiceTest.check(message.getVoice());

        String caption = "caption <b>bold</b>";
        int duration = 100;
        message = Config.bot.execute(new SendVoice(Config.personalChatId, Config.testAudioBytes)
                        .caption(caption).parseMode(ParseMode.HTML).duration(duration))
                .getMessage();
        MessageTest.checkMessage(message);
        assertEquals(caption.replace("<b>", "").replace("</b>", ""), message.getCaption());
        VoiceTest.check(message.getVoice());
        assertEquals(duration, message.getVoice().getDuration());

        MessageEntity captionEntity = message.getCaptionEntities().get(0);
        assertEquals(MessageEntity.Type.BOLD, captionEntity.getType());
        assertEquals(8, captionEntity.getOffset().intValue());
        assertEquals(4, captionEntity.getLength().intValue());
        Thread.sleep(1000);
    }

}