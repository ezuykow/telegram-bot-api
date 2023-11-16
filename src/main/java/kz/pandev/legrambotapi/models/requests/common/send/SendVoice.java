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
 * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message.
 * For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as Audio
 * or Document). On success, the sent Message is returned. Bots can currently send voice messages of up to 50 MB
 * in size, this limit may be changed in the future.
 * @author ezuykow
 */
public class SendVoice extends AbstractMultipartRequest<SendVoice> {

    private static final String FILE_PARAM_NAME = "voice";

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
     * Set parameter caption
     * @param caption Voice message caption, 0-1024 characters after entities parsing
     * @return this request
     */
    public SendVoice caption(@NotNull String caption) {
        return addParameter("caption", caption);
    }

    /**
     * Set parameter parse_mode
     * @param parseMode Mode for parsing entities in the voice message caption
     * @see ParseMode
     * @return this request
     */
    public SendVoice parseMode(@NotNull ParseMode parseMode) {
        return addParameter("parse_mode", parseMode.getTextVal());
    }

    /**
     * Set parameter caption_entities
     * @param entities List of special entities that appear in the caption, which can be specified instead of parse_mode
     * @return this request
     */
    public SendVoice captionEntities(@NotNull List<MessageEntity> entities) {
        return addParameter("caption_entities", entities);
    }

    /**
     * Set parameter duration
     * @param duration Duration of the voice message in seconds
     * @return this request
     */
    public SendVoice duration(int duration) {
        return addParameter("duration", duration);
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