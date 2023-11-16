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
 * Use this method to send video files, Telegram clients support MPEG4 videos (other formats may be sent as Document).
 * On success, the sent Message is returned. Bots can currently send video files of up to 50 MB in size,
 * this limit may be changed in the future.
 * @author ezuykow
 */
public class SendVideo extends AbstractMultipartRequest<SendVideo> {

    private static final String FILE_PARAM_NAME = "video";

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
     * Set parameter caption
     * @param caption Video caption (may also be used when resending videos by file_id), 0-1024 characters
     *                after entities parsing
     * @return this request
     */
    public SendVideo caption(@NotNull String caption) {
        return addParameter("caption", caption);
    }

    /**
     * Set parameter parse_mode
     * @param parseMode Mode for parsing entities in the video caption
     * @see ParseMode
     * @return this request
     */
    public SendVideo parseMode(@NotNull ParseMode parseMode) {
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter caption_entities
     * @param entities List of special entities that appear in the caption, which can be specified instead of parse_mode
     * @return this request
     */
    public SendVideo captionEntities(@NotNull List<MessageEntity> entities) {
        return addParameter("caption_entities", entities);
    }

    /**
     * Set parameter duration
     * @param duration Duration of sent video in seconds
     * @return this request
     */
    public SendVideo duration(int duration) {
        return addParameter("duration", duration);
    }

    /**
     * Set parameter width
     * @param width Video width
     * @return this request
     */
    public SendVideo width(int width) {
        return addParameter("width", width);
    }

    /**
     * Set parameter height
     * @param height Video height
     * @return this request
     */
    public SendVideo height(int height) {
        return addParameter("height", height);
    }

    /**
     * Set parameter supports_streaming
     * @param supportsStreaming Pass True if the uploaded video is suitable for streaming
     * @return this request
     */
    public SendVideo supportsStreaming(boolean supportsStreaming) {
        return addParameter("supports_streaming", supportsStreaming);
    }

    /**
     * Set parameter has_spoiler
     * @param hasSpoiler Pass True if the video needs to be covered with a spoiler animation
     * @return this request
     */
    public SendVideo hasSpoiler(boolean hasSpoiler) {
        return addParameter("has_spoiler", hasSpoiler);
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