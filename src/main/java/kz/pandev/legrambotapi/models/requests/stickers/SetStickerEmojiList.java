package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Use this method to change the list of emoji assigned to a regular or custom emoji sticker.
 * The sticker must belong to a sticker set created by the bot. Returns True on success.
 * @author ezuykow
 */
public class SetStickerEmojiList extends Request<SetStickerEmojiList, Response> {

    /**
     * @param sticker File identifier of the sticker
     * @param emojiList List of 1-20 emoji associated with the sticker
     */
    public SetStickerEmojiList(@NotNull String sticker, @NotNull List<String> emojiList) {
        super(Response.class);
        addParameter("sticker", sticker);
        addParameter("emoji_list", emojiList);
    }
}