package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.stickers.MaskPosition;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to change the mask position of a mask sticker. The sticker must belong
 * to a sticker set that was created by the bot. Returns True on success.
 * @author ezuykow
 */
@Getter
public class SetStickerMaskPosition extends Request<SetStickerMaskPosition, Response> {

    /**
     *  {@link MaskPosition} - Position where the mask should be placed on faces. Omit the parameter
     *  to remove the mask position.
     */
    @Nullable
    private MaskPosition maskPosition;

    /**
     * @param sticker File identifier of the sticker
     */
    public SetStickerMaskPosition(@NotNull String sticker) {
        super(Response.class);
        addParameter("sticker", sticker);
    }

    //region API

    /**
     * Set parameter {@link SetStickerMaskPosition#maskPosition}
     * @param maskPosition new parameter value
     * @return this request
     */
    public SetStickerMaskPosition maskPosition(@NotNull MaskPosition maskPosition) {
        this.maskPosition = maskPosition;
        return addParameter("mask_position", maskPosition);
    }

    //endregion
}