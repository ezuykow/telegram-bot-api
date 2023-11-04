package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.AbstractMultipartRequest;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.DefaultFileName;
import kz.pandev.legrambotapi.utils.MimeType;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.List;

/**
 * Use this method to send general files. On success, the sent Message is returned. Bots can currently send
 * files of any type of up to 50 MB in size, this limit may be changed in the future.
 * @author ezuykow
 */
@Getter
public class SendDocument extends AbstractMultipartRequest<SendDocument> {

    private static final String FILE_PARAM_NAME = "document";

    /**
     * Optional. Document caption (may also be used when resending documents by file_id),
     * 0-1024 characters after entities parsing
     */
    @Nullable
    private String caption;
    /**
     * Optional. Mode for parsing entities in the document caption.
     */
    @Nullable
    private ParseMode parseMode;
    /**
     * Optional. List of special entities that appear in the caption, which can be specified instead of parse_mode
     */
    @Nullable
    private List<MessageEntity> captionEntities;
    /**
     * Optional. Disables automatic server-side content type detection for files uploaded using multipart/form-data
     */
    @Nullable
    private Boolean disableContentTypeDetection;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param document file_id as String to send a document that exists on the Telegram servers, or
     *              HTTP URL as a String for Telegram to get a document from the Internet
     */
    public SendDocument(@NotNull Object chatId, @NotNull String document) {
        super(chatId, document);
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param document new document as {@link File}
     */
    public SendDocument(@NotNull Object chatId, @NotNull File document) {
        super(chatId, document);
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param document new document as byte array
     */
    public SendDocument(@NotNull Object chatId, @NotNull byte[] document) {
        super(chatId, document);
    }

    //region API

    /**
     * Set parameter {@link SendDocument#caption}
     * @param caption new parameter value
     * @return this request
     */
    public SendDocument caption(@NotNull String caption) {
        this.caption = caption;
        return addParameter("caption", caption);
    }

    /**
     * Set parameter {@link SendDocument#parseMode}
     * @param parseMode new parameter value
     * @return this request
     */
    public SendDocument parseMode(@NotNull ParseMode parseMode) {
        this.parseMode = parseMode;
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter {@link SendDocument#captionEntities}
     * @param entities new parameter value
     * @return this request
     */
    public SendDocument captionEntities(@NotNull List<MessageEntity> entities) {
        this.captionEntities = entities;
        return addParameter("caption_entities", entities);
    }

    /**
     * Set parameter {@link SendDocument#disableContentTypeDetection}
     * @param disableContentTypeDetection new parameter value
     * @return this request
     */
    public SendDocument disableContentTypeDetection(boolean disableContentTypeDetection) {
        this.disableContentTypeDetection = disableContentTypeDetection;
        return addParameter("disable_content_type_detection", disableContentTypeDetection);
    }

    /**
     * Set parameter {@link AbstractMultipartRequest#thumbnail}
     * @param thumbnail new parameter value as java.io.File or byte array
     * @return this request
     * @throws WrongParameterTypeException when type of thumbnail not java.io.File or byte[]
     */
    public SendDocument thumbnail(@NotNull Object thumbnail) {
        if (thumbnail instanceof File || thumbnail instanceof byte[]) {
            return super.thumbnail(thumbnail);
        } else {
            throw new WrongParameterTypeException("Type of parameter thumbnail should be java.io.File or byte[]");
        }
    }

    /**
     * @return {@link SendDocument#FILE_PARAM_NAME}
     */
    @Override
    protected String getFileParamName() {
        return FILE_PARAM_NAME;
    }

    /**
     * @return {@link DefaultFileName#DOC_FILE_NAME}
     */
    @Override
    public String getDefaultFileName() {
        return DefaultFileName.DOC_FILE_NAME;
    }

    /**
     * @return {@link MimeType#DOC_MIME_TYPE}
     */
    @Override
    public String getDefaultContentType() {
        return MimeType.DOC_MIME_TYPE;
    }

    //endregion
}