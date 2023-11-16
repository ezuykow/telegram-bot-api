package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.models.requests.common.get.GetMyDescription;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.common.get.GetMyDescriptionResponse;
import kz.pandev.legrambotapi.models.types.common.bot.BotDescription;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.bot;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SetMyDescriptionTest {

    @Test
    void setMyDescription() throws InterruptedException {
        Response response = bot.execute(new SetMyDescription().description("desc").languageCode("en"));
        assertTrue(response.isOk());

        GetMyDescriptionResponse descResponse = bot.execute(new GetMyDescription().languageCode("en"));
        assertTrue(descResponse.isOk());
        BotDescription desc = descResponse.getBotDescription();
        assertNotNull(desc);
        assertEquals("desc", desc.getDescription());
        Thread.sleep(1000);
    }

}