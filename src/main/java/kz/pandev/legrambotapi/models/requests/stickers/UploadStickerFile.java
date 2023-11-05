package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.models.requests.AbstractUploadRequest;
import kz.pandev.legrambotapi.models.responses.common.get.GetFileResponse;
import kz.pandev.legrambotapi.models.types.stickers.Sticker;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to upload a file with a sticker for later use in the createNewStickerSet and addStickerToSet
 * methods (the file can be used multiple times). Returns the uploaded File on success.
 * @author ezuykow
 */
public class UploadStickerFile extends AbstractUploadRequest<UploadStickerFile, GetFileResponse> {

    /**
     * @param userId User identifier of sticker file owner
     * @param sticker A file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format. Type must be java.io.File or byte[]
     * @param stickerFormat Format of the sticker, must be one of “static”, “animated”, “video”
     * @see Sticker.Format
     */
    public UploadStickerFile(long userId, @NotNull Object sticker, @NotNull Sticker.Format stickerFormat) {
        super(GetFileResponse.class, "sticker", sticker);
        addParameter("user_id", userId);
        addParameter("sticker_format", stickerFormat.getTextVal());
    }
}