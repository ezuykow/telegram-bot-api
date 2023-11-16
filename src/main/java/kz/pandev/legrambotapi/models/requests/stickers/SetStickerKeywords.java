package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Use this method to change search keywords assigned to a regular or custom emoji sticker.
 * The sticker must belong to a sticker set created by the bot. Returns True on success.
 * @author ezuykow
 */
public class SetStickerKeywords extends Request<SetStickerKeywords, Response> {

    /**
     * @param sticker File identifier of the sticker
     */
    public SetStickerKeywords(@NotNull String sticker) {
        super(Response.class);
        addParameter("sticker", sticker);
    }

    //region API

    /**
     * Set parameter keywords
     * @param keywords List of 0-20 search keywords for the sticker with total length of up to 64 characters
     * @return this request
     */
    public SetStickerKeywords keywords(@NotNull List<String> keywords) {
        return addParameter("keywords", keywords);
    }

    //endregion
}