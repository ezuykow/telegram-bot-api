package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.common.video.Video;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class VideoTest {

    public static void check(Video video) {
        check(video, true);
    }

    public static void check(Video video, boolean checkSize) {
        assertNotNull(video.getFileId());
        assertNotNull(video.getFileUniqueId());
        assertNotNull(video.getDuration());
        assertNotNull(video.getWidth());
        assertNotNull(video.getHeight());
        if (checkSize) assertNotNull(video.getFileSize());
        PhotoSizeTest.checkPhotos(List.of(video.getThumbnail()));
    }
}