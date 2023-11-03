package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.AbstractMultipartRequest;
import kz.pandev.legrambotapi.utils.DefaultFileName;
import kz.pandev.legrambotapi.utils.MimeType;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * As of v.4.0, Telegram clients support rounded square MPEG4 videos of up to 1 minute long.
 * Use this method to send video messages. On success, the sent Message is returned.
 * @author ezuykow
 */
@Getter
public class SendVideoNote extends AbstractMultipartRequest<SendVideoNote> {

    private static final String FILE_PARAM_NAME = "video_note";

    /**
     * Optional. Duration of sent video in seconds
     */
    private Integer duration;
    /**
     * Optional. Video width and height, i.e. diameter of the video message
     */
    private Integer length;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param videoNote file_id as String to send a videoNote that exists on the Telegram servers, or
     *              HTTP URL as a String for Telegram to get a videoNote from the Internet
     */
    public SendVideoNote(@NotNull Object chatId, @NotNull String videoNote) {
        super(chatId, videoNote);
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param videoNote new videoNote as {@link File}
     */
    public SendVideoNote(@NotNull Object chatId, @NotNull File videoNote) {
        super(chatId, videoNote);
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param videoNote new videoNote as byte array
     */
    public SendVideoNote(@NotNull Object chatId, @NotNull byte[] videoNote) {
        super(chatId, videoNote);
    }

    //region API

    /**
     * Set parameter {@link SendVideoNote#duration}
     * @param duration new parameter value
     * @return this request
     */
    public SendVideoNote duration(int duration) {
        this.duration = duration;
        return addParameter("duration", duration);
    }

    /**
     * Set parameter {@link SendVideoNote#length}
     * @param length new parameter value
     * @return this request
     */
    public SendVideoNote length(int length) {
        this.length = length;
        return addParameter("length", length);
    }

    /**
     * Set parameter {@link AbstractMultipartRequest#thumbnail}
     * @param thumbnail new parameter value as java.io.File or byte array
     * @return this request
     * @throws WrongParameterTypeException when type of thumbnail not java.io.File or byte[]
     */
    public SendVideoNote thumbnail(@NotNull Object thumbnail) {
        if (thumbnail instanceof File || thumbnail instanceof byte[]) {
            return super.thumbnail(thumbnail);
        } else {
            throw new WrongParameterTypeException("Type of parameter thumbnail should be java.io.File or byte[]");
        }
    }

    /**
     * @return {@link SendVideoNote#FILE_PARAM_NAME}
     */
    @Override
    protected String getFileParamName() {
        return FILE_PARAM_NAME;
    }

    /**
     * @return {@link DefaultFileName#VIDEO_FILE_NAME}
     */
    @Override
    public String getDefaultFileName() {
        return DefaultFileName.VIDEO_FILE_NAME;
    }

    /**
     * @return {@link MimeType#VIDEO_MIME_TYPE}
     */
    @Override
    public String getDefaultContentType() {
        return MimeType.VIDEO_MIME_TYPE;
    }

    //endregion
}