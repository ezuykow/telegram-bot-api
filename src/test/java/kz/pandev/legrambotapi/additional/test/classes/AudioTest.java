package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.common.Audio;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class AudioTest {

    public static void checkAudio(Audio audio) {
        checkAudio(audio, true);
    }

    public static void checkAudio(Audio audio, boolean thumb) {
        assertNotNull(audio.getFileId());
        assertNotNull(audio.getFileUniqueId());
        assertNotNull(audio.getDuration());
        assertNotNull(audio.getTitle());
        assertNotNull(audio.getMimeType());
        assertNotNull(audio.getFileSize());
        assertNotNull(audio.getPerformer());
        if (thumb) assertNotNull(audio.getThumbnail());
    }
}