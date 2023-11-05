package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.stickers.GetStickerSetResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to get a sticker set. On success, a StickerSet object is returned.
 * @author ezuykow
 */
public class GetStickerSet extends Request<GetStickerSet, GetStickerSetResponse> {

    /**
     * @param name Name of the sticker set
     */
    public GetStickerSet(@NotNull String name) {
        super(GetStickerSetResponse.class);
        addParameter("name", name);
    }
}