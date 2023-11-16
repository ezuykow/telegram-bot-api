package kz.pandev.legrambotapi.models.requests.common.edit;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.input.media.InputMedia;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Use this method to edit animation, audio, document, photo, or video messages.
 * If a message is part of a message album, then it can be edited only to an audio
 * for audio albums, only to a document for document albums and to a photo or a video
 * otherwise. When an inline message is edited, a new file can't be uploaded; use a
 * previously uploaded file via its file_id or specify a URL. On success, if the edited
 * message is not an inline message, the edited Message is returned, otherwise True is returned.
 * @author ezuykow
 */
public class EditMessageMedia extends Request<EditMessageMedia, Response> {

    private boolean isMultipart;
    private InputMedia<?> media;

    /**
     * @param chatId Unique identifier for the target chat or username
     *               of the target channel (in the format @channelusername)
     * @param messageId Identifier of the message to edit
     * @param media new media content of the message
     */
    public EditMessageMedia(@NotNull Object chatId, int messageId, @NotNull InputMedia<?> media) {
        super(SendResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("message_id", messageId);
            addMedia(media);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    /**
     * @param inlineMessageId Identifier of the inline message
     * @param media new media content of the message
     */
    public EditMessageMedia(@NotNull String inlineMessageId, @NotNull InputMedia<?> media) {
        super(Response.class);
        addParameter("inline_message_id", inlineMessageId);
        addMedia(media);
    }

    //region API

    /**
     * Set parameter reply_markup
     * @param replyMarkup An inline keyboard.
     * @return this request
     */
    public EditMessageMedia replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return addParameter("reply_markup", replyMarkup);
    }

    /**
     * @return true if request is multipart
     */
    @Override
    public boolean isMultipart() {
        return isMultipart;
    }

    /**
     * @return content parameter file name
     */
    @Override
    public String getFileName() {
        return media.getFileName();
    }

    /**
     * @return content parameter mime type
     */
    @Override
    public String getContentMimeType() {
        return media.getContentType();
    }

    //endregion
    //region Utils

    private void addMedia(InputMedia<?> media) {
        this.media = media;
        addParameter("media", media);
        Map<String, Object> attachments = media.getAttachments();
        if (attachments != null && !attachments.isEmpty()) {
            addAllParameters(attachments);
            isMultipart = true;
        }
        if (media.getInputFile() != null) {
            addParameter(media.getInputFileAttachName(), media.getInputFile());
            isMultipart = true;
        }
    }

    //endregion
}