package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.AbstractMultipartRequest;
import kz.pandev.legrambotapi.utils.enums.DefaultFileName;
import kz.pandev.legrambotapi.utils.enums.MimeType;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to send static .WEBP, animated .TGS, or video .WEBM stickers.
 * On success, the sent Message is returned.
 * @author ezuykow
 */
public class SendSticker extends AbstractMultipartRequest<SendSticker> {

    private static final String FILE_PARAM_NAME = "sticker";

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
     * Set parameter emoji
     * @param emoji Emoji associated with the sticker; only for just uploaded stickers
     * @return this request
     */
    public SendSticker emoji(@NotNull String emoji) {
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
     * @return {@link DefaultFileName#PHOTO} text value
     */
    @Override
    public String getDefaultFileName() {
        return DefaultFileName.PHOTO.getTextVal();
    }

    /**
     * @return {@link MimeType#PHOTO} text value
     */
    @Override
    public String getDefaultContentType() {
        return MimeType.PHOTO.getTextVal();
    }

    //endregion
}