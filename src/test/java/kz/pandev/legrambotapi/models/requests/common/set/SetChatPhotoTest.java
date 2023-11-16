package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SetChatPhotoTest {

    @Test
    void setChatPhoto() throws IOException, InterruptedException {
        Response response = Config.bot.execute(new SetChatPhoto(Config.testGroupId, Config.testImage));
        assertTrue(response.isOk());

        byte[] bytes = Files.readAllBytes(Config.testImage.toPath());
        response = Config.bot.execute(new SetChatPhoto(Config.testGroupId, bytes));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new SetChatPhoto(Config.testImage, bytes)));

        Thread.sleep(1000);
    }

}