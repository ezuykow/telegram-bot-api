package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.configure.Callback;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.bot;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class CloseTest {

    @Test
    void close() {
        bot.execute(new Close(), new Callback<Close, Response>() {
            @Override
            public void onResponse(Close request, Response response) {
                assertTrue(response.isOk());
            }

            @Override
            public void onFailure(Close request, Exception e) {
                //response with error_code 429
                assertNull(e);
            }
        });
    }

}