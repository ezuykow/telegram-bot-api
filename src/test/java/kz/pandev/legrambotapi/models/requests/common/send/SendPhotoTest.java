package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.MessageTest;
import kz.pandev.legrambotapi.additional.test.classes.PhotoSizeTest;
import kz.pandev.legrambotapi.addons.SimpleMessageSender;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SendPhotoTest {

    @Test
    void sendPhoto() throws InterruptedException {
        Message message = SimpleMessageSender.sendPhoto(Config.bot, Config.personalChatId, Config.testImage).getMessage();
        MessageTest.checkMessage(message);
        PhotoSizeTest.checkPhotos(false, message.getPhoto());

        String imageFileId = message.getPhoto().get(0).getFileId();
        message = Config.bot.execute(new SendPhoto(Config.personalChatId, imageFileId).hasSpoiler(true)
                .caption("caption").captionEntities(List.of(
                        new MessageEntity(MessageEntity.Type.ITALIC, 0, 7)))).getMessage();
        MessageTest.checkMessage(message);
        PhotoSizeTest.checkPhotos(message.getPhoto());
        MessageEntity captionEntity = message.getCaptionEntities().get(0);
        assertEquals(MessageEntity.Type.ITALIC, captionEntity.getType());
        assertEquals(0, captionEntity.getOffset());
        assertEquals(7, captionEntity.getLength());

        String caption = "caption <b>bold</b>";
        message = Config.bot.execute(new SendPhoto(Config.testChannelName, Config.testImageBytes)
                .caption(caption).parseMode(ParseMode.HTML)).getMessage();
        MessageTest.checkMessage(message);
        assertEquals(caption.replace("<b>", "").replace("</b>", ""), message.getCaption());
        PhotoSizeTest.checkPhotos(message.getPhoto());

        captionEntity = message.getCaptionEntities().get(0);
        assertEquals(MessageEntity.Type.BOLD, captionEntity.getType());
        assertEquals(8, captionEntity.getOffset());
        assertEquals(4, captionEntity.getLength());
        Thread.sleep(1000);
    }

}