package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.UserTest;
import kz.pandev.legrambotapi.models.responses.common.get.GetMeResponse;
import kz.pandev.legrambotapi.models.types.common.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class GetMeTest {

    @Test
    void getMe() throws InterruptedException {
        GetMeResponse response = Config.bot.execute(new GetMe());

        User user = response.getUser();
        UserTest.checkUser(user);
        assertTrue(user.getIsBot());
        assertNull(user.getIsPremium());
        Thread.sleep(1000);
    }

}