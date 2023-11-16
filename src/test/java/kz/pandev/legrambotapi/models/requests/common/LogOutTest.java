package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.bot;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class LogOutTest {

    @Test
    @Disabled
    void logOut() {
        Response response = bot.execute(new LogOut());
        assertTrue(response.isOk());
    }

}