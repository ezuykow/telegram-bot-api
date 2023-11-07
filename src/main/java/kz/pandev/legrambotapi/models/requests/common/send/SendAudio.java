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
 * Use this method to send audio files, if you want Telegram clients to display them in the music player.
 * Your audio must be in the .MP3 or .M4A format. On success, the sent Message is returned.
 * Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
 * @author ezuykow
 */
@Getter
public class SendAudio extends AbstractMultipartRequest<SendAudio> {

    private static final String FILE_PARAM_NAME = "audio";

    /**
     * Optional. Audio caption, 0-1024 characters after entities parsing
     */
    @Nullable
    private String caption;
    /**
     * Optional. Mode for parsing entities in the audio caption.
     */
    @Nullable
    private ParseMode parseMode;
    /**
     * Optional. List of special entities that appear in the caption, which can be specified instead of parse_mode
     */
    @Nullable
    private List<MessageEntity> captionEntities;
    /**
     * Optional. Duration of the audio in seconds
     */
    @Nullable
    private Integer duration;
    /**
     * Optional. Performer
     */
    @Nullable
    private String performer;
    /**
     * Optional. Track name
     */
    @Nullable
    private String title;

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
     * Set parameter {@link SendAudio#caption}
     * @param caption new parameter value
     * @return this request
     */
    public SendAudio caption(@NotNull String caption) {
        this.caption = caption;
        return addParameter("caption", caption);
    }

    /**
     * Set parameter {@link SendAudio#parseMode}
     * @param parseMode new parameter value
     * @return this request
     */
    public SendAudio parseMode(@NotNull ParseMode parseMode) {
        this.parseMode = parseMode;
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter {@link SendAudio#captionEntities}
     * @param entities new parameter value
     * @return this request
     */
    public SendAudio captionEntities(@NotNull List<MessageEntity> entities) {
        this.captionEntities = entities;
        return addParameter("caption_entities", entities);
    }

    /**
     * Set parameter {@link SendAudio#duration}
     * @param duration new parameter value
     * @return this request
     */
    public SendAudio duration(int duration) {
        this.duration = duration;
        return addParameter("duration", duration);
    }

    /**
     * Set parameter {@link SendAudio#performer}
     * @param performer new parameter value
     * @return this request
     */
    public SendAudio performer(@NotNull String performer) {
        this.performer = performer;
        return addParameter("performer", performer);
    }

    /**
     * Set parameter {@link SendAudio#title}
     * @param title new parameter value
     * @return this request
     */
    public SendAudio title(@NotNull String title) {
        this.title = title;
        return addParameter("title", title);
    }

    /**
     * Set parameter {@link AbstractMultipartRequest#thumbnail}
     * @param thumbnail new parameter value as java.io.File or byte array
     * @return this request
     * @throws WrongParameterTypeException when type of thumbnail not java.io.File or byte[]
     */
    @Override
    public SendAudio thumbnail(@NotNull Object thumbnail) {
        if (thumbnail instanceof File || thumbnail instanceof byte[]) {
            return super.thumbnail(thumbnail);
        } else {
            throw new WrongParameterTypeException("Type of parameter thumbnail should be java.io.File or byte[]");
        }
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