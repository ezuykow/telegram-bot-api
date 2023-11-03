package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.MessagesResponse;
import kz.pandev.legrambotapi.models.types.common.input.media.InputMedia;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Use this method to send a group of photos, videos, documents or audios as an album.
 * Documents and audio files can be only grouped in album with messages of the same type.
 * On success, an array of Messages that were sent is returned.
 * @author ezuykow
 */
@Getter
public class SendMediaGroup extends Request<SendMediaGroup, MessagesResponse> {

    /**
     * True if request is multipart
     */
    private boolean isMultipart;
    /**
     * Optional. Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     */
    private Integer messageThreadId;
    /**
     * Optional. Sends messages silently. Users will receive a notification with no sound.
     */
    private Boolean disableNotification;
    /**
     * Optional. If the messages are a reply, ID of the original message
     */
    private Integer replyToMessageId;
    /**
     * Optional. Pass True if the message should be sent even if the specified replied-to message is not found
     */
    private Boolean allowSendingWithoutReply;

    /**
     * @param chatId unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param media list describing messages to be sent, must include 2-10 items
     */
    public SendMediaGroup(@NotNull Object chatId, @NotNull InputMedia<?>... media) {
        super(MessagesResponse.class);
        this.isMultipart = false;
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
     * Set parameter {@link SendMediaGroup#messageThreadId}
     * @param messageThreadId new parameter value
     * @return this request
     */
    public SendMediaGroup messageThreadId(int messageThreadId) {
        this.messageThreadId = messageThreadId;
        return addParameter("message_thread_id", messageThreadId);
    }

    /**
     * Set parameter {@link SendMediaGroup#disableNotification}
     * @param disableNotification new parameter value
     * @return this request
     */
    public SendMediaGroup disableNotification(boolean disableNotification) {
        this.disableNotification = disableNotification;
        return addParameter("disable_notification", disableNotification);
    }

    /**
     * Set parameter {@link SendMediaGroup#replyToMessageId}
     * @param replyToMessageId new parameter value
     * @return this request
     */
    public SendMediaGroup replyToMessageId(int replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
        return addParameter("reply_to_message_id", replyToMessageId);
    }

    /**
     * Set parameter {@link SendMediaGroup#allowSendingWithoutReply}
     * @param allowSendingWithoutReply new parameter value
     * @return this request
     */
    public SendMediaGroup allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        this.allowSendingWithoutReply = allowSendingWithoutReply;
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