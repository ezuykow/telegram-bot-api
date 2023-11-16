package kz.pandev.legrambotapi.models.requests.common.delete;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class DeleteChatStickerSetTest {

    @Test
    void deleteChatStickerSet() throws InterruptedException {
        Response response = Config.bot.execute(new DeleteChatStickerSet(Config.testGroupId));
        assertFalse(response.isOk());
        assertEquals(400, response.getErrorCode());

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new DeleteChatStickerSet(Config.testImage)));

        Thread.sleep(1000);
    }

}