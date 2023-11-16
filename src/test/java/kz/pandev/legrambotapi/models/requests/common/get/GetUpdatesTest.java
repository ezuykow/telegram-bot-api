package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.UpdateTest;
import kz.pandev.legrambotapi.models.responses.common.get.GetUpdatesResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class GetUpdatesTest {

    @Test
    void getUpdates() throws InterruptedException {
        GetUpdates getUpdates = new GetUpdates()
                .offset(874227176)
                .allowedUpdates("")
                .timeout(0)
                .limit(100);
        GetUpdatesResponse response = Config.bot.execute(getUpdates);
        UpdateTest.check(response.getUpdates());
        Thread.sleep(1000);
    }

}