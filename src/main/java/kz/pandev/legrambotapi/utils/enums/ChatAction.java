package kz.pandev.legrambotapi.utils.enums;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Available chat actions
 * @author ezuykow
 */
@Getter
@RequiredArgsConstructor
public enum ChatAction {

    @SerializedName("typing")
    TYPING("typing"),
    @SerializedName("upload_photo")
    UPLOAD_PHOTO("upload_photo"),
    @SerializedName("record_video")
    RECORD_VIDEO("record_video"),
    @SerializedName("upload_video")
    UPLOAD_VIDEO("upload_video"),
    @SerializedName("record_voice")
    RECORD_VOICE("record_voice"),
    @SerializedName("upload_voice")
    UPLOAD_VOICE("upload_voice"),
    @SerializedName("upload_document")
    UPLOAD_DOCUMENT("upload_document"),
    @SerializedName("choose_sticker")
    CHOOSE_STICKER("choose_sticker"),
    @SerializedName("find_location")
    FIND_LOCATION("find_location"),
    @SerializedName("record_video_note")
    RECORD_VIDEO_NOTE("record_video_note"),
    @SerializedName("upload_video_note")
    UPLOAD_VIDEO_NOTE("upload_video_note");

    /**
     * Text value for sending to Telegram server
     */
    private final String textVal;
}