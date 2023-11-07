package kz.pandev.legrambotapi.models.types.common.input.media;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.utils.enums.DefaultFileName;
import kz.pandev.legrambotapi.utils.enums.MimeType;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a photo to be sent.
 * @author ezuykow
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InputMediaPhoto extends InputMedia<InputMediaPhoto> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Input media type
     */
    private static final String INPUT_MEDIA_TYPE = "photo";

    /**
     * Optional. Pass True if the photo needs to be covered with a spoiler animation
     */
    @SerializedName("has_spoiler")
    @Nullable
    private Boolean hasSpoiler;

    /**
     * @param media photo as byte array, java.io.File
     *             or String (if it is fileId of file on Telegram bot API server)
     */
    public InputMediaPhoto(Object media) {
        super(INPUT_MEDIA_TYPE, media);
    }

    //region API

    /**
     * Set {@link InputMediaPhoto#hasSpoiler}
     * @param hasSpoiler new parameter
     * @return this {@link InputMediaPhoto}
     */
    public InputMediaPhoto hasSpoiler(boolean hasSpoiler) {
        this.hasSpoiler = hasSpoiler;
        return this;
    }

    /**
     * @return {@link DefaultFileName#PHOTO} text value
     */
    @Override
    protected String getDefaultFileName() {
        return DefaultFileName.PHOTO.getTextVal();
    }

    /**
     * @return {@link MimeType#PHOTO} text value
     */
    @Override
    protected String getDefaultContentType() {
        return MimeType.PHOTO.getTextVal();
    }

    //endregion
}