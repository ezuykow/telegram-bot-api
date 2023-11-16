package kz.pandev.legrambotapi.models.requests.common.edit;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.DocumentTest;
import kz.pandev.legrambotapi.additional.test.classes.MessageTest;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.common.send.SendDocument;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.Audio;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardButton;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons.CallbackDataButton;
import kz.pandev.legrambotapi.models.types.common.input.media.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class EditMessageMediaTest {

    @Test
    void editMessageMedia() throws InterruptedException {
        SendResponse response = Config.bot.execute(new SendDocument(Config.personalChatId, Config.testDoc)
                .fileName("test.pdf").contentType("application/pdf"));
        int messageId = response.getMessage().getMessageId();


        response = (SendResponse) Config.bot.execute(new EditMessageMedia(Config.personalChatId, messageId,
                new InputMediaDocument(Config.testDoc)
                        .thumbnail(Config.testThumbnail)
                        .disableContentTypeDetection(true)
        ).replyMarkup(new InlineKeyboardMarkup(new CallbackDataButton("text", "data"))));
        assertEquals(Config.testThumbnailSize, response.getMessage().getDocument().getThumbnail().getFileSize());

        response = (SendResponse) Config.bot.execute(new EditMessageMedia(Config.personalChatId, messageId,
                new InputMediaDocument(Config.testDocumentBytes).thumbnail(Config.testThumbnailBytes)));
        assertEquals(Config.testThumbnailSize, response.getMessage().getDocument().getThumbnail().getFileSize());

        String docFileId = response.getMessage().getDocument().getFileId();
        response = (SendResponse) Config.bot.execute(new EditMessageMedia(Config.personalChatId, messageId,
                new InputMediaDocument(docFileId))
                .replyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton("text"))));
        MessageTest.checkMessage(response.getMessage());
        DocumentTest.check(response.getMessage().getDocument());

        Thread.sleep(1000);

        response = (SendResponse) Config.bot.execute(new EditMessageMedia(Config.personalChatId, messageId,
                new InputMediaAnimation(Config.testGif).duration(1)));
        assertEquals("testGif.gif", response.getMessage().getDocument().getFileName());

        int duration = 10, width = 20, height = 21;
        response = (SendResponse) Config.bot.execute(new EditMessageMedia(Config.personalChatId, messageId,
                new InputMediaAnimation(Config.testGifBytes).duration(duration).width(width).height(height)
                        .hasSpoiler(true)
        ));
        assertEquals("gif.gif", response.getMessage().getDocument().getFileName());

        String gifFileId = response.getMessage().getDocument().getFileId();
        response = (SendResponse) Config.bot.execute(new EditMessageMedia(Config.personalChatId, messageId,
                new InputMediaAnimation(gifFileId))
                .replyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton("text"))));
        assertTrue(response.isOk());
        assertEquals(gifFileId, response.getMessage().getDocument().getFileId());
        assertEquals("image/gif", response.getMessage().getDocument().getMimeType());

        response = (SendResponse) Config.bot.execute(new EditMessageMedia(Config.personalChatId, messageId,
                new InputMediaAudio(Config.testAudio)));
        assertEquals(10286, response.getMessage().getAudio().getFileSize());
        response = (SendResponse) Config.bot.execute(new EditMessageMedia(Config.personalChatId, messageId,
                new InputMediaAudio(response.getMessage().getAudio().getFileId()))
                .replyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton("text"))));
        assertEquals(10286, response.getMessage().getAudio().getFileSize());
        response = (SendResponse) Config.bot.execute(new EditMessageMedia(Config.personalChatId, messageId,
                new InputMediaAudio(Config.testAudioBytes))
                .replyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton("new text"))));
        assertEquals(10286, response.getMessage().getAudio().getFileSize());

        duration = 34;
        String performer = "some performer", title = "just a title", fileName = "beep.mp3";
        response = (SendResponse) Config.bot.execute(new EditMessageMedia(Config.personalChatId, messageId,
                new InputMediaAudio(Config.testAudio).duration(duration).performer(performer).title(title)
                        .fileName(fileName)
        ));
        Audio audio = response.getMessage().getAudio();
        assertEquals(10286, audio.getFileSize());
        assertEquals(duration, audio.getDuration());
        assertEquals(performer, audio.getPerformer());
        assertEquals(title, audio.getTitle());
        assertEquals(fileName, audio.getFileName());

        Thread.sleep(1000);

        // send multipart InputMediaPhoto, InputMediaVideo to cover getFileName and getContentType
        response = (SendResponse) Config.bot.execute(new EditMessageMedia(Config.personalChatId, messageId,
                new InputMediaPhoto(Config.testImage).thumbnail(Config.testThumbnail)));
        assertNotNull(response.getMessage().getPhoto());
        response = (SendResponse) Config.bot.execute(new EditMessageMedia(Config.personalChatId, messageId,
                new InputMediaVideo(Config.testVideo).thumbnail(Config.testThumbnail)));
        assertNotNull(response.getMessage().getVideo());

        Response resp = Config.bot.execute(new EditMessageMedia("AgAAAPrwAQCj_Q4D2s-51_8jsuU",
                new InputMediaVideo(Config.testVideo)));
        assertFalse(resp.isOk());
        assertEquals(400, resp.getErrorCode());
        assertEquals("Bad Request: invalid message content specified", resp.getDescription());

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new EditMessageMedia(Config.testImage, messageId,
                        new InputMediaVideo(Config.testVideo))));

        Thread.sleep(1000);
    }

}