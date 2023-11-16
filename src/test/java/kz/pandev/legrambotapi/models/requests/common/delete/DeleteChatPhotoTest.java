package kz.pandev.legrambotapi.models.requests.common.delete;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class DeleteChatPhotoTest {

    @Test
    void deleteChatPhoto() throws InterruptedException {
        Response response = Config.bot.execute(new DeleteChatPhoto(Config.testGroupId));
        if (!response.isOk()) {
            assertEquals(400, response.getErrorCode());
            assertEquals("Bad Request: CHAT_NOT_MODIFIED", response.getDescription());
        } else {
            assertTrue(response.isOk());
        }

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new DeleteChatPhoto(Config.testImage)));

        Thread.sleep(1000);
    }

}