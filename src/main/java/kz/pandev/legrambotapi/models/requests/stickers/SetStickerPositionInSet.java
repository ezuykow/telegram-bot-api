package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to move a sticker in a set created by the bot to a specific position. Returns True on success.
 * @author ezuykow
 */
public class SetStickerPositionInSet extends Request<SetStickerPositionInSet, Response> {

    /**
     * @param sticker File identifier of the sticker
     * @param position New sticker position in the set, zero-based
     */
    public SetStickerPositionInSet(@NotNull String sticker, int position) {
        super(Response.class);
        addParameter("sticker", sticker);
        addParameter("position", position);
    }
}