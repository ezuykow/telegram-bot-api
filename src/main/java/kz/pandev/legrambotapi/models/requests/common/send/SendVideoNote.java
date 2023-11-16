package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractMultipartRequest;
import kz.pandev.legrambotapi.utils.enums.DefaultFileName;
import kz.pandev.legrambotapi.utils.enums.MimeType;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * As of v.4.0, Telegram clients support rounded square MPEG4 videos of up to 1 minute long.
 * Use this method to send video messages. On success, the sent Message is returned.
 * @author ezuykow
 */
public class SendVideoNote extends AbstractMultipartRequest<SendVideoNote> {

    private static final String FILE_PARAM_NAME = "video_note";

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
     * Set parameter duration
     * @param duration Duration of sent video in seconds
     * @return this request
     */
    public SendVideoNote duration(int duration) {
        return addParameter("duration", duration);
    }

    /**
     * Set parameter length
     * @param length Video width and height, i.e. diameter of the video message
     * @return this request
     */
    public SendVideoNote length(int length) {
        return addParameter("length", length);
    }

    /**
     * @return {@link SendVideoNote#FILE_PARAM_NAME}
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