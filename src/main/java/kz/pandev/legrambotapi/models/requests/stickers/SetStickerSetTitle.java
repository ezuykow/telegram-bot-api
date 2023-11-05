package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to set the title of a created sticker set. Returns True on success.
 * @author ezuykow
 */
public class SetStickerSetTitle extends Request<SetStickerSetTitle, Response> {

    /**
     * @param name Sticker set name
     * @param title Sticker set title, 1-64 characters
     */
    public SetStickerSetTitle(@NotNull String name, @NotNull String title) {
        super(Response.class);
        addParameter("name", name);
        addParameter("title", title);
    }
}