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
 * Use this method to send photos. On success, the sent Message is returned.
 * @author ezuykow
 */
public class SendPhoto extends AbstractMultipartRequest<SendPhoto> {

    private static final String FILE_PARAM_NAME = "photo";

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param photo file_id as String to send a photo that exists on the Telegram servers, or
     *              HTTP URL as a String for Telegram to get a photo from the Internet
     */
    public SendPhoto(@NotNull Object chatId, @NotNull String photo) {
        super(chatId, photo);
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param photo new photo as {@link File}
     */
    public SendPhoto(@NotNull Object chatId, @NotNull File photo) {
        super(chatId, photo);
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param photo new photo as byte array
     */
    public SendPhoto(@NotNull Object chatId, @NotNull byte[] photo) {
        super(chatId, photo);
    }

    //region API

    /**
     * Set parameter caption
     * @param caption Photo caption (may also be used when resending photos by file_id), 0-1024 characters
     *               after entities parsing
     * @return this request
     */
    public SendPhoto caption(@NotNull String caption) {
        return addParameter("caption", caption);
    }

    /**
     * Set parameter parse_mode
     * @param parseMode Mode for parsing entities in the photo caption.
     * @see ParseMode
     * @return this request
     */
    public SendPhoto parseMode(@NotNull ParseMode parseMode) {
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter caption_entities
     * @param entities List of special entities that appear in the caption, which can be specified instead of parse_mode
     * @return this request
     */
    public SendPhoto captionEntities(@NotNull List<MessageEntity> entities) {
        return addParameter("caption_entities", entities);
    }

    /**
     * Set parameter has_spoiler
     * @param hasSpoiler Pass True if the photo needs to be covered with a spoiler animation
     * @return this request
     */
    public SendPhoto hasSpoiler(boolean hasSpoiler) {
        return addParameter("has_spoiler", hasSpoiler);
    }

    /**
     * @return {@link SendPhoto#FILE_PARAM_NAME}
     */
    @Override
    protected String getFileParamName() {
        return FILE_PARAM_NAME;
    }

    /**
     * @return {@link DefaultFileName#PHOTO} text value
     */
    @Override
    public String getDefaultFileName() {
        return DefaultFileName.PHOTO.getTextVal();
    }

    /**
     * @return {@link MimeType#PHOTO} text value
     */
    @Override
    public String getDefaultContentType() {
        return MimeType.PHOTO.getTextVal();
    }

    //endregion
}