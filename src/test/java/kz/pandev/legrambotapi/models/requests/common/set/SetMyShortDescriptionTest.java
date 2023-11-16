package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.models.requests.common.get.GetMyShortDescription;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.common.get.GetMyShortDescriptionResponse;
import kz.pandev.legrambotapi.models.types.common.bot.BotShortDescription;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.bot;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SetMyShortDescriptionTest {

    @Test
    void setMyShortDescription() throws InterruptedException {
        Response response = bot.execute(new SetMyShortDescription().description("short_desc").languageCode("en"));
        assertTrue(response.isOk());

        GetMyShortDescriptionResponse descResponse = bot.execute(new GetMyShortDescription().languageCode("en"));
        assertTrue(descResponse.isOk());
        BotShortDescription desc = descResponse.getBotShortDescription();
        assertNotNull(desc);
        assertEquals("short_desc", desc.getShortDescription());
        Thread.sleep(1000);
    }

}