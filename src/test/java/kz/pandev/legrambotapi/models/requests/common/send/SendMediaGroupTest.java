package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.models.responses.MessagesResponse;
import kz.pandev.legrambotapi.models.types.common.input.media.InputMediaDocument;
import kz.pandev.legrambotapi.models.types.common.input.media.InputMediaPhoto;
import kz.pandev.legrambotapi.models.types.common.input.media.InputMediaVideo;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.models.types.common.user.User;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SendMediaGroupTest {

    @Test
    void sendMediaGroup() throws InterruptedException {
        String url = "https://google.com/";
        User user = new User();
        user.setId(Config.testBotId);
        String language = "ru";

        MessagesResponse response = Config.bot.execute(new SendMediaGroup(Config.personalChatId,
                new InputMediaPhoto(Config.testImage).thumbnail(Config.testThumbnail),
                new InputMediaPhoto(Config.testImage).caption("some caption bold")
                        .captionEntities(
                                new MessageEntity(MessageEntity.Type.BOLD, 0, 4),
                                new MessageEntity(MessageEntity.Type.TEXT_LINK, 5, 1).url(url),
                                new MessageEntity(MessageEntity.Type.TEXT_MENTION, 6, 1).user(user),
                                new MessageEntity(MessageEntity.Type.PRE, 7, 1).language(language)
                        ),
                new InputMediaPhoto(Config.testImageBytes).thumbnail(Config.testThumbnailBytes).hasSpoiler(true),
                new InputMediaVideo(Config.testVideo).hasSpoiler(true),
                new InputMediaVideo(Config.testVideo),
                new InputMediaVideo(Config.testVideoBytes).caption("my video <b>bold</b>").parseMode(ParseMode.HTML)
                        .duration(10).width(11).height(12).supportsStreaming(true)
        ).messageThreadId(0).disableNotification(false).allowSendingWithoutReply(false).replyToMessageId(1));
        assertTrue(response.isOk());
        assertEquals(6, response.getMessages().size());

        String mediaGroupId = response.getMessages().get(0).getMediaGroupId();
        assertNotNull(mediaGroupId);

        int messagesWithCaption = 0;
        for (Message message : response.getMessages()) {
            assertEquals(mediaGroupId, message.getMediaGroupId());
            if (message.getCaption() != null) {
                assertEquals(MessageEntity.Type.BOLD, message.getCaptionEntities().get(0).getType());
                messagesWithCaption++;
            }
        }
        assertEquals(2, messagesWithCaption);

        List<MessageEntity> entities = response.getMessages().get(1).getCaptionEntities();
        assertEquals(MessageEntity.Type.BOLD, entities.get(0).getType());
        assertEquals(MessageEntity.Type.TEXT_LINK, entities.get(1).getType());
        assertEquals(MessageEntity.Type.TEXT_MENTION, entities.get(2).getType());
        assertEquals(MessageEntity.Type.PRE, entities.get(3).getType());
        assertEquals(url, entities.get(1).getUrl());
        assertEquals(user.getId(), entities.get(2).getUser().getId());
        assertEquals(language, entities.get(3).getLanguage());
        Thread.sleep(1000);
    }

    @Test
    void sendMediaGroupDocuments() throws InterruptedException {
        MessagesResponse response = Config.bot.execute(new SendMediaGroup(Config.personalChatId,
                new InputMediaDocument(Config.testDoc),
                new InputMediaDocument(Config.testDocumentBytes).fileName("test.pdf").contentType("application/pdf")
        ));
        assertTrue(response.isOk());
        assertEquals(2, response.getMessages().size());
        assertNotNull(response.getMessages().get(0).getMediaGroupId());
        System.out.println(response.getMessages().get(0).getDocument());
        System.out.println(response.getMessages().get(1).getDocument());
        Thread.sleep(1000);
    }

}