package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.MessageTest;
import kz.pandev.legrambotapi.additional.test.classes.VideoTest;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.models.types.common.video.Video;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SendVideoTest {

    @Test
    void sendVideo() throws InterruptedException {
        Message message = Config.bot.execute(new SendVideo(Config.personalChatId, Config.testVideo)
                .hasSpoiler(true)).getMessage();
        MessageTest.checkMessage(message);
        VideoTest.check(message.getVideo(), false);

        String videoFileId = message.getVideo().getFileId();
        message = Config.bot.execute(new SendVideo(Config.personalChatId, videoFileId)
                .thumbnail(Config.testThumbnail)
                .caption("caption").captionEntities(List.of(new MessageEntity(MessageEntity.Type.ITALIC, 0, 7)))
        ).getMessage();
        MessageTest.checkMessage(message);
        VideoTest.check(message.getVideo());
        assertNotEquals(Config.testThumbnailSize, message.getVideo().getThumbnail().getFileSize());
        assertEquals("testVideo.mp4", message.getVideo().getFileName());
        MessageEntity captionEntity = message.getCaptionEntities().get(0);
        assertEquals(MessageEntity.Type.ITALIC, captionEntity.getType());
        assertEquals(0, captionEntity.getOffset());
        assertEquals(7, captionEntity.getLength());

        String caption = "caption <b>bold</b>";
        int duration = 6;
        message = Config.bot.execute(
                        new SendVideo(Config.personalChatId, Config.testVideoBytes).thumbnail(Config.testThumbnailBytes)
                                .caption(caption).parseMode(ParseMode.HTML)
                                .duration(duration).height(1).width(2).supportsStreaming(true))
                .getMessage();
        MessageTest.checkMessage(message);
        assertEquals(caption.replace("<b>", "").replace("</b>", ""), message.getCaption());

        Video video = message.getVideo();
        VideoTest.check(video);
        assertEquals(duration, video.getDuration().intValue());
        assertEquals(120, video.getHeight().intValue());
        assertEquals(400, video.getWidth().intValue());
        assertEquals("video/mp4", video.getMimeType());
        assertNotEquals(Config.testThumbnailSize, video.getThumbnail().getFileSize());

        captionEntity = message.getCaptionEntities().get(0);
        assertEquals(MessageEntity.Type.BOLD, captionEntity.getType());
        assertEquals(8, captionEntity.getOffset());
        assertEquals(4, captionEntity.getLength());
        Thread.sleep(1000);
    }

}