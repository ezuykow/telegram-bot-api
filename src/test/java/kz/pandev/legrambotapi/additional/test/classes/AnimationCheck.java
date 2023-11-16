package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.common.Animation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author ezuykow
 */
public class AnimationCheck {

    public static void check(Animation animation) {
        assertNotNull(animation.getFileId());
        assertNotNull(animation.getFileUniqueId());
        assertNotNull(animation.getFileName());
        assertNotNull(animation.getMimeType());
        assertTrue(animation.getFileSize() > 0);
        PhotoSizeTest.checkPhotos(List.of(animation.getThumbnail()));
    }
}