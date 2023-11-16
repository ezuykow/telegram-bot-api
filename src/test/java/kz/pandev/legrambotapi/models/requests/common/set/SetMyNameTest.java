package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.models.requests.common.get.GetMyName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.common.get.GetMyNameResponse;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.bot;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SetMyNameTest {

    @Test
    void setMyName() throws InterruptedException {
        Response response = bot.execute(new SetMyName().name("name").languageCode("en"));
        assertTrue(response.isOk());

        GetMyNameResponse nameResponse = bot.execute(new GetMyName().languageCode("en"));
        assertTrue(nameResponse.isOk());
        assertEquals("name", nameResponse.getBotName().getName());
        Thread.sleep(1000);
    }

}