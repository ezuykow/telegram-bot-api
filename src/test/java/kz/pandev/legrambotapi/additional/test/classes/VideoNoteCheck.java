package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.common.video.VideoNote;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class VideoNoteCheck {

    public static void check(VideoNote videoNote) {
        check(videoNote, false);
    }

    public static void check(VideoNote videoNote, boolean full) {
        assertNotNull(videoNote.getFileId());
        assertNotNull(videoNote.getFileUniqueId());
        assertNotNull(videoNote.getLength());
        assertNotNull(videoNote.getDuration());
        PhotoSizeTest.checkPhotos(List.of(videoNote.getThumbnail()));
        if (full) {
            assertNotNull(videoNote.getFileSize());
        }
    }
}