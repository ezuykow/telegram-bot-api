package kz.pandev.legrambotapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kz.pandev.legrambotapi.additional.test.classes.*;
import kz.pandev.legrambotapi.addons.SimpleMessageSender;
import kz.pandev.legrambotapi.configure.Callback;
import kz.pandev.legrambotapi.configure.TelegramBot;
import kz.pandev.legrambotapi.configure.api.TelegramBotClient;
import kz.pandev.legrambotapi.configure.updates.handler.UpdatesHandler;
import kz.pandev.legrambotapi.configure.updates.handler.UpdatesListener;
import kz.pandev.legrambotapi.exceptions.handler.ExceptionHandler;
import kz.pandev.legrambotapi.models.requests.common.*;
import kz.pandev.legrambotapi.models.requests.common.get.*;
import kz.pandev.legrambotapi.models.requests.common.send.*;
import kz.pandev.legrambotapi.models.requests.inline.mode.AnswerWebAppQuery;
import kz.pandev.legrambotapi.models.requests.passport.SetPassportDataErrors;
import kz.pandev.legrambotapi.models.requests.webhook.DeleteWebhook;
import kz.pandev.legrambotapi.models.requests.webhook.SetWebhook;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.responses.common.get.*;
import kz.pandev.legrambotapi.models.responses.inline.mode.AnswerWebAppQueryResponse;
import kz.pandev.legrambotapi.models.types.Update;
import kz.pandev.legrambotapi.models.types.common.*;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardButton;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons.*;
import kz.pandev.legrambotapi.models.types.common.keyboard.button.KeyboardButton;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.models.types.common.poll.PollAnswer;
import kz.pandev.legrambotapi.models.types.common.reply.keyboard.ReplyKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.web.app.WebAppInfo;
import kz.pandev.legrambotapi.models.types.inline.mode.results.*;
import kz.pandev.legrambotapi.models.types.passport.encrypted.EncryptedPassportElement;
import kz.pandev.legrambotapi.models.types.passport.errors.PassportElementErrorDataField;
import kz.pandev.legrambotapi.utils.UniqueNameGenerator;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import kz.pandev.legrambotapi.utils.gson.FileTypeAdapter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class OtherTests {

    private static final Properties props = new Properties();

    static Path resourcePath = Paths.get("src/test/resources");
    static File testDoc = resourcePath.resolve("testDoc.txt").toFile();
    static File testAudio = resourcePath.resolve("testAudio.mp3").toFile();
    static File testThumbnail = resourcePath.resolve("testThumbnail.jpg").toFile();
    static File testImage = resourcePath.resolve("testImage.jpg").toFile();
    static File testAnimatedSticker = resourcePath.resolve("testAnimatedSticker.tgs").toFile();
    static File testStaticSticker = resourcePath.resolve("testStaticSticker.png").toFile();
    static File testVideo = resourcePath.resolve("testVideo.mp4").toFile();
    static File testCertificate = resourcePath.resolve("testCertificate.pem").toFile();
    static File testVideoNote = resourcePath.resolve("testVideoNote.mp4").toFile();
    static File testGif = resourcePath.resolve("testGif.gif").toFile();


    static int testThumbnailSize = 3718;
    static byte[] testDocumentBytes;
    static byte[] testAudioBytes;
    static byte[] testThumbnailBytes;
    static byte[] testImageBytes;
    static byte[] testVideoBytes;
    static byte[] testVideoNoteBytes;
    static byte[] testGifBytes;

    static Gson gson = new Gson();


    public static String token;
    static long testBotId;
    static long myUserID;
    static long personalChatId;
    static long testGroupId;
    static long testChannelId;
    static long testAdminInGroupId;
    static String testChannelName;
    static String testInlineQuery;
    static String testChosenInlineResult;
    static String testCallbackQuery;
    static String testPollAnswer;
    static String testWebhookUrl;

    static String getProp(String key) {
        return props.getProperty(key, System.getenv(key));
    }

    static {
        try {
            props.load(Files.newInputStream(Paths.get(resourcePath.toString(), "/local.properties")));
        } catch (Exception ignored) {
        }

        token = getProp("TEST_BOT_TOKEN");
        testBotId = Long.parseLong(getProp("TEST_BOT_ID"));
        myUserID = Long.parseLong(getProp("MY_USER_ID"));
        personalChatId = Long.parseLong(getProp("PERSONAL_CHAT_ID"));
        testGroupId = Long.parseLong(getProp("TEST_GROUP_ID"));
        testChannelId = Long.parseLong(getProp("TEST_CHANNEL_ID"));
        testAdminInGroupId = Long.parseLong(getProp("TEST_ADMIN_IN_GROUP_ID"));
        testChannelName = getProp("TEST_CHANNEL_NAME");
        testInlineQuery = getProp("TEST_INLINE_QUERY");
        testChosenInlineResult = getProp("TEST_CHOSEN_INLINE_RESULT");
        testCallbackQuery = getProp("TEST_CALLBACK_QUERY");
        testPollAnswer = getProp("TEST_POLL_ANSWER");
        testWebhookUrl = getProp("TEST_WEBHOOK_URL");

//        privateKey = getProp("PRIVATE_KEY");
//        testPassportData = getProp("TEST_PASSPORT_DATA");

        try {
            testImageBytes = Files.readAllBytes(testImage.toPath());
            testAudioBytes = Files.readAllBytes(testAudio.toPath());
            testDocumentBytes = Files.readAllBytes(testDoc.toPath());
            testVideoBytes = Files.readAllBytes(testVideo.toPath());
            testVideoNoteBytes = Files.readAllBytes(testVideoNote.toPath());
            testThumbnailBytes = Files.readAllBytes(testThumbnail.toPath());
            testGifBytes = Files.readAllBytes(testGif.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static TelegramBot bot = createTestBot();

    public static TelegramBot createTestBot() {
        boolean localBuild = new File(resourcePath.toString(),"local.properties").exists();

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder()
                .connectTimeout(75, TimeUnit.SECONDS)
                .writeTimeout(75, TimeUnit.SECONDS)
                .readTimeout(75, TimeUnit.SECONDS)
                .addInterceptor(new RetryInterceptor(1000));
        if (localBuild) {
            okHttpBuilder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        return new TelegramBot.Builder(token).okHttpClient(okHttpBuilder.build()).build();
    }

    @Test
    void underlineStrikethroughMessageEntity() throws InterruptedException {
        String cap = "<u>under1</u> <ins>under2</ins> <s>strike1</s> <strike>strike2</strike> <del>strike3</del>";
        cap += " <u><del>nested-tag</del></u>";
        ParseMode parseMode = ParseMode.HTML;
        SendAudio sendAudio = new SendAudio(personalChatId, testAudio).caption(cap).parseMode(parseMode);
        Message message = bot.execute(sendAudio).getMessage();
        MessageTest.checkMessage(message);

        String htmlCaption = cap
                .replace("<u>", "").replace("</u>", "")
                .replace("<ins>", "").replace("</ins>", "")
                .replace("<s>", "").replace("</s>", "")
                .replace("<strike>", "").replace("</strike>", "")
                .replace("<del>", "").replace("</del>", "");
        assertEquals(htmlCaption, message.getCaption());

        assertEquals(7, message.getCaptionEntities().size());

        MessageEntity captionEntity = message.getCaptionEntities().get(0);
        assertEquals(MessageEntity.Type.UNDERLINE, captionEntity.getType());
        assertEquals(0, captionEntity.getOffset());
        assertEquals(6, captionEntity.getLength());

        captionEntity = message.getCaptionEntities().get(1);
        assertEquals(MessageEntity.Type.UNDERLINE, captionEntity.getType());
        assertEquals(7, captionEntity.getOffset());
        assertEquals(6, captionEntity.getLength());

        captionEntity = message.getCaptionEntities().get(2);
        assertEquals(MessageEntity.Type.STRIKETHROUGH, captionEntity.getType());
        assertEquals(14, captionEntity.getOffset());
        assertEquals(7, captionEntity.getLength());

        captionEntity = message.getCaptionEntities().get(3);
        assertEquals(MessageEntity.Type.STRIKETHROUGH, captionEntity.getType());
        assertEquals((Integer) 22, captionEntity.getOffset());
        assertEquals((Integer) 7, captionEntity.getLength());

        captionEntity = message.getCaptionEntities().get(4);
        assertEquals(MessageEntity.Type.STRIKETHROUGH, captionEntity.getType());
        assertEquals((Integer) 30, captionEntity.getOffset());
        assertEquals((Integer) 7, captionEntity.getLength());

        captionEntity = message.getCaptionEntities().get(5);
        assertEquals(MessageEntity.Type.UNDERLINE, captionEntity.getType());
        assertEquals(38, captionEntity.getOffset());
        assertEquals(10, captionEntity.getLength());

        captionEntity = message.getCaptionEntities().get(6);
        assertEquals(MessageEntity.Type.STRIKETHROUGH, captionEntity.getType());
        assertEquals(38, captionEntity.getOffset());
        assertEquals(10, captionEntity.getLength());
        Thread.sleep(1000);
    }

    @Test
    void underlineStrikethroughMarkdown() throws InterruptedException {
        String cap = "__under1__ ~strike1~ __~nested~__";
        ParseMode parseMode = ParseMode.MARKDOWN_V2;
        SendAudio sendAudio = new SendAudio(personalChatId, testAudio).caption(cap).parseMode(parseMode);
        Message message = bot.execute(sendAudio).getMessage();
        MessageTest.checkMessage(message);

        String htmlCaption = cap.replace("__", "").replace("~", "");
        assertEquals(htmlCaption, message.getCaption());

        assertEquals(4, message.getCaptionEntities().size());

        MessageEntity captionEntity = message.getCaptionEntities().get(0);
        assertEquals(MessageEntity.Type.UNDERLINE, captionEntity.getType());
        assertEquals(0, captionEntity.getOffset());
        assertEquals(6, captionEntity.getLength());

        captionEntity = message.getCaptionEntities().get(1);
        assertEquals(MessageEntity.Type.STRIKETHROUGH, captionEntity.getType());
        assertEquals(7, captionEntity.getOffset());
        assertEquals(7, captionEntity.getLength());

        captionEntity = message.getCaptionEntities().get(2);
        assertEquals(MessageEntity.Type.UNDERLINE, captionEntity.getType());
        assertEquals(15, captionEntity.getOffset());
        assertEquals(6, captionEntity.getLength());

        captionEntity = message.getCaptionEntities().get(3);
        assertEquals(MessageEntity.Type.STRIKETHROUGH, captionEntity.getType());
        assertEquals(15, captionEntity.getOffset());
        assertEquals(6, captionEntity.getLength());
        Thread.sleep(1000);
    }

    @Test
    void sendSpoilerMessage() throws InterruptedException {
        SendResponse response = bot.execute(new SendMessage(personalChatId, "ok this is spoiler ha-ha-ha")
                .entities(List.of(new MessageEntity(MessageEntity.Type.SPOILER, 19, 8))));

        MessageEntity entity = response.getMessage().getEntities().get(0);
        assertEquals(MessageEntity.Type.SPOILER, entity.getType());
        assertEquals(19, entity.getOffset());
        assertEquals(8, entity.getLength());
        Thread.sleep(1000);
    }

    @Test
    void preMessageEntity() throws InterruptedException {
        String cap = "```java\n" +
                "String s = new String();\n" +
                "```";
        ParseMode parseMode = ParseMode.MARKDOWN_V2;
        SendAudio sendAudio = new SendAudio(personalChatId, testAudio).caption(cap).parseMode(parseMode);
        Message message = bot.execute(sendAudio).getMessage();
        MessageTest.checkMessage(message);
        assertEquals(1, message.getCaptionEntities().size());
        assertEquals("java", message.getCaptionEntities().get(0).getLanguage());
        Thread.sleep(1000);
    }

    @Test
    void setPassportDataErrors() throws InterruptedException {
        Response response = bot.execute(new SetPassportDataErrors(personalChatId,
                new PassportElementErrorDataField(EncryptedPassportElement.Type.PERSONAL_DETAILS, "first_name",
                        "TueU2/SswOD5wgQ6uXQ62mJrr0Jdf30r/QQ/jyETHFM=",
                        "error in page 1")
        ));
        assertTrue(response.isOk());
        Thread.sleep(1000);
    }

    @Test
    void pollAnswer() throws InterruptedException {
        // pollAnswer is sent when user answers in a non-anonymous poll
        PollAnswer pollAnswer = gson.fromJson(testPollAnswer, Update.class).getPollAnswer();

        assertNotNull(pollAnswer);
        assertFalse(pollAnswer.getPollId().isEmpty());
        assertNull(pollAnswer.getVoterChat());
        UserTest.checkUser(pollAnswer.getUser(), true);
        assertEquals(1111111, pollAnswer.getUser().getId());
        assertEquals(List.of(0), pollAnswer.getOptionIds());
        Thread.sleep(1000);
    }

    @Test
    void testAsyncCallback() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        bot.execute(new GetMe(), new Callback<GetMe, GetMeResponse>() {
            @Override
            public void onResponse(GetMe request, GetMeResponse response) {
                latch.countDown();
            }

            @Override
            public void onFailure(GetMe request, Exception e) {
                throw new RuntimeException(e);
            }
        });
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        Thread.sleep(1000);
    }

    @Test
    void botClientError() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        String apiUrl = "https://api.telegram.org/bot" + token + "/";

        TelegramBotClient botClient = new TelegramBotClient(new OkHttpClient(), null, apiUrl);
        botClient.send(new GetMe(), new Callback<GetMe, GetMeResponse>() {
            @Override
            public void onResponse(GetMe request, GetMeResponse response) {
            }

            @Override
            public void onFailure(GetMe request, Exception e) {
                latch.countDown();
            }
        });
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        Thread.sleep(1000);
    }

    @Test
    void loginButton() throws InterruptedException {
        String text = "login";
        String url = testWebhookUrl;
        SendResponse response = bot.execute(
                new SendMessage(personalChatId, "Login button").replyMarkup(new InlineKeyboardMarkup(
                        new LoginUrlButton(text, new LoginUrl(url)
                                .forwardText("forwarded login")
                                .botUsername("ZuyTestingBot")
                                .requestWriteAccess(true)))));
        assertTrue(response.isOk());
        InlineKeyboardButton button = response.getMessage().getReplyMarkup().getInlineKeyboard().get(0).get(0);
        assertEquals(text, button.getText());
        assertEquals(url, button.getUrl());
        Thread.sleep(1000);
    }

    @Test
    void multipartNonAscii() throws InterruptedException {
        String caption = "хорошо";
        Message message = bot.execute(
                new SendPhoto(personalChatId, testImage).fileName("файл.txt").caption(caption)
        ).getMessage();
        assertEquals(caption, message.getCaption());
        MessageTest.checkMessage(message);
        PhotoSizeTest.checkPhotos(message.getPhoto());
        Thread.sleep(1000);
    }

    @Test
    void testResponseParameters() throws InterruptedException {
        String errorJson = "{\"ok\":false,\"error_code\":400,\"description\":\"Bad Request: description\",\"parameters\":{\"migrate_to_chat_id\":123456789000,\"retry_after\":3}}";
        Response response = gson.fromJson(errorJson, Response.class);
        ResponseParameters parameters = response.getParameters();
        assertNotNull(parameters);
        assertEquals(123456789000L, parameters.getMigrateToChatId());
        assertEquals(3, parameters.getRetryAfter());
        Thread.sleep(1000);
    }

    @Test
    void sendWebAppInfo() throws InterruptedException {
        String text = "gh_app";
        String url = "https://github.com/";
        SendResponse response = bot.execute(new SendMessage(personalChatId, "message with webApp")
                .replyMarkup(new InlineKeyboardMarkup(new WebAppButton(text, new WebAppInfo(url))))
        );
        assertTrue(response.isOk());

        InlineKeyboardMarkup markup = response.getMessage().getReplyMarkup();
        assertNotNull(markup);
        assertEquals(1, markup.getInlineKeyboard().size());
        assertEquals(1, markup.getInlineKeyboard().get(0).size());

        InlineKeyboardButton button = markup.getInlineKeyboard().get(0).get(0);
        assertEquals(text, button.getText());
        assertNotNull(button.getWebApp());
        assertEquals(url, button.getWebApp().getUrl());

        response = bot.execute(new SendMessage(personalChatId, "message with webApp")
                .replyMarkup(new ReplyKeyboardMarkup(new KeyboardButton(text).webApp(new WebAppInfo(url))))
        );
        assertTrue(response.isOk());
        Thread.sleep(1000);
    }

    @Test
    void answerWebAppQuery() throws InterruptedException {
        AnswerWebAppQueryResponse response = bot.execute(new AnswerWebAppQuery("123", new InlineQueryResultArticle("1", "title", "text")));
        assertFalse(response.isOk());
        assertEquals("Bad Request: query is too old and response timeout expired or query ID is invalid", response.getDescription());
        assertNull(response.getSentWebAppMessage());
        Thread.sleep(1000);
    }

    @Test
    void testSimpleMessageSender() throws InterruptedException {
        SendResponse response = SimpleMessageSender.sendPhoto(bot, personalChatId, testImageBytes);
        assertTrue(response.isOk());

        response = SimpleMessageSender.sendTextReplyToMessage(bot, personalChatId, "reply", response.getMessage().getMessageId());
        assertTrue(response.isOk());

        response = SimpleMessageSender.sendDocument(bot, personalChatId, testDocumentBytes);
        assertTrue(response.isOk());

        response = SimpleMessageSender.sendAnimation(bot, personalChatId, testAnimatedSticker);
        assertTrue(response.isOk());

        response = SimpleMessageSender.sendAudio(bot, personalChatId, testAudio);
        assertTrue(response.isOk());

        Thread.sleep(1000);

        response = SimpleMessageSender.sendAudio(bot, personalChatId, testAudioBytes);
        assertTrue(response.isOk());

        response = SimpleMessageSender.sendContact(bot, personalChatId, "+1 111 111", "first name");
        assertTrue(response.isOk());

        response = SimpleMessageSender.sendLocation(bot, personalChatId, 20F, 20F);
        assertTrue(response.isOk());

        response = SimpleMessageSender.sendPoll(bot, personalChatId, "question", "option1", "option2");
        assertTrue(response.isOk());

        response = SimpleMessageSender.sendVideo(bot, personalChatId, testVideo);
        assertTrue(response.isOk());

        Thread.sleep(1000);

        response = SimpleMessageSender.sendVideoNote(bot, personalChatId, testVideoNoteBytes);
        assertTrue(response.isOk());

        response = SimpleMessageSender.sendVideoNote(bot, personalChatId, testVideoNote);
        assertTrue(response.isOk());

        response = SimpleMessageSender.sendVoice(bot, personalChatId, testAudio);
        assertTrue(response.isOk());

        response = SimpleMessageSender.sendVoice(bot, personalChatId, testAudioBytes);
        assertTrue(response.isOk());

        Thread.sleep(1000);
    }

    @Test
    void getFileContentTest() throws IOException, InterruptedException {
        SendResponse response = SimpleMessageSender.sendVideo(bot, personalChatId, testVideoBytes);
        assertTrue(response.isOk());

        String fileId = response.getMessage().getVideo().getFileId();
        GetFileResponse resp = bot.execute(new GetFile(fileId));
        byte[] fileContent = bot.getFileContent(resp.getFile());
        assertNotNull(fileContent);

        Thread.sleep(1000);
    }

    @Test
    void updatesHandlerTest() throws InterruptedException {
        UpdatesListener ul = updates -> {
            assertFalse(updates.isEmpty());
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        };
        ExceptionHandler eh = e -> System.out.println("error");
        GetUpdates gu = new GetUpdates();
        UpdatesHandler uh = new UpdatesHandler(100);

        uh.start(bot, ul, eh, gu);
        int messageId = SimpleMessageSender.sendText(bot, personalChatId, "text").getMessage().getMessageId();
        bot.execute(new PinChatMessage(personalChatId, messageId));
        uh.stop();

        Thread.sleep(1000);

        ul = updates -> {
            assertFalse(updates.isEmpty());
            return updates.get(updates.size()-1).getUpdateId();
        };
        uh.start(bot, ul, eh, gu);
        messageId = SimpleMessageSender.sendText(bot, personalChatId, "text").getMessage().getMessageId();
        bot.execute(new PinChatMessage(personalChatId, messageId));
        uh.stop();

        Thread.sleep(1000);

        bot.execute(new SetWebhook().url(testWebhookUrl));
        uh.start(bot, ul, eh, gu);
        messageId = SimpleMessageSender.sendText(bot, personalChatId, "text").getMessage().getMessageId();
        bot.execute(new PinChatMessage(personalChatId, messageId));
        uh.stop();
        bot.execute(new DeleteWebhook().dropPendingUpdates(true));

        Thread.sleep(1000);

        bot.execute(new SetWebhook().url(testWebhookUrl));
        uh.start(bot, ul, null, gu);
        messageId = SimpleMessageSender.sendText(bot, personalChatId, "text").getMessage().getMessageId();
        bot.execute(new PinChatMessage(personalChatId, messageId));
        uh.stop();
        bot.execute(new DeleteWebhook());

        Thread.sleep(1000);
    }

    @Test
    void uniqueNamesGeneratorTest() {
        String s = UniqueNameGenerator.next("test");
        UniqueNameGenerator.reset();
        String s2 = UniqueNameGenerator.next("test");
        assertEquals("test1", s);
        assertEquals(s, s2);
    }

    @Test
    void fileTypeAdapterTest() {
        Gson gson = new GsonBuilder().registerTypeAdapter(File.class, new FileTypeAdapter()).create();

        String imageBytesStr = "\"" + Arrays.toString(testImageBytes) + "\"";

        String s = gson.toJson(testImage);
        assertEquals(imageBytesStr, s);

        File file = gson.fromJson(s, File.class);
        assertNull(file);
    }
}