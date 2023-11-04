package kz.pandev.legrambotapi.models.responses;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.message.MessageId;
import lombok.ToString;

/**
 * Response of requests, which consist {@link MessageId}
 * @author ezuykow
 */
@ToString(callSuper = true)
public class MessageIdResponse extends Response {

    /**
     * Result of request as {@link MessageId}
     */
    @SerializedName("result")
    private MessageId messageId;

    //region API

    /**
     * @return result {@link MessageId}
     */
    public MessageId getMessageIdObject() {
        return messageId;
    }

    /**
     * @return id from result {@link MessageId}
     */
    public Integer getMessageId() {
        return messageId.getId();
    }

    //endregion
}