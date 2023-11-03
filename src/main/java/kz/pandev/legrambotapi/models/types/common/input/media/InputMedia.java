package kz.pandev.legrambotapi.models.types.common.input.media;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.types.common.input.InputFile;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.Constant;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import kz.pandev.legrambotapi.utils.UniqueNameGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This object represents the content of a media message to be sent
 * @author ezuykow
 */
@EqualsAndHashCode
@ToString
public abstract class InputMedia<T extends InputMedia<T>> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Prefix of generated names
     */
    private static final String NAME_GENERATOR_PREFIX = "InputMedia";

    /**
     * Type of the media. Possible types:
     * <li> photo
     * <li> video
     * <li> animation
     * <li> audio
     * <li> document
     */
    @SerializedName("type")
    private final String type;

    /**
     * File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended),
     * pass an HTTP URL for Telegram to get a file from the Internet,
     * or pass “attach://&lt;file_attach_name>&gt; to upload a new one using multipart/form-data under
     * &lt;file_attach_name&gt; name
     */
    @SerializedName("media")
    private final String media;

    /**
     * Optional. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is
     * supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size.
     * A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded
     * using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file,
     * so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using
     * multipart/form-data under &lt;file_attach_name&gt;.
     */
    @SerializedName("thumbnail")
    private String thumbnail;

    /**
     * Optional. Caption of the photo to be sent, 0-1024 characters after entities parsing
     */
    @SerializedName("caption")
    @Nullable
    private String caption;

    /**
     * Optional. Mode for parsing entities in the caption
     * @see ParseMode
     */
    @SerializedName("parse_mode")
    @Nullable
    private String parseMode;

    /**
     * Optional. List of special entities that appear in the caption, which can be specified
     * instead of parse_mode
     */
    @SerializedName("caption_entities")
    @Nullable
    private List<MessageEntity> captionEntities;

    /**
     * Attached thumbnails
     */
    @Getter
    private final transient  Map<String, Object> attachments;

    /**
     * Media file, if type of constructor parameter "media" is java.io.File or byte[]
     */
    @Getter
    private transient InputFile inputFile;

    /**
     * Generated attach name of inputFile
     */
    @Getter
    private transient String inputFileAttachName;

    /**
     * Name of inputFile if present, or default file name
     */
    private transient String fileName;

    /**
     * Mime type of inputFile if present, or default file name
     */
    private transient String contentType;

    InputMedia(String type, Object media) {
        this.type = type;
        this.attachments = new HashMap<>();
        if (media instanceof String m) {
            this.media = m;
        } else {
            this.inputFileAttachName = UniqueNameGenerator.next(NAME_GENERATOR_PREFIX);
            this.media = Constant.TELEGRAM_ATTACH_TAG + inputFileAttachName;
            if (media instanceof File f) {
                this.fileName = f.getName();
                this.inputFile = new InputFile(f, getFileName(), getContentType());
            } else if (media instanceof byte[] b) {
                this.inputFile = new InputFile(b, getFileName(), getContentType());
            } else {
                throw new WrongParameterTypeException("Type of parameter \"media\" must be String, " +
                        "java.io.File or byte[]");
            }
        }
    }

    //region API

    /**
     * Attach thumbnail
     * @param thumbnail thumbnail as {@link File}
     * @return this (T extends InputMedia)
     */
    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T thumbnail(File thumbnail) {
        String attachName = UniqueNameGenerator.next(NAME_GENERATOR_PREFIX);
        attachments.put(attachName, thumbnail);
        this.thumbnail = Constant.TELEGRAM_ATTACH_TAG + attachName;
        return (T) this;
    }

    /**
     * Attach thumbnail
     * @param thumbnail thumbnail as byte array
     * @return this (T extends InputMedia)
     */
    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T thumbnail(byte[] thumbnail) {
        String attachName = UniqueNameGenerator.next(NAME_GENERATOR_PREFIX);
        attachments.put(attachName, thumbnail);
        this.thumbnail = Constant.TELEGRAM_ATTACH_TAG + attachName;
        return (T) this;
    }

    /**
     * Set caption
     * @param caption new caption
     * @return this (T extends InputMedia)
     */
    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T caption(String caption) {
        this.caption = caption;
        return (T) this;
    }

    /**
     * Mode for parsing entities in the caption
     * @param parseMode {@link ParseMode}
     * @return this (T extends InputMedia)
     */
    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T parseMode(ParseMode parseMode) {
        this.parseMode = parseMode.name();
        return (T) this;
    }

    /**
     * Set special entities that appear in the caption
     * @apiNote instead of parseMode
     * @param entities caption entities as {@link MessageEntity}
     * @return this (T extends InputMedia)
     */
    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T captionEntities(MessageEntity... entities) {
        this.captionEntities = Arrays.asList(entities);
        return (T) this;
    }

    /**
     * Set file name of this media
     * @param fileName new file name
     * @return this (T extends InputMedia)
     */
    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T fileName(String fileName) {
        if (inputFile != null) {
            inputFile.setFileName(fileName);
        }
        this.fileName = fileName;
        return (T) this;
    }

    /**
     * Set content type of this media
     * @param contentType new content type
     * @return this (T extends InputMedia)
     */
    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T contentType(String contentType) {
        if (inputFile != null) {
            inputFile.setContentType(contentType);
        }
        this.contentType = contentType;
        return (T) this;
    }

    /**
     * @return file name of this media if present or default file name
     */
    public String getFileName() {
        return (fileName != null && !fileName.isEmpty()) ? fileName : getDefaultFileName();
    }

    /**
     * @return content (mime) type of this media if present or default content type
     */
    public String getContentType() {
        return (contentType != null && !contentType.isEmpty()) ? contentType : getDefaultContentType();
    }

    /**
     * @return default file name for this media
     */
    protected abstract String getDefaultFileName();

    /**
     * @return default content (mime) type for this media
     */
    protected abstract String getDefaultContentType();

    //endregion
}