package kz.pandev.legrambotapi;

import com.google.gson.Gson;
import kz.pandev.legrambotapi.additional.test.classes.RetryInterceptor;
import kz.pandev.legrambotapi.configure.TelegramBot;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author ezuykow
 */
public class Config {

    private static final Properties props = new Properties();
    private static final  Path resourcePath = Paths.get("src/test/resources");

    public static final File testDoc = resourcePath.resolve("testDoc.txt").toFile();
    public static final File testAudio = resourcePath.resolve("testAudio.mp3").toFile();
    public static final File testThumbnail = resourcePath.resolve("testThumbnail.jpg").toFile();
    public static final File testImage = resourcePath.resolve("testImage.jpg").toFile();
    public static final File testAnimatedSticker = resourcePath.resolve("testAnimatedSticker.tgs").toFile();
    public static final File testStaticSticker = resourcePath.resolve("testStaticSticker.png").toFile();
    public static final File testVideo = resourcePath.resolve("testVideo.mp4").toFile();
    public static final File testCertificate = resourcePath.resolve("testCertificate.pem").toFile();
    public static final File testVideoNote = resourcePath.resolve("testVideoNote.mp4").toFile();
    public static final File testGif = resourcePath.resolve("testGif.gif").toFile();


    public static final int testThumbnailSize = 3718;
    public static final byte[] testDocumentBytes;
    public static final byte[] testAudioBytes;
    public static final byte[] testThumbnailBytes;
    public static final byte[] testImageBytes;
    public static final byte[] testVideoBytes;
    public static final byte[] testVideoNoteBytes;
    public static final byte[] testGifBytes;

    public static final Gson gson = new Gson();


    public static final String token;
    public static final long testBotId;
    public static final long myUserID;
    public static final long personalChatId;
    public static final long testGroupId;
    public static final long testChannelId;
    public static final long testAdminInGroupId;
    public static final String testChannelName;
    public static final String testInlineQuery;
    public static final String testChosenInlineResult;
    public static final String testCallbackQuery;
    public static final String testPollAnswer;
    public static final String testWebhookUrl;

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

    public static final TelegramBot bot = createTestBot();

    private static TelegramBot createTestBot() {
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
}