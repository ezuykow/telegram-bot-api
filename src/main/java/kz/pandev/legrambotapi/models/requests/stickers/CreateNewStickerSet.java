package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.stickers.InputSticker;
import kz.pandev.legrambotapi.models.types.stickers.Sticker;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker
 * set thus created. Returns True on success.
 * @author ezuykow
 */
@Getter
public class CreateNewStickerSet extends Request<CreateNewStickerSet, Response> {

    /**
     * Optional. Type of stickers in the set, pass “regular”, “mask”, or “custom_emoji”.
     * By default, a regular sticker set is created.
     */
    @Nullable
    private Sticker.Type stickerType;
    /**
     * Optional. Pass True if stickers in the sticker set must be repainted to the color of text
     * when used in messages, the accent color if used as emoji status, white on chat photos, or
     * another appropriate color based on context; for custom emoji sticker sets only
     */
    @Nullable
    private Boolean needsRepainting;

    /**
     * @param userId User identifier of created sticker set owner
     * @param name Short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals).
     *            Can contain only English letters, digits and underscores. Must begin with a letter,
     *            can't contain consecutive underscores and must end in "_by_&lt;bot_username&gt;". &lt;bot_username&gt;
     *            is case insensitive. 1-64 characters.
     * @param title Sticker set title, 1-64 characters
     * @param stickers List of 1-50 initial stickers to be added to the sticker set
     * @param stickerFormat Format of stickers in the set, must be one of “static”, “animated”, “video”
     * @see Sticker.Format
     */
    public CreateNewStickerSet(long userId, @NotNull String name, @NotNull String title,
                               @NotNull List<InputSticker> stickers, @NotNull Sticker.Format stickerFormat) {
        super(Response.class);
        addParameter("user_id", userId);
        addParameter("name", name);
        addParameter("title", title);
        addParameter("stickers", stickers);
        addParameter("sticker_format", stickerFormat.getTextVal());
        for (InputSticker sticker : stickers) {
            if (sticker.getAttachment() != null) {
                addParameter(sticker.getAttachName(), sticker.getAttachment());
            }
        }
    }

    //region API

    /**
     * Set parameter {@link CreateNewStickerSet#stickerType}
     * @param stickerType new parameter value
     * @return this request
     */
    public CreateNewStickerSet stickerType(Sticker.Type stickerType) {
        this.stickerType = stickerType;
        return addParameter("sticker_type", stickerType.getTextVal());
    }

    /**
     * Set parameter {@link CreateNewStickerSet#needsRepainting}
     * @param needsRepainting new parameter value
     * @return this request
     */
    public CreateNewStickerSet needsRepainting(boolean needsRepainting) {
        this.needsRepainting = needsRepainting;
        return addParameter("needs_repainting", needsRepainting);
    }

    //endregion
}