package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.stickers.GetCustomEmojiStickersResponse;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * Use this method to get information about custom emoji stickers by their identifiers.
 * Returns an Array of Sticker objects.
 * @author ezuykow
 */
public class GetCustomEmojiStickers extends Request<GetCustomEmojiStickers, GetCustomEmojiStickersResponse> {

    /**
     * @param customEmojiIds Array of custom emoji identifiers. At most 200 custom emoji identifiers can be specified.
     */
    public GetCustomEmojiStickers(@NotNull String... customEmojiIds) {
        this(Arrays.asList(customEmojiIds));
    }

    /**
     * @param customEmojiIds List of custom emoji identifiers. At most 200 custom emoji identifiers can be specified.
     */
    public GetCustomEmojiStickers(@NotNull List<String> customEmojiIds) {
        super(GetCustomEmojiStickersResponse.class);
        addParameter("custom_emoji_ids", customEmojiIds);
    }
}