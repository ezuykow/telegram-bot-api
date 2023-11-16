package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.addons.SimpleMessageSender;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.Document;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SendAnimationTest {

    @Test
    void sendAnimation() throws InterruptedException {
        String caption = "gif *file*", captionCheck = "gif file";
        SendResponse response = Config.bot.execute(new SendAnimation(Config.personalChatId, Config.testGif)
                .duration(222).width(340).height(240).thumbnail(Config.testThumbnail)
                .caption(caption).parseMode(ParseMode.MARKDOWN).hasSpoiler(true));
        assertTrue(response.isOk());
        Document doc = response.getMessage().getDocument();
        assertEquals("testGif.gif", doc.getFileName());
        assertEquals("image/gif", doc.getMimeType());
        assertEquals(captionCheck, response.getMessage().getCaption());
        assertEquals(MessageEntity.Type.BOLD, response.getMessage().getCaptionEntities().get(0).getType());

        response = Config.bot.execute(new SendAnimation(Config.personalChatId, doc.getFileId())
                .thumbnail(Config.testThumbnailBytes)
                .caption("caption").captionEntities(List.of(new MessageEntity(MessageEntity.Type.ITALIC, 0, 7))));
        doc = response.getMessage().getDocument();
        assertEquals("testGif.gif", doc.getFileName());
        assertEquals("image/gif", doc.getMimeType());
        MessageEntity captionEntity = response.getMessage().getCaptionEntities().get(0);
        assertEquals(MessageEntity.Type.ITALIC, captionEntity.getType());
        assertEquals(0, captionEntity.getOffset());
        assertEquals(7, captionEntity.getLength());

        response = SimpleMessageSender.sendAnimation(Config.bot, Config.personalChatId, Config.testGifBytes);
        Document doc2 = response.getMessage().getDocument();
        assertEquals("gif.gif", doc2.getFileName());
        assertEquals("image/gif", doc2.getMimeType());

        assertThrows(WrongParameterTypeException.class, () ->
                new SendAnimation(Config.personalChatId, doc2.getFileId()).thumbnail("wrong thumb"));

        Thread.sleep(1000);
    }

}