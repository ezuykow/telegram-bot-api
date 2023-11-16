package kz.pandev.legrambotapi.models.requests.inline.mode;

import kz.pandev.legrambotapi.additional.test.classes.UserTest;
import kz.pandev.legrambotapi.models.requests.common.send.SendDocument;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.Update;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons.*;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.models.types.inline.mode.ChosenInlineResult;
import kz.pandev.legrambotapi.models.types.inline.mode.InlineQuery;
import kz.pandev.legrambotapi.models.types.inline.mode.InlineQueryResultsButton;
import kz.pandev.legrambotapi.models.types.inline.mode.input.message.content.*;
import kz.pandev.legrambotapi.models.types.inline.mode.results.*;
import kz.pandev.legrambotapi.models.types.payments.LabeledPrice;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class InlineModeTest {

    @Test
    void answerInline() throws InterruptedException {
        String someUrl = "https://google.com/";
        SendResponse resp = bot.execute(new SendDocument(personalChatId, testDoc).disableContentTypeDetection(true)
                .disableNotification(true));
        String fileId = resp.getMessage().getDocument().getFileId();

        InlineQuery inlineQuery = gson.fromJson(testInlineQuery, Update.class).getInlineQuery();
        String inlineQueryId = inlineQuery.getId();
        assertFalse(inlineQueryId.isEmpty());
        UserTest.checkUser(inlineQuery.getFrom(), true);
        assertEquals(Long.valueOf(1111111), inlineQuery.getFrom().getId());
        assertEquals("inline query", inlineQuery.getQuery());
        assertEquals("offset", inlineQuery.getOffset());
        assertNull(inlineQuery.getLocation());


        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(
                new CallbackGameButton("inline game"),
                new CallbackDataButton("inline ok", "callback ok"),
                new CallbackDataButton("cancel", "callback cancel"),
                new UrlButton("url", someUrl),
                new SwitchInlineQueryButton("switch inline", "query"),
                new SwitchInlineQueryCurrentChatButton("switch inline current", "query"));


        MessageEntity me = new MessageEntity(MessageEntity.Type.BOLD, 0, 2);

        InlineQueryResult<?>[] results = new InlineQueryResult[]{
                new InlineQueryResultArticle("1", "title",
                        new InputTextMessageContent("message")
                                .entities(List.of(me)).disableWebPagePreview(false).parseMode(ParseMode.HTML))
                        .url(someUrl).hideUrl(true).description("desc")
                        .thumbnailUrl(someUrl).thumbnailHeight(100).thumbnailWidth(100),
                new InlineQueryResultArticle("2", "title",
                        new InputContactMessageContent("123123123", "na,e").lastName("lastName")
                                .vCard("qr vcard")),
                new InlineQueryResultArticle("3", "title", new InputLocationMessageContent(50f, 50f)
                        .livePeriod(60).heading(100).horizontalAccuracy(10f).proximityAlertRadius(500)),
                new InlineQueryResultArticle("4", "title",
                        new InputVenueMessageContent(50f, 50f, "title", "address")
                                .googlePlaceId("ggId").googlePlaceType("gType")
                                .foursquareId("sqrId").foursquareType("frType")),
                new InlineQueryResultArticle("4b", "title",
                        new InputInvoiceMessageContent("title", "desc", "payload", "token", "USD",
                                List.of(new LabeledPrice("delivery", 100)))
                                .maxTipAmount(10).suggestedTipAmounts(List.of(1)).providerData("provider_data")
                                .photoUrl(someUrl).photoSize(100).photoWidth(100).photoHeight(100)
                                .needName(false).needPhoneNumber(false).needEmail(false).needShippingAddress(false)
                                .sendPhoneNumberToProvider(false).sendEmailToProvider(false)
                                .isFlexible(false)),
                new InlineQueryResultArticle("5", "title", "message"),
                new InlineQueryResultAudio("6", someUrl, "title").caption("cap <b>bold</b>").parseMode(ParseMode.HTML).performer("perf").audioDuration(100),
                new InlineQueryResultContact("7", "123123123", "name").lastName("lastName").vCard("tt vcard")
                        .thumbnailUrl(someUrl).thumbnailHeight(100).thumbnailWidth(100),
                new InlineQueryResultDocument("8", someUrl, "title", InlineQueryResultDocument.MimeType.PDF).caption("cap <b>bold</b>").parseMode(ParseMode.HTML).description("desc")
                        .thumbnailUrl(someUrl).thumbnailHeight(100).thumbnailWidth(100),
                new InlineQueryResultGame("9", "pengrad_test_game").replyMarkup(keyboardMarkup),
                new InlineQueryResultGif("10", someUrl, someUrl).caption("cap <b>bold</b>").parseMode(ParseMode.HTML).title("title")
                        .thumbnailMimeType("image/gif")
                        .gifHeight(100).gifWidth(100).gifDuration(100),
                new InlineQueryResultLocation("11", 50f, 50f, "title").livePeriod(60)
                        .heading(100).horizontalAccuracy(10f).proximityAlertRadius(500)
                        .thumbnailUrl(someUrl).thumbnailHeight(100).thumbnailWidth(100),
                new InlineQueryResultMpeg4Gif("12", someUrl, someUrl).caption("cap <b>bold</b>").parseMode(ParseMode.HTML).title("title")
                        .thumbnailMimeType("image/gif")
                        .mpeg4Height(100).mpeg4Width(100).mpeg4Duration(100),
                new InlineQueryResultPhoto("13", someUrl, someUrl).photoWidth(100).photoHeight(100).title("title")
                        .description("desc").caption("cap <b>bold</b>").parseMode(ParseMode.HTML),
                new InlineQueryResultPhoto("131", someUrl, someUrl).photoWidth(100).photoHeight(100).title("title")
                        .description("desc").caption("bold").captionEntities(List.of(me)),
                new InlineQueryResultVenue("14", 54f, 55f, "title", "address")
                        .foursquareId("frsqrId").foursquareType("frType")
                        .googlePlaceId("ggId").googlePlaceType("gType")
                        .thumbnailUrl(someUrl).thumbnailHeight(100).thumbnailWidth(100)
                        .thumbnailUrl(someUrl).thumbnailHeight(100).thumbnailWidth(100),
                new InlineQueryResultVideo("15", someUrl, InlineQueryResultVideo.MimeType.VIDEO_MP4, "text", someUrl, "title").caption("cap <b>bold</b>").parseMode(ParseMode.HTML)
                        .videoWidth(100).videoHeight(100).videoDuration(100).description("desc"),
                new InlineQueryResultVoice("16", someUrl, "title").caption("cap <b>bold</b>").parseMode(ParseMode.HTML).voiceDuration(100),
                new InlineQueryResultCachedAudio("17", fileId).caption("cap <b>bold</b>").parseMode(ParseMode.HTML),
                new InlineQueryResultCachedDocument("18", fileId, "title").caption("cap <b>bold</b>").parseMode(ParseMode.HTML).description("desc"),
                new InlineQueryResultCachedGif("19", fileId).caption("cap <b>bold</b>").parseMode(ParseMode.HTML).title("title"),
                new InlineQueryResultCachedMpeg4Gif("21", fileId).caption("cap <b>bold</b>").parseMode(ParseMode.HTML).title("title"),
                new InlineQueryResultCachedPhoto("22", "AgADAgADDKgxG7mDWUlvyFIJ9XfF9yszSw0ABBhVadWwbAK1z-wIAAEC").caption("cap <b>bold</b>").parseMode(ParseMode.HTML).description("desc").title("title"),
                new InlineQueryResultCachedSticker("23", fileId),
                new InlineQueryResultCachedVideo("24", fileId, "title").caption("cap <b>bold</b>").parseMode(ParseMode.HTML).description("desc"),
                new InlineQueryResultCachedVoice("25", fileId, "title").caption("cap <b>bold</b>").parseMode(ParseMode.HTML),
        };

        Response response = bot.execute(new AnswerInlineQuery(inlineQueryId, results)
                .cacheTime(100)
                .isPersonal(true)
                .nextOffset("offset")
                .button(new InlineQueryResultsButton("text").startParameter("start"))
        );

        if (!response.isOk()) {
            assertEquals(400, response.getErrorCode());
            assertEquals("Bad Request: query is too old and response timeout expired or query ID is invalid", response.getDescription());
        }
        Thread.sleep(1000);
    }

    @Test
    void chosenInlineResult() throws InterruptedException {
        ChosenInlineResult inlineResult = gson.fromJson(testChosenInlineResult, Update.class).getChosenInlineResult();

        assertNotNull(inlineResult);
        assertFalse(inlineResult.getResultId().isEmpty());
        UserTest.checkUser(inlineResult.getFrom(), true);
        assertEquals(1111111, inlineResult.getFrom().getId());
        assertEquals("inline query", inlineResult.getQuery());
        assertEquals("12", inlineResult.getResultId());
        assertEquals("1234csdbsk4839", inlineResult.getInlineMessageId());
        assertNull(inlineResult.getLocation());
        Thread.sleep(1000);
    }

}