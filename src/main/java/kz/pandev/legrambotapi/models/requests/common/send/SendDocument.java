package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractMultipartRequest;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.DefaultFileName;
import kz.pandev.legrambotapi.utils.enums.MimeType;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

/**
 * Use this method to send general files. On success, the sent Message is returned. Bots can currently send
 * files of any type of up to 50 MB in size, this limit may be changed in the future.
 * @author ezuykow
 */
public class SendDocument extends AbstractMultipartRequest<SendDocument> {

    private static final String FILE_PARAM_NAME = "document";

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
     * Set parameter caption
     * @param caption Document caption (may also be used when resending documents by file_id), 0-1024 characters
     *               after entities parsing
     * @return this request
     */
    public SendDocument caption(@NotNull String caption) {
        return addParameter("caption", caption);
    }

    /**
     * Set parameter parse_mode
     * @param parseMode Mode for parsing entities in the document caption.
     * @see ParseMode
     * @return this request
     */
    public SendDocument parseMode(@NotNull ParseMode parseMode) {
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter caption_entities
     * @param entities List of special entities that appear in the caption, which can be specified instead of parse_mode
     * @return this request
     */
    public SendDocument captionEntities(@NotNull List<MessageEntity> entities) {
        return addParameter("caption_entities", entities);
    }

    /**
     * Set parameter disable_content_type_detection
     * @param disableContentTypeDetection Disables automatic server-side content type detection for files uploaded
     *                                   using multipart/form-data
     * @return this request
     */
    public SendDocument disableContentTypeDetection(boolean disableContentTypeDetection) {
        return addParameter("disable_content_type_detection", disableContentTypeDetection);
    }

    /**
     * @return {@link SendDocument#FILE_PARAM_NAME}
     */
    @Override
    protected String getFileParamName() {
        return FILE_PARAM_NAME;
    }

    /**
     * @return {@link DefaultFileName#DOC} text value
     */
    @Override
    public String getDefaultFileName() {
        return DefaultFileName.DOC.getTextVal();
    }

    /**
     * @return {@link MimeType#DOC} text value
     */
    @Override
    public String getDefaultContentType() {
        return MimeType.DOC.getTextVal();
    }

    //endregion
}