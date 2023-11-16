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
 * Use this method to send audio files, if you want Telegram clients to display them in the music player.
 * Your audio must be in the .MP3 or .M4A format. On success, the sent Message is returned.
 * Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
 * @author ezuykow
 */
public class SendAudio extends AbstractMultipartRequest<SendAudio> {

    private static final String FILE_PARAM_NAME = "audio";

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param audio file_id as String to send an audio that exists on the Telegram servers, or
     *              HTTP URL as a String for Telegram to get an audio from the Internet
     */
    public SendAudio(@NotNull Object chatId, @NotNull String audio) {
        super(chatId, audio);
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param audio new audio as {@link File}
     */
    public SendAudio(@NotNull Object chatId, @NotNull File audio) {
        super(chatId, audio);
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param audio new audio as byte array
     */
    public SendAudio(@NotNull Object chatId, @NotNull byte[] audio) {
        super(chatId, audio);
    }

    //region API

    /**
     * Set parameter caption
     * @param caption Audio caption, 0-1024 characters after entities parsing
     * @return this request
     */
    public SendAudio caption(@NotNull String caption) {
        return addParameter("caption", caption);
    }

    /**
     * Set parameter parse_mode
     * @param parseMode Mode for parsing entities in the audio caption.
     * @see ParseMode
     * @return this request
     */
    public SendAudio parseMode(@NotNull ParseMode parseMode) {
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter caption_entities
     * @param entities List of special entities that appear in the caption, which can be specified instead of parse_mode
     * @return this request
     */
    public SendAudio captionEntities(@NotNull List<MessageEntity> entities) {
        return addParameter("caption_entities", entities);
    }

    /**
     * Set parameter duration
     * @param duration Duration of the audio in seconds
     * @return this request
     */
    public SendAudio duration(int duration) {
        return addParameter("duration", duration);
    }

    /**
     * Set parameter performer
     * @param performer Performer
     * @return this request
     */
    public SendAudio performer(@NotNull String performer) {
        return addParameter("performer", performer);
    }

    /**
     * Set parameter title
     * @param title Track name
     * @return this request
     */
    public SendAudio title(@NotNull String title) {
        return addParameter("title", title);
    }

    /**
     * @return {@link SendAudio#FILE_PARAM_NAME}
     */
    @Override
    protected String getFileParamName() {
        return FILE_PARAM_NAME;
    }

    /**
     * @return {@link DefaultFileName#AUDIO} text value
     */
    @Override
    public String getDefaultFileName() {
        return DefaultFileName.AUDIO.getTextVal();
    }

    /**
     * @return {@link MimeType#AUDIO} text value
     */
    @Override
    public String getDefaultContentType() {
        return MimeType.AUDIO.getTextVal();
    }

    //endregion
}