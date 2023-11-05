package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to delete a sticker from a set created by the bot. Returns True on success.
 * @author ezuykow
 */
public class DeleteStickerFromSet extends Request<DeleteStickerFromSet, Response> {

    /**
     * @param sticker File identifier of the sticker
     */
    public DeleteStickerFromSet(@NotNull String sticker) {
        super(Response.class);
        addParameter("sticker", sticker);
    }
}