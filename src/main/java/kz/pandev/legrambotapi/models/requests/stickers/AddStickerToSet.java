package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.AbstractUploadRequest;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.stickers.InputSticker;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to add a new sticker to a set created by the bot. The format of the added sticker must
 * match the format of the other stickers in the set. Emoji sticker sets can have up to 200 stickers.
 * Animated and video sticker sets can have up to 50 stickers. Static sticker sets can have up to 120 stickers.
 * Returns True on success.
 * @author ezuykow
 */
public class AddStickerToSet extends AbstractUploadRequest<AddStickerToSet, Response> {

    /**
     * @param userId User identifier of sticker set owner
     * @param name Sticker set name
     * @param sticker {@link InputSticker} - information about the added sticker. If exactly the same sticker
     *                                   had already been added to the set, then the set isn't changed.
     */
    public AddStickerToSet(long userId, @NotNull String name, @NotNull InputSticker sticker) {
        super(Response.class, attachName(sticker), attachment(sticker));
        addParameter("user_id", userId);
        addParameter("name", name);
        addParameter("sticker", sticker);
    }

    //region Utils

    private static String attachName(@NotNull InputSticker sticker) {
        return sticker.getAttachment() != null ? sticker.getAttachName() : "sticker_id";
    }

    private static Object attachment(@NotNull InputSticker sticker) {
        return sticker.getAttachment() != null ? sticker.getAttachment() : "sticker_id";
    }

    //endregion
}