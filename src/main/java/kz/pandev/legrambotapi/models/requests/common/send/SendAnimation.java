package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.AbstractMultipartRequest;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.DefaultFileName;
import kz.pandev.legrambotapi.utils.MimeType;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

/**
 * Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound).
 * On success, the sent Message is returned. Bots can currently send animation files of up to 50 MB in size,
 * this limit may be changed in the future.
 * @author ezuykow
 */
@Getter
public class SendAnimation extends AbstractMultipartRequest<SendAnimation> {

    private static final String FILE_PARAM_NAME = "animation";

    /**
     * Optional. Animation caption (may also be used when resending animation by file_id),
     * 0-1024 characters after entities parsing
     */
    private String caption;
    /**
     * Optional. Mode for parsing entities in the animation caption.
     */
    private ParseMode parseMode;
    /**
     * Optional. List of special entities that appear in the caption, which can be specified instead of parse_mode
     */
    private List<MessageEntity> captionEntities;
    /**
     * Optional. Duration of sent animation in seconds
     */
    private Integer duration;
    /**
     * Optional. Animation width
     */
    private Integer width;
    /**
     * Optional. Animation height
     */
    private Integer height;
    /**
     * Optional. Pass True if the animation needs to be covered with a spoiler animation
     */
    private Boolean hasSpoiler;

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
     * Set parameter {@link SendAnimation#caption}
     * @param caption new parameter value
     * @return this request
     */
    public SendAnimation caption(@NotNull String caption) {
        this.caption = caption;
        return addParameter("caption", caption);
    }

    /**
     * Set parameter {@link SendAnimation#parseMode}
     * @param parseMode new parameter value
     * @return this request
     */
    public SendAnimation parseMode(@NotNull ParseMode parseMode) {
        this.parseMode = parseMode;
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter {@link SendAnimation#captionEntities}
     * @param entities new parameter value
     * @return this request
     */
    public SendAnimation captionEntities(@NotNull List<MessageEntity> entities) {
        this.captionEntities = entities;
        return addParameter("caption_entities", entities);
    }

    /**
     * Set parameter {@link SendAnimation#duration}
     * @param duration new parameter value
     * @return this request
     */
    public SendAnimation duration(int duration) {
        this.duration = duration;
        return addParameter("duration", duration);
    }

    /**
     * Set parameter {@link SendAnimation#width}
     * @param width new parameter value
     * @return this request
     */
    public SendAnimation width(int width) {
        this.width = width;
        return addParameter("width", width);
    }

    /**
     * Set parameter {@link SendAnimation#height}
     * @param height new parameter value
     * @return this request
     */
    public SendAnimation height(int height) {
        this.height = height;
        return addParameter("height", height);
    }

    /**
     * Set parameter {@link SendAnimation#hasSpoiler}
     * @param hasSpoiler new parameter value
     * @return this request
     */
    public SendAnimation hasSpoiler(boolean hasSpoiler) {
        this.hasSpoiler = hasSpoiler;
        return addParameter("has_spoiler", hasSpoiler);
    }

    /**
     * Set parameter {@link AbstractMultipartRequest#thumbnail}
     * @param thumbnail new parameter value as java.io.File or byte array
     * @return this request
     * @throws WrongParameterTypeException when type of thumbnail not java.io.File or byte[]
     */
    public SendAnimation thumbnail(@NotNull Object thumbnail) {
        if (thumbnail instanceof File || thumbnail instanceof byte[]) {
            return super.thumbnail(thumbnail);
        } else {
            throw new WrongParameterTypeException("Type of parameter thumbnail should be java.io.File or byte[]");
        }
    }

    /**
     * @return {@link SendAnimation#FILE_PARAM_NAME}
     */
    @Override
    protected String getFileParamName() {
        return FILE_PARAM_NAME;
    }

    /**
     * @return {@link DefaultFileName#GIF_FILE_NAME}
     */
    @Override
    public String getDefaultFileName() {
        return DefaultFileName.GIF_FILE_NAME;
    }

    /**
     * @return {@link MimeType#GIF_MIME_TYPE}
     */
    @Override
    public String getDefaultContentType() {
        return MimeType.GIF_MIME_TYPE;
    }

    //endregion
}