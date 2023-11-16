package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.PhotoSizeTest;
import kz.pandev.legrambotapi.models.responses.common.get.GetUserProfilePhotosResponse;
import kz.pandev.legrambotapi.models.types.common.PhotoSize;
import kz.pandev.legrambotapi.models.types.common.user.UserProfilePhotos;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class GetUserProfilePhotosTest {

    @Test
    void getUserProfilePhotos() throws InterruptedException {
        int offset = 0;
        GetUserProfilePhotosResponse response = Config.bot.execute(new GetUserProfilePhotos(Config.myUserID)
                .limit(100).offset(offset));
        UserProfilePhotos photos = response.getPhotos();
        assertEquals(photos.getTotalCount() - offset, photos.getPhotos().size());
        for (List<PhotoSize> photo : photos.getPhotos()) {
            PhotoSizeTest.checkPhotos(photo);
        }

        if (photos.getTotalCount() > 1) {
            photos = Config.bot.execute(new GetUserProfilePhotos(Config.myUserID).limit(1)).getPhotos();
            assertEquals(1, photos.getPhotos().size());
        }
        Thread.sleep(1000);
    }

}