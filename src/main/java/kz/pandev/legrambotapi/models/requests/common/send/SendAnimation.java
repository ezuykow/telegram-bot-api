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
 * Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound).
 * On success, the sent Message is returned. Bots can currently send animation files of up to 50 MB in size,
 * this limit may be changed in the future.
 * @author ezuykow
 */
public class SendAnimation extends AbstractMultipartRequest<SendAnimation> {

    private static final String FILE_PARAM_NAME = "animation";

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param animation file_id as String to send an animation that exists on the Telegram servers, or
     *              HTTP URL as a String for Telegram to get an animation from the Internet
     */
    public SendAnimation(@NotNull Object chatId, @NotNull String animation) {
        super(chatId, animation);
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param animation new animation as {@link File}
     */
    public SendAnimation(@NotNull Object chatId, @NotNull File animation) {
        super(chatId, animation);
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param animation new animation as byte array
     */
    public SendAnimation(@NotNull Object chatId, @NotNull byte[] animation) {
        super(chatId, animation);
    }

    //region API

    /**
     * Set parameter caption
     * @param caption Animation caption (may also be used when resending animation by file_id),
     *               0-1024 characters after entities parsing
     * @return this request
     */
    public SendAnimation caption(@NotNull String caption) {
        return addParameter("caption", caption);
    }

    /**
     * Set parameter parse_mode
     * @param parseMode Mode for parsing entities in the animation caption.
     * @see ParseMode
     * @return this request
     */
    public SendAnimation parseMode(@NotNull ParseMode parseMode) {
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter caption_entities
     * @param entities List of special entities that appear in the caption, which can be specified instead of parse_mode
     * @return this request
     */
    public SendAnimation captionEntities(@NotNull List<MessageEntity> entities) {
        return addParameter("caption_entities", entities);
    }

    /**
     * Set parameter duration
     * @param duration Duration of sent animation in seconds
     * @return this request
     */
    public SendAnimation duration(int duration) {
        return addParameter("duration", duration);
    }

    /**
     * Set parameter width
     * @param width Animation width
     * @return this request
     */
    public SendAnimation width(int width) {
        return addParameter("width", width);
    }

    /**
     * Set parameter height
     * @param height Animation height
     * @return this request
     */
    public SendAnimation height(int height) {
        return addParameter("height", height);
    }

    /**
     * Set parameter has_spoiler
     * @param hasSpoiler Pass True if the animation needs to be covered with a spoiler animation
     * @return this request
     */
    public SendAnimation hasSpoiler(boolean hasSpoiler) {
        return addParameter("has_spoiler", hasSpoiler);
    }

    /**
     * @return {@link SendAnimation#FILE_PARAM_NAME}
     */
    @Override
    protected String getFileParamName() {
        return FILE_PARAM_NAME;
    }

    /**
     * @return {@link DefaultFileName#GIF} text value
     */
    @Override
    public String getDefaultFileName() {
        return DefaultFileName.GIF.getTextVal();
    }

    /**
     * @return {@link MimeType#GIF} text value
     */
    @Override
    public String getDefaultContentType() {
        return MimeType.GIF.getTextVal();
    }

    //endregion
}