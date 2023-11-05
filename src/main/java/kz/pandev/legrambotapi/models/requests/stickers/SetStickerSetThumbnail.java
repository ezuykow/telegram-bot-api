package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.AbstractUploadRequest;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail
 * file must match the format of the stickers in the set. Returns True on success.
 * @author ezuykow
 */
public class SetStickerSetThumbnail  extends AbstractUploadRequest<AddStickerToSet, Response> {

    /**
     * @param name Sticker set name
     * @param userId User identifier of the sticker set owner
     * @param thumbnail A .WEBP or .PNG image with the thumbnail, must be up to 128 kilobytes in size and have a width
     *                 and height of exactly 100px, or a .TGS animation with a thumbnail up to 32 kilobytes in size,
     *                 or a WEBM video with the thumbnail up to 32 kilobytes in size; Pass a file_id as a String to
     *                 send a file that already exists on the Telegram servers, pass an HTTP URL as a String for
     *                 Telegram to get a file from the Internet, or upload a new one as java.io.File or byte[].
     *                 Animated and video sticker set thumbnails can't be uploaded via HTTP URL.
     */
    public SetStickerSetThumbnail(@NotNull String name, long userId, @NotNull Object thumbnail) {
        super(Response.class, "thumbnail", thumbnail);
        addParameter("name", name);
        addParameter("user_id", userId);
    }

    /**
     * Use for drop thumbnail (first sticker will use as the thumbnail)
     * @param name Sticker set name
     * @param userId User identifier of the sticker set owner
     */
    public SetStickerSetThumbnail(String name, Long userId) {
        super(Response.class, "name", name);
        addParameter("user_id", userId);
    }
}