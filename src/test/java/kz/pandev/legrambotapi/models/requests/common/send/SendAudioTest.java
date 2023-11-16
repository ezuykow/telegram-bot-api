package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.AudioTest;
import kz.pandev.legrambotapi.additional.test.classes.MessageTest;
import kz.pandev.legrambotapi.models.types.common.Audio;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SendAudioTest {

    @Test
    void sendAudio() throws InterruptedException {
        Message message = Config.bot.execute(new SendAudio(Config.personalChatId, Config.testAudio)
                .thumbnail(Config.testThumbnail)).getMessage();
        String audioFileId = message.getAudio().getFileId();
        MessageTest.checkMessage(message);
        AudioTest.checkAudio(message.getAudio());
        assertEquals(Config.testThumbnailSize, message.getAudio().getThumbnail().getFileSize());

        message = Config.bot.execute(new SendAudio(Config.personalChatId, audioFileId)
                .caption("caption").captionEntities(List.of(new MessageEntity(MessageEntity.Type.ITALIC, 0, 7)))
        ).getMessage();
        MessageTest.checkMessage(message);
        AudioTest.checkAudio(message.getAudio(), false);
        MessageEntity captionEntity = message.getCaptionEntities().get(0);
        assertEquals(MessageEntity.Type.ITALIC, captionEntity.getType());
        assertEquals(0, captionEntity.getOffset());
        assertEquals(7, captionEntity.getLength());



        String cap = "http://ya.ru  <b>bold</b> #audio @ezuykow_test_bot", title = "title", performer = "performer";
        ParseMode parseMode = ParseMode.HTML;
        int duration = 100;
        SendAudio sendAudio = new SendAudio(Config.personalChatId, Config.testAudioBytes)
                .thumbnail(Config.testThumbnailBytes).duration(duration)
                .caption(cap).parseMode(parseMode).performer(performer).title(title);
        message = Config.bot.execute(sendAudio).getMessage();
        MessageTest.checkMessage(message);

        Audio audio = message.getAudio();
        AudioTest.checkAudio(audio);
        assertEquals(cap.replace("<b>", "").replace("</b>", ""), message.getCaption());
        assertEquals((Integer) 100, audio.getDuration());
        assertEquals(performer, audio.getPerformer());
        assertEquals(title, audio.getTitle());
        assertEquals(Config.testThumbnailSize, audio.getThumbnail().getFileSize());

        captionEntity = message.getCaptionEntities().get(0);
        assertEquals(MessageEntity.Type.URL, captionEntity.getType());
        assertEquals(0, captionEntity.getOffset());
        assertEquals(12, captionEntity.getLength());

        captionEntity = message.getCaptionEntities().get(1);
        assertEquals(MessageEntity.Type.BOLD, captionEntity.getType());
        assertEquals(14, captionEntity.getOffset());
        assertEquals(4, captionEntity.getLength());

        assertEquals(MessageEntity.Type.HASHTAG, message.getCaptionEntities().get(2).getType());
        Thread.sleep(1000);
    }

}