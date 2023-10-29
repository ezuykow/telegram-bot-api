package kz.pandev.legrambotapi.models.types.input.media;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.types.input.InputFile;
import kz.pandev.legrambotapi.models.types.message.MessageEntity;
import kz.pandev.legrambotapi.utils.ParseMode;
import kz.pandev.legrambotapi.utils.UniqueNameGenerator;
import lombok.Getter;

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
public abstract class InputMedia<T extends InputMedia<T>> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String NAME_GENERATOR_PREFIX = "InputMedia";
    private static final String TELEGRAM_ATTACH_TAG = "attach://";

    private final String type;

    private final String media;

    private String thumbnail;

    private String caption;

    private String parseMode;

    private List<MessageEntity> captionEntities;

    @Getter
    private final transient  Map<String, Object> attachments;
    @Getter
    private transient InputFile inputFile;
    @Getter
    private transient String inputFileAttachName;
    private transient String fileName;
    private transient String contentType;

    InputMedia(String type, Object media) {
        this.type = type;
        this.attachments = new HashMap<>();
        if (media instanceof String m) {
            this.media = m;
        } else {
            this.inputFileAttachName = UniqueNameGenerator.next(NAME_GENERATOR_PREFIX);
            this.media = TELEGRAM_ATTACH_TAG + inputFileAttachName;
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

    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T thumbnail(File thumbnail) {
        String attachName = UniqueNameGenerator.next(NAME_GENERATOR_PREFIX);
        attachments.put(attachName, thumbnail);
        this.thumbnail = TELEGRAM_ATTACH_TAG + attachName;
        return (T) this;
    }

    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T thumbnail(byte[] thumbnail) {
        String attachName = UniqueNameGenerator.next(NAME_GENERATOR_PREFIX);
        attachments.put(attachName, thumbnail);
        this.thumbnail = TELEGRAM_ATTACH_TAG + attachName;
        return (T) this;
    }

    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T caption(String caption) {
        this.caption = caption;
        return (T) this;
    }

    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T parseMode(ParseMode parseMode) {
        this.parseMode = parseMode.name();
        return (T) this;
    }

    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T captionEntities(MessageEntity... entities) {
        this.captionEntities = Arrays.asList(entities);
        return (T) this;
    }

    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T fileName(String fileName) {
        if (inputFile != null) {
            inputFile.setFileName(fileName);
        }
        this.fileName = fileName;
        return (T) this;
    }

    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T contentType(String contentType) {
        if (inputFile != null) {
            inputFile.setContentType(contentType);
        }
        this.contentType = contentType;
        return (T) this;
    }

    public String getFileName() {
        return (fileName != null && !fileName.isEmpty()) ? fileName : getDefaultFileName();
    }

    public String getContentType() {
        return (contentType != null && !contentType.isEmpty()) ? contentType : getDefaultContentType();
    }

    abstract protected String getDefaultFileName();

    abstract protected String getDefaultContentType();

    //endregion
}