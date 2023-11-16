package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.common.Voice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class VoiceTest {

    public static void check(Voice voice) {
        check(voice, true);
    }

    public static void check(Voice voice, boolean checkSize) {
        assertNotNull(voice.getFileId());
        assertNotNull(voice.getFileUniqueId());
        assertNotNull(voice.getMimeType());
        assertNotNull(voice.getDuration());
        if (checkSize) assertNotNull(voice.getFileSize());
    }
}