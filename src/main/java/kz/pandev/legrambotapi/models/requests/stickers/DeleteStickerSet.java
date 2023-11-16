package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to delete a sticker set that was created by the bot. Returns True on success.
 * @author ezuykow
 */
public class DeleteStickerSet extends Request<DeleteStickerSet, Response> {

    /**
     * @param name Sticker set name
     */
    public DeleteStickerSet(@NotNull String name) {
        super(Response.class);
        addParameter("name", name);
    }
}