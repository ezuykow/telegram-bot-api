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
 * Represents a general file to be sent.
 * @author ezuykow
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InputMediaDocument extends InputMedia<InputMediaDocument> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Input media type
     */
    private static final String INPUT_MEDIA_TYPE = "document";

    /**
     * Optional. Disables automatic server-side content type detection for files uploaded using
     * multipart/form-data. Always True, if the document is sent as part of an album.
     */
    @SerializedName("disable_content_type_detection")
    @Nullable
    private Boolean disableContentTypeDetection;

    /**
     * @param media document as byte array, java.io.File
     *             or String (if it is fileId of file on Telegram bot API server)
     */
    public InputMediaDocument(Object media) {
        super(INPUT_MEDIA_TYPE, media);
    }

    //region API

    /**
     * Set parameter {@link InputMediaDocument#disableContentTypeDetection}
     * @param disableContentTypeDetection new parameter value
     * @return this {@link InputMediaDocument}
     */
    public InputMediaDocument disableContentTypeDetection(boolean disableContentTypeDetection) {
        this.disableContentTypeDetection = disableContentTypeDetection;
        return this;
    }

    /**
     * @return default document file name
     */
    @Override
    protected String getDefaultFileName() {
        return DefaultFileName.DOC.getTextVal();
    }

    /**
     * @return default document mime type
     */
    @Override
    protected String getDefaultContentType() {
        return MimeType.DOC.getTextVal();
    }

    //endregion
}