package kz.pandev.legrambotapi.utils.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author ezuykow
 */
@Getter
@RequiredArgsConstructor
public enum MimeType {

    /**
     * Default mime type for photo
     */
    PHOTO("image/jpeg"),
    /**
     * Default mime type for audio
     */
    AUDIO("audio/mpeg"),
    /**
     * Default mime type for document
     */
    DOC("text/plain"),
    /**
     * Default mime type for video
     */
    VIDEO("video/mp4"),
    /**
     * Default mime type for voice
     */
    VOICE("audio/ogg"),
    /**
     * Default mime type for animation
     */
    GIF("image/gif"),
    /**
     * General default mime type
     */
    GENERAL("application/x-www-form-urlencoded");

    /**
     * Text value
     */
    private final String textVal;
}