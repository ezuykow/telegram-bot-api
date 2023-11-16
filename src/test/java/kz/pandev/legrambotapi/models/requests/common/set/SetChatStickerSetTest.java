package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SetChatStickerSetTest {

    @Test
    void setChatStickerSet() throws InterruptedException {
        Response response = Config.bot.execute(
                new SetChatStickerSet(Config.testGroupId, "not_existent_sticker_set"));
        assertFalse(response.isOk());
        assertEquals(400, response.getErrorCode());
        assertEquals("Bad Request: sticker set not found", response.getDescription());

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new SetChatStickerSet(Config.testImage, "not_existent_sticker_set")));

        Thread.sleep(1000);
    }

}