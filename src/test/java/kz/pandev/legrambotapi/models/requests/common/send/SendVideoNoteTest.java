package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.VideoNoteCheck;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SendVideoNoteTest {

    @Test
    void sendVideoNote() throws InterruptedException {
        SendResponse response = Config.bot.execute(new SendVideoNote(Config.personalChatId, Config.testVideoNote)
                .thumbnail(Config.testThumbnail).length(20).duration(30));
        VideoNoteCheck.check(response.getMessage().getVideoNote(), true);
        assertNotEquals(Config.testThumbnailSize, response.getMessage().getVideoNote().getThumbnail().getFileSize());

        response = Config.bot.execute(new SendVideoNote(Config.personalChatId, response.getMessage()
                .getVideoNote().getFileId()));
        VideoNoteCheck.check(response.getMessage().getVideoNote());

        response = Config.bot.execute(new SendVideoNote(Config.personalChatId, Config.testVideoNoteBytes)
                .thumbnail(Config.testThumbnailBytes));
        VideoNoteCheck.check(response.getMessage().getVideoNote(), true);
        assertNotEquals(Config.testThumbnailSize, response.getMessage().getVideoNote().getThumbnail().getFileSize());
        Thread.sleep(1000);
    }

}