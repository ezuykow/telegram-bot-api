package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.FileTest;
import kz.pandev.legrambotapi.models.requests.common.send.SendDocument;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.responses.common.get.GetFileResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class GetFileTest {

    @Test
    void getFile() throws IOException, InterruptedException {
        SendResponse resp = Config.bot.execute(new SendDocument(Config.personalChatId, Config.testDoc)
                .disableContentTypeDetection(true)
                .disableNotification(true));
        String fileId = resp.getMessage().getDocument().getFileId();

        GetFileResponse response = Config.bot.execute(new GetFile(fileId));
        FileTest.check(response.getFile());
        String path = Config.bot.getFullFilePath(response.getFile());

        Request request = new Request.Builder().head().url(path).build();
        try (okhttp3.Response pathResponse = new OkHttpClient().newCall(request).execute()) {
            assertTrue(pathResponse.isSuccessful());
        }
        Thread.sleep(1000);
    }

}