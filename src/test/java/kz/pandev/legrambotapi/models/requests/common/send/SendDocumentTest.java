package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.DocumentTest;
import kz.pandev.legrambotapi.additional.test.classes.MessageTest;
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
class SendDocumentTest {

    @Test
    void sendDocument() throws InterruptedException {
        Message message = SimpleMessageSender.sendDocument(Config.bot, Config.personalChatId, Config.testDoc).getMessage();
        MessageTest.checkMessage(message);
        DocumentTest.check(message.getDocument());

        message = Config.bot.execute(
                        new SendDocument(Config.personalChatId, Config.testDocumentBytes)
                                .thumbnail(Config.testThumbnailBytes).contentType("application/pdf")
                                .caption("caption").captionEntities(List.of(new MessageEntity(MessageEntity.Type.ITALIC, 0, 7))))
                .getMessage();
        MessageTest.checkMessage(message);
        DocumentTest.check(message.getDocument());
        assertEquals(Config.testThumbnailSize, message.getDocument().getThumbnail().getFileSize());
        MessageEntity captionEntity = message.getCaptionEntities().get(0);
        assertEquals(MessageEntity.Type.ITALIC, captionEntity.getType());
        assertEquals(0, captionEntity.getOffset());
        assertEquals(7, captionEntity.getLength());

        String docFileId = message.getDocument().getFileId();
        String caption = "caption <b>bold</b>", fileName = "my doc.pdf";
        ParseMode parseMode = ParseMode.HTML;
        message = Config.bot.execute(
                        new SendDocument(Config.personalChatId, docFileId).fileName(fileName)
                                .thumbnail(Config.testThumbnail).caption(caption).parseMode(parseMode)
                                .disableContentTypeDetection(true))
                .getMessage();
        MessageTest.checkMessage(message);
        DocumentTest.check(message.getDocument());
        assertEquals(caption.replace("<b>", "").replace("</b>", ""), message.getCaption());
        assertEquals("doc.txt", message.getDocument().getFileName());
        assertEquals(Config.testThumbnailSize, message.getDocument().getThumbnail().getFileSize());

        captionEntity = message.getCaptionEntities().get(0);
        assertEquals(MessageEntity.Type.BOLD, captionEntity.getType());
        assertEquals(8, captionEntity.getOffset());
        assertEquals(4, captionEntity.getLength());
        Thread.sleep(1000);
    }

}