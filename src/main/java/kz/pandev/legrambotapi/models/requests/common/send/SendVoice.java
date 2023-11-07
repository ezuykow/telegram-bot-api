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
 * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message.
 * For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as Audio
 * or Document). On success, the sent Message is returned. Bots can currently send voice messages of up to 50 MB
 * in size, this limit may be changed in the future.
 * @author ezuykow
 */
@Getter
public class SendVoice extends AbstractMultipartRequest<SendVoice> {

    private static final String FILE_PARAM_NAME = "voice";

    /**
     * Optional. Voice message caption, 0-1024 characters after entities parsing
     */
    @Nullable
    private String caption;
    /**
     * Optional. Mode for parsing entities in the voice message caption
     */
    @Nullable
    private ParseMode parseMode;
    /**
     * Optional. List of special entities that appear in the caption, which can be specified instead of parse_mode
     */
    @Nullable
    private List<MessageEntity> captionEntities;
    /**
     * Optional. Duration of the voice message in seconds
     */
    @Nullable
    private Integer duration;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param voice file_id as String to send a voice that exists on the Telegram servers, or
     *              HTTP URL as a String for Telegram to get a voice from the Internet
     */
    public SendVoice(@NotNull Object chatId, @NotNull String voice) {
        super(chatId, voice);
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param voice new voice as {@link File}
     */
    public SendVoice(@NotNull Object chatId, @NotNull File voice) {
        super(chatId, voice);
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param voice new voice as byte array
     */
    public SendVoice(@NotNull Object chatId, @NotNull byte[] voice) {
        super(chatId, voice);
    }

    //region API

    /**
     * Set parameter {@link SendVoice#caption}
     * @param caption new parameter value
     * @return this request
     */
    public SendVoice caption(@NotNull String caption) {
        this.caption = caption;
        return addParameter("caption", caption);
    }

    /**
     * Set parameter {@link SendVoice#parseMode}
     * @param parseMode new parameter value
     * @return this request
     */
    public SendVoice parseMode(@NotNull ParseMode parseMode) {
        this.parseMode = parseMode;
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter {@link SendVoice#captionEntities}
     * @param entities new parameter value
     * @return this request
     */
    public SendVoice captionEntities(@NotNull List<MessageEntity> entities) {
        this.captionEntities = entities;
        return addParameter("caption_entities", entities);
    }

    /**
     * Set parameter {@link SendVoice#duration}
     * @param duration new parameter value
     * @return this request
     */
    public SendVoice duration(int duration) {
        this.duration = duration;
        return addParameter("duration", duration);
    }

    /**
     * Set parameter {@link AbstractMultipartRequest#thumbnail}
     * @param thumbnail new parameter value as java.io.File or byte array
     * @return this request
     * @throws WrongParameterTypeException when type of thumbnail not java.io.File or byte[]
     */
    @Override
    public SendVoice thumbnail(@NotNull Object thumbnail) {
        if (thumbnail instanceof File || thumbnail instanceof byte[]) {
            return super.thumbnail(thumbnail);
        } else {
            throw new WrongParameterTypeException("Type of parameter thumbnail should be java.io.File or byte[]");
        }
    }

    /**
     * @return {@link SendVoice#FILE_PARAM_NAME}
     */
    @Override
    protected String getFileParamName() {
        return FILE_PARAM_NAME;
    }

    /**
     * @return {@link DefaultFileName#VOICE} text value
     */
    @Override
    public String getDefaultFileName() {
        return DefaultFileName.VOICE.getTextVal();
    }

    /**
     * @return {@link MimeType#VOICE} text value
     */
    @Override
    public String getDefaultContentType() {
        return MimeType.VOICE.getTextVal();
    }

    //endregion
}