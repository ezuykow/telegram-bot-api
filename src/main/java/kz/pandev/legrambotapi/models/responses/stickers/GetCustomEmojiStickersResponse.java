package kz.pandev.legrambotapi.models.responses.stickers;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.stickers.Sticker;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Telegram bot API server response to GetCustomEmojiStickers request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetCustomEmojiStickersResponse extends Response {

    /**
     * Result as {@link List} of {@link Sticker}
     */
    @SerializedName("result")
    private List<Sticker> stickers;
}