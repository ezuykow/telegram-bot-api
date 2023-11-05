package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.AbstractMultipartRequest;
import kz.pandev.legrambotapi.utils.DefaultFileName;
import kz.pandev.legrambotapi.utils.MimeType;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to send static .WEBP, animated .TGS, or video .WEBM stickers.
 * On success, the sent Message is returned.
 * @author ezuykow
 */
@Getter
public class SendSticker extends AbstractMultipartRequest<SendSticker> {

    private static final String FILE_PARAM_NAME = "sticker";

    /**
     * Optional. Emoji associated with the sticker; only for just uploaded stickers
     */
    @Nullable
    private String emoji;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param sticker Sticker to send. String if it's a file_id of file that exists on the Telegram servers or HTTP URL
     *                for Telegram to get a .WEBP sticker from the Internet; java.io.File or byte[] if it's a
     *                new .WEBP or .TGS sticker
     * @apiNote Video stickers can only be sent by a file_id. Animated stickers can't be sent via an HTTP URL.
     */
    public SendSticker(@NotNull Object chatId, @NotNull Object sticker) {
        super(chatId, sticker);
    }

    //region API

    /**
     * Set parameter {@link SendSticker#emoji}
     * @param emoji new parameter value
     * @return this request
     */
    public SendSticker emoji(String emoji) {
        this.emoji = emoji;
        return addParameter("emoji", emoji);
    }

    /**
     * @return {@link SendSticker#FILE_PARAM_NAME}
     */
    @Override
    protected String getFileParamName() {
        return FILE_PARAM_NAME;
    }

    /**
     * @return {@link DefaultFileName#PHOTO_FILE_NAME}
     */
    @Override
    public String getDefaultFileName() {
        return DefaultFileName.PHOTO_FILE_NAME;
    }

    /**
     * @return {@link MimeType#PHOTO_MIME_TYPE}
     */
    @Override
    public String getDefaultContentType() {
        return MimeType.PHOTO_MIME_TYPE;
    }

    //endregion
}