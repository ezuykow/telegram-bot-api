package kz.pandev.legrambotapi.models.requests.webhook;

import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.webhook.GetWebhookInfoResponse;
import kz.pandev.legrambotapi.models.types.common.WebhookInfo;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author ezuykow
 */
class WebhookTest {

    @Test
    void getWebhookInfo() throws InterruptedException {
        GetWebhookInfoResponse response = bot.execute(new GetWebhookInfo());
        WebhookInfo webhookInfo = response.getWebhookInfo();
        assertNotNull(webhookInfo.getUrl());
        assertFalse(webhookInfo.getHasCustomCertificate());
        assertTrue(webhookInfo.getPendingUpdateCount() >= 0);
        Thread.sleep(1000);
    }

    @Test
    void setWebhook() throws IOException, InterruptedException {
        String url = "https://google.com";
        Integer maxConnections = 100;
        String[] allowedUpdates = {"message", "callback_query"};
        String ipAddress = "1.1.1.1";
        Response response = bot.execute(new SetWebhook()
                .url(url)
                .certificate(testCertificate)
                .ipAddress(ipAddress)
                .maxConnections(100)
                .allowedUpdates(allowedUpdates)
                .secretToken("secret-token")
                .dropPendingUpdates(true)
        );
        assertTrue(response.isOk());

        WebhookInfo webhookInfo = bot.execute(new GetWebhookInfo()).getWebhookInfo();
        assertEquals(url, webhookInfo.getUrl());
        assertTrue(webhookInfo.getHasCustomCertificate());
        assertEquals(maxConnections, webhookInfo.getMaxConnections());
        assertEquals(Arrays.asList(allowedUpdates), webhookInfo.getAllowedUpdates());
        Integer lastErrorDate = webhookInfo.getLastErrorDate();
        if (lastErrorDate != null) {
            assertEquals(System.currentTimeMillis(), lastErrorDate * 1000L, 30_000L);
        }
        String lastErrorMessage = webhookInfo.getLastErrorMessage();
        if (lastErrorMessage != null) {
            assertTrue(lastErrorMessage.contains("SSL"));
        }
        assertEquals(ipAddress, webhookInfo.getIpAddress());
        assertTrue(webhookInfo.getPendingUpdateCount() >= 0);

        response = bot.execute(new SetWebhook().url("https://google.com")
                .certificate(Files.readAllBytes(testCertificate.toPath())).allowedUpdates(""));
        assertTrue(response.isOk());

        response = bot.execute(new SetWebhook());
        assertTrue(response.isOk());
        Thread.sleep(1000);
    }

    @Test
    void deleteWebhook() throws InterruptedException {
        Response response = bot.execute(new DeleteWebhook().dropPendingUpdates(true));
        assertTrue(response.isOk());
        Thread.sleep(1000);
    }

}