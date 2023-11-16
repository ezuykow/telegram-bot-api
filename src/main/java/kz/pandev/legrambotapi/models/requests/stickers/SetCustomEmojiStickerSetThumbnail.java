package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to set the thumbnail of a custom emoji sticker set. Returns True on success.
 * @author ezuykow
 */
public class SetCustomEmojiStickerSetThumbnail extends Request<SetCustomEmojiStickerSetThumbnail, Response> {

    /**
     * @param name Sticker set name
     */
    public SetCustomEmojiStickerSetThumbnail(@NotNull String name) {
        super(Response.class);
        addParameter("name", name);
    }

    //region API

    /**
     * Set parameter custom_emoji_id
     * @param customEmojiId Custom emoji identifier of a sticker from the sticker set; pass an empty string to drop
     *                     the thumbnail and use the first sticker as the thumbnail.
     * @return this request
     */
    public SetCustomEmojiStickerSetThumbnail customEmojiId(@NotNull String customEmojiId) {
        return addParameter("custom_emoji_id", customEmojiId);
    }

    //endregion
}