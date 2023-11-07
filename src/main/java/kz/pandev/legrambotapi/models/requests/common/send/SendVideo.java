package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.AbstractMultipartRequest;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.DefaultFileName;
import kz.pandev.legrambotapi.utils.enums.MimeType;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.List;

/**
 * Use this method to send video files, Telegram clients support MPEG4 videos (other formats may be sent as Document).
 * On success, the sent Message is returned. Bots can currently send video files of up to 50 MB in size,
 * this limit may be changed in the future.
 * @author ezuykow
 */
@Getter
public class SendVideo extends AbstractMultipartRequest<SendVideo> {

    private static final String FILE_PARAM_NAME = "video";

    /**
     * Optional. Video caption (may also be used when resending videos by file_id),
     * 0-1024 characters after entities parsing
     */
    @Nullable
    private String caption;
    /**
     * Optional. Mode for parsing entities in the video caption
     */
    @Nullable
    private ParseMode parseMode;
    /**
     * Optional. List of special entities that appear in the caption, which can be specified instead of parse_mode
     */
    @Nullable
    private List<MessageEntity> captionEntities;
    /**
     * Optional. Duration of sent video in seconds
     */
    @Nullable
    private Integer duration;
    /**
     * Optional. Video width
     */
    @Nullable
    private Integer width;
    /**
     * Optional. Video height
     */
    @Nullable
    private Integer height;
    /**
     * Optional. Pass True if the uploaded video is suitable for streaming
     */
    @Nullable
    private Boolean supportsStreaming;
    /**
     * Optional. Pass True if the video needs to be covered with a spoiler animation
     */
    @Nullable
    private Boolean hasSpoiler;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param video file_id as String to send a video that exists on the Telegram servers, or
     *              HTTP URL as a String for Telegram to get a video from the Internet
     */
    public SendVideo(@NotNull Object chatId, @NotNull String video) {
        super(chatId, video);
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param video new video as {@link File}
     */
    public SendVideo(@NotNull Object chatId, @NotNull File video) {
        super(chatId, video);
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param video new video as byte array
     */
    public SendVideo(@NotNull Object chatId, @NotNull byte[] video) {
        super(chatId, video);
    }

    //region API

    /**
     * Set parameter {@link SendVideo#caption}
     * @param caption new parameter value
     * @return this request
     */
    public SendVideo caption(@NotNull String caption) {
        this.caption = caption;
        return addParameter("caption", caption);
    }

    /**
     * Set parameter {@link SendVideo#parseMode}
     * @param parseMode new parameter value
     * @return this request
     */
    public SendVideo parseMode(@NotNull ParseMode parseMode) {
        this.parseMode = parseMode;
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter {@link SendVideo#captionEntities}
     * @param entities new parameter value
     * @return this request
     */
    public SendVideo captionEntities(@NotNull List<MessageEntity> entities) {
        this.captionEntities = entities;
        return addParameter("caption_entities", entities);
    }

    /**
     * Set parameter {@link SendVideo#duration}
     * @param duration new parameter value
     * @return this request
     */
    public SendVideo duration(int duration) {
        this.duration = duration;
        return addParameter("duration", duration);
    }

    /**
     * Set parameter {@link SendVideo#width}
     * @param width new parameter value
     * @return this request
     */
    public SendVideo width(int width) {
        this.width = width;
        return addParameter("width", width);
    }

    /**
     * Set parameter {@link SendVideo#height}
     * @param height new parameter value
     * @return this request
     */
    public SendVideo height(int height) {
        this.height = height;
        return addParameter("height", height);
    }

    /**
     * Set parameter {@link SendVideo#supportsStreaming}
     * @param supportsStreaming new parameter value
     * @return this request
     */
    public SendVideo supportsStreaming(boolean supportsStreaming) {
        this.supportsStreaming = supportsStreaming;
        return addParameter("supports_streaming", supportsStreaming);
    }

    /**
     * Set parameter {@link SendVideo#hasSpoiler}
     * @param hasSpoiler new parameter value
     * @return this request
     */
    public SendVideo hasSpoiler(boolean hasSpoiler) {
        this.hasSpoiler = hasSpoiler;
        return addParameter("has_spoiler", hasSpoiler);
    }

    /**
     * Set parameter {@link AbstractMultipartRequest#thumbnail}
     * @param thumbnail new parameter value as java.io.File or byte array
     * @return this request
     * @throws WrongParameterTypeException when type of thumbnail not java.io.File or byte[]
     */
    @Override
    public SendVideo thumbnail(@NotNull Object thumbnail) {
        if (thumbnail instanceof File || thumbnail instanceof byte[]) {
            return super.thumbnail(thumbnail);
        } else {
            throw new WrongParameterTypeException("Type of parameter thumbnail should be java.io.File or byte[]");
        }
    }

    /**
     * @return {@link SendVideo#FILE_PARAM_NAME}
     */
    @Override
    protected String getFileParamName() {
        return FILE_PARAM_NAME;
    }

    /**
     * @return {@link DefaultFileName#VIDEO} text value
     */
    @Override
    public String getDefaultFileName() {
        return DefaultFileName.VIDEO.getTextVal();
    }

    /**
     * @return {@link MimeType#VIDEO} text value
     */
    @Override
    public String getDefaultContentType() {
        return MimeType.VIDEO.getTextVal();
    }

    //endregion
}