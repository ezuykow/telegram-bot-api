package kz.pandev.legrambotapi.utils.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Default files names
 * @author ezuykow
 */
@Getter
@RequiredArgsConstructor
public enum DefaultFileName {

    /**
     * Default name for photo
     */
    PHOTO("image.jpg"),
    /**
     * Default name for audio
     */
    AUDIO("audio.mp3"),
    /**
     * Default name for document
     */
    DOC("doc.txt"),
    /**
     * Default name for video
     */
    VIDEO("video.mp4"),
    /**
     * Default name for voice
     */
    VOICE("voice.ogg"),
    /**
     * Default name for animation
     */
    GIF("gif.gif"),
    /**
     * General default name
     */
    GENERAL("file.txt");

    /**
     * Text value
     */
    private final String textVal;

}