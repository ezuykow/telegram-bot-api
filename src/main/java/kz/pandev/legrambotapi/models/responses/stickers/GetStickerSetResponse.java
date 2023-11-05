package kz.pandev.legrambotapi.models.responses.stickers;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.stickers.StickerSet;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to GetStickerSet request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetStickerSetResponse extends Response {

    /**
     * Result as {@link StickerSet}
     */
    @SerializedName("result")
    private StickerSet stickerSet;
}