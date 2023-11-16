package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.MessagesResponse;
import kz.pandev.legrambotapi.models.types.common.input.media.InputMedia;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Use this method to send a group of photos, videos, documents or audios as an album.
 * Documents and audio files can be only grouped in album with messages of the same type.
 * On success, an array of Messages that were sent is returned.
 * @author ezuykow
 */
public class SendMediaGroup extends Request<SendMediaGroup, MessagesResponse> {

    /**
     * True if request is multipart
     */
    private boolean isMultipart;

    /**
     * @param chatId unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param media list describing messages to be sent, must include 2-10 items
     */
    public SendMediaGroup(@NotNull Object chatId, @NotNull InputMedia<?>... media) {
        super(MessagesResponse.class);
        addParameter("chat_id", chatId);
        addParameter("media", media);

        for (InputMedia<?> m : media) {
            Map<String, Object> attachments = m.getAttachments();
            if (attachments != null && !attachments.isEmpty()) {
                addAllParameters(attachments);
                this.isMultipart = true;
            }
            if (m.getInputFile() != null) {
                addParameter(m.getInputFileAttachName(), m.getInputFile());
                this.isMultipart = true;
            }
        }
    }

    //region API

    /**
     * Set parameter message_thread_id
     * @param messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @return this request
     */
    public SendMediaGroup messageThreadId(int messageThreadId) {
        return addParameter("message_thread_id", messageThreadId);
    }

    /**
     * Set parameter disable_notification
     * @param disableNotification Sends messages silently. Users will receive a notification with no sound.
     * @return this request
     */
    public SendMediaGroup disableNotification(boolean disableNotification) {
        return addParameter("disable_notification", disableNotification);
    }

    /**
     * Set parameter reply_to_message_id
     * @param replyToMessageId If the messages are a reply, ID of the original message
     * @return this request
     */
    public SendMediaGroup replyToMessageId(int replyToMessageId) {
        return addParameter("reply_to_message_id", replyToMessageId);
    }

    /**
     * Set parameter allow_sending_without_reply
     * @param allowSendingWithoutReply Pass True if the message should be sent even if the specified replied-to
     *                                message is not found
     * @return this request
     */
    public SendMediaGroup allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        return addParameter("allow_sending_without_reply", allowSendingWithoutReply);
    }

    /**
     * @return true if request is multipart
     */
    @Override
    public boolean isMultipart() {
        return isMultipart;
    }

    //endregion
}